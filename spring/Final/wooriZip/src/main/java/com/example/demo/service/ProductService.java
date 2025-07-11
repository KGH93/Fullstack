package com.example.demo.service;

import com.example.demo.dto.ProductDetailDto;
import com.example.demo.dto.ProductForm;
import com.example.demo.dto.ProductModelDto;
import com.example.demo.entity.*;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductImageRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.access.AccessDeniedException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository imageRepository;
    private final WishlistRepository wishlistRepository;
    private final CategoryRepository categoryRepository;

    // ✅ 상품 등록
    public Long createProduct(ProductForm form,
                              List<MultipartFile> productImgFileList,  // List<MultipartFile>로 수정
                              Users loginUser) throws Exception {
        log.info("상품 등록 시작: {}", form);

        // 1. 카테고리 조회
        Category category = categoryRepository.findById(form.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));

        // 2. Product 생성
        Product product = form.createProduct(category, loginUser);
        product = productRepository.save(product);  // 상품 저장

        // 3. 모델 생성 및 재고 계산
        int totalStock = 0;
        for (ProductModelDto dto : form.getProductModelDtoList()) {
            ProductModel model = new ProductModel();
            model.setProductModelSelect(dto.getProductModelSelect());  // 모델 선택 (예: SUPER_SINGLE, QUEEN, KING)
            model.setPrice(dto.getPrice());  // 가격 설정
            model.setPrStock(dto.getPrStock());  // 재고 설정
            model.setProduct(product);  // 상품에 모델 연결
            product.addProductModel(model);  // 상품에 모델 추가
            totalStock += model.getPrStock();
        }

        product.setStockQuantity(totalStock); // 총 재고량 업데이트
        productRepository.save(product);  // 상품 저장

        // 4. 이미지 업로드 처리
        if (productImgFileList != null && !productImgFileList.isEmpty()) {
            List<String> imagePaths = handleAndReturnFiles(productImgFileList.toArray(new MultipartFile[0]));
            for (String path : imagePaths) {
                ProductImage image = new ProductImage();
                image.setImageUrl(path);
                image.setProduct(product);
                imageRepository.save(image);
            }
        }

        return product.getId();  // 상품 ID만 반환
    }





    // 이미지 저장 유틸 (변경 없음)
    private List<String> handleAndReturnFiles(MultipartFile[] files) {
        List<String> filePaths = new ArrayList<>();
        String uploadDir = System.getProperty("user.dir") + "/uploads/";

        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String originalName = file.getOriginalFilename();
                    String uniqueName = System.currentTimeMillis() + "_" + originalName;
                    File dest = new File(uploadDir + uniqueName);
                    file.transferTo(dest);

                    filePaths.add(uniqueName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return filePaths;
    }

    // ✅ 상품 목록 조회
    public List<Product> findProducts(Long categoryId) {
        if (categoryId == null) {
            return productRepository.findAll(); // 아무 카테고리도 선택 안 했을 경우
        }

        // 선택한 카테고리와 그 하위 카테고리 포함하여 검색
        List<Long> idsToSearch = new ArrayList<>();
        idsToSearch.add(categoryId);
        idsToSearch.addAll(getChildCategoryIds(categoryId));

        return productRepository.findByCategoryIdIn(idsToSearch);
    }

    // 선택된 카테고리의 모든 하위 카테고리 ID를 재귀적으로 가져옴
    private List<Long> getChildCategoryIds(Long parentId) {
        List<Category> children = categoryRepository.findByParentId(parentId);
        List<Long> result = new ArrayList<>();

        for (Category child : children) {
            result.add(child.getId());
            result.addAll(getChildCategoryIds(child.getId())); // 재귀 호출
        }

        return result;
    }

    // ✅ 상품 상세 조회 (찜 여부 포함)
    public ProductDetailDto getProductDetail(Long productId, Users user) {
        // 1. 상품 조회
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        // 2. 사용자가 찜한 상품 여부 체크
        boolean liked = user != null && wishlistRepository.existsByUserAndProduct(user, product);

        // 3. 모델 정보와 가격, 재고 등을 포함한 상세 정보를 DTO로 반환
        List<ProductModelDto> modelDtos = product.getProductModels().stream()
                .map(model -> {
                    ProductModelDto dto = new ProductModelDto();
                    dto.setProductModelSelect(model.getProductModelSelect()); // 모델명
                    dto.setPrice(model.getPrice()); // 가격
                    dto.setPrStock(model.getPrStock()); // 재고
                    return dto;
                }).collect(Collectors.toList());

        // 4. ProductDetailDto 생성 후 모델 정보 설정
        ProductDetailDto detailDto = new ProductDetailDto(product, liked);
        detailDto.setProductModels(modelDtos);  // 모델 정보 추가

        // 5. 반환
        return detailDto;
    }


    // ✅ 상품 수정
    @Transactional
    public void updateProduct(Long productId, ProductForm form, MultipartFile[] images, String deleteIndexes, Users loginUser) {
        Product product = productRepository.findById(productId).orElseThrow();

        if (!product.getUser().getId().equals(loginUser.getId())) {
            throw new AccessDeniedException("권한 없음");
        }

        // 기존 이미지 삭제
        if (deleteIndexes != null && !deleteIndexes.isEmpty()) {
            List<ProductImage> currentImages = product.getImages();
            List<Integer> indexesToDelete = Arrays.stream(deleteIndexes.split(","))
                    .map(Integer::parseInt)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            for (Integer idx : indexesToDelete) {
                if (idx >= 0 && idx < currentImages.size()) {
                    ProductImage removed = currentImages.remove((int) idx);
                    deleteFile(removed.getImageUrl());
                    imageRepository.delete(removed);
                }
            }
        }

        // 새 이미지 업로드
        if (images != null) {
            List<String> imagePaths = handleAndReturnFiles(images);
            for (String path : imagePaths) {
                ProductImage image = new ProductImage();
                image.setImageUrl(path);
                image.setProduct(product);
                product.getImages().add(image);
            }
        }

        // 상품 정보 업데이트
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setDescription(form.getDescription());

        productRepository.save(product);
    }

    // ✅ 파일 삭제 유틸
    private void deleteFile(String relativePath) {
        if (relativePath == null) return;
        String absolutePath = System.getProperty("user.dir") + relativePath;
        File file = new File(absolutePath);
        if (file.exists()) file.delete();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Transactional
    public void deleteProduct(Long id, Users user) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        if (product.getUser() == null || !product.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("상품 삭제 권한이 없습니다.");
        }

        imageRepository.deleteAll(product.getImages());
        product.getProductModels().clear();

        productRepository.delete(product);
    }
}
