package com.shop.dto;

import com.shop.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    
    private String itemNm; //상품명
    private int count; //주문수량
    private int orderPrice; //주문금액
    private String imgUrl; //상품 이미지 경로

    public OrderItemDto(OrderItem orderItem, String imgUrl){
        this.itemNm = orderItem.getItem().getItemNm(); //상품명
        this.count = orderItem.getCount(); //주문수량
        this.orderPrice = orderItem.getOrderPrice(); //주문금액
        this.imgUrl = imgUrl; //상품 이미지 경로
    }
}
