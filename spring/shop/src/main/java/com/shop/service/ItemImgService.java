package com.shop.service;

import com.shop.entity.ItemImg;
import com.shop.repository.ItemImgRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
@Service
@Transactional
@RequiredArgsConstructor
public class ItemImgService {


    @Value("${itemImgLocation}")
    private String itemImgLocation;

    private final ItemImgRepository itemImgRepository;
    private final FileService fileService;

    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception{
        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";
        //원본파일명이 비어있지 않을시만 동작
        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl = "/images/item/" + imgName;
        }
        //실제 디스크 d:/shop/item 파일은 저장되고
        //웹요청시 addResourceHandler("/images/**") 매핑된 경로
        //images/item/저장파일명을 사용합니다.
        //상품 이미지 정보 저장
        itemImg.updateItemImg(oriImgName,imgName,imgUrl);
        itemImgRepository.save(itemImg);
    }



    public void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception{
        if (!itemImgFile.isEmpty()) {  //새로운 이미지 선택
            ItemImg saveItemImg = itemImgRepository.findById(itemImgId)
                    .orElseThrow(EntityNotFoundException::new);

            //기존 이미지 파일 삭제
            if(!StringUtils.isEmpty(saveItemImg.getImgName())){
                fileService.deleteFile(itemImgLocation + "/" + saveItemImg.getImgName());
            }

            String oriImgName = itemImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            String imgUrl = "/images/item/" + imgName;
            //ENTITY 필드만 갱신한걸로 save 하지 않아도 저장
            saveItemImg.updateItemImg(oriImgName,imgName,imgUrl);
            itemImgRepository.save(saveItemImg);
            //JPA 변경감지에 의해 업데이트 내용이 자동저장
        }
    }


}
