package com.springboot.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Cart implements Serializable {

    private static final long serialVersionUID = 2155125089108199199L;
    private String cartId;
    private Map<String,CartItem> cartItems;

    private BigDecimal grandTotal;
    public Cart(){
        cartItems = new HashMap<String,CartItem>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId){
        this();
        this.cartId = cartId;
    }


    public void removeCartItem(CartItem item){
        String bookId = item.getBook().getBookId();  //아이템에 들어잇는 book의 bookid를 꺼내기
        cartItems.remove(bookId);
        updateGrandTotal();
    }

    private void updateGrandTotal() {
        grandTotal = new BigDecimal(0);
        for(CartItem item : cartItems.values()){
            grandTotal = grandTotal.add(item.getTotalPrice());
        }
    }

    public void addCartItem(CartItem item){
        String bookId = item.getBook().getBookId();
        if(cartItems.containsKey(bookId)){
            CartItem cartItem = cartItems.get(bookId);
            cartItem.setQuantity(cartItem.getQuantity()+item.getQuantity());  //동일한 책이 카트에있으면 수량만 증가
            cartItems.put(bookId,cartItem);
        }else{
            cartItems.put(bookId,item);
        }
        updateGrandTotal();
    }

}
