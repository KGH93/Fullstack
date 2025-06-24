package com.shop.repository;

import com.shop.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);

    ItemImg findByItemIdAndRepImgYn(Long itemId, String repImgYn);

//    Spring Data JPA의 쿼리 메서드(Query Method) 중 하나로, 메서드 이름만으로 SQL 없이 데이터를 조회하는 기능을 제공합니다:
//    findByItemIdAndRepimgYn
//    ItemImg 테이블(Entity)에서 조건에 맞는 데이터를 찾겠다는 뜻입니다.
//
//    ItemId가 주어진 itemId와 같고,
//
//    RepImgYn이 주어진 repImgYn과 같은 데이터를 찾습니다.
}
