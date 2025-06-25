package com.shop.service;

import com.shop.dto.CartDetailDto;
import com.shop.dto.CartItemDto;
import com.shop.dto.CartOrderDto;
import com.shop.dto.OrderDto;
import com.shop.entity.Cart;
import com.shop.entity.CartItem;
import com.shop.entity.Item;
import com.shop.entity.Member;
import com.shop.repository.*;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public Long addCart(CartItemDto cartItemDto, String email){
        Item item = itemRepository.findById(cartItemDto.getItemId()).orElseThrow(EntityExistsException::new);
        Member member = memberRepository.findByEmail(email);
        Cart cart = cartRepository.findByMemberId(member.getId());

        if(cart == null){
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }
        //동일한 상품(itemId) 이 이미 현재 회원의 장바구니(cartId)에 있는지 조회
        CartItem savedCartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());

        if(savedCartItem != null){
            savedCartItem.addCount(cartItemDto.getCount());
            return savedCartItem.getId();
        }else{
            CartItem cartItem = CartItem.createCartItem(cart, item, cartItemDto.getCount());
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }
    }

    @Transactional(readOnly = true)
    public List<CartDetailDto> getCartList(String email){
        List<CartDetailDto> cartDetailDtosList = new ArrayList<>();

        //카트는 멤버당 1개라서 for문을 쓰지않았음 // 써야되는경우 예시) 주문
        Member member = memberRepository.findByEmail(email);
        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null){
            return cartDetailDtosList;
        }
        cartDetailDtosList = cartItemRepository.findCartDetailDtoList(cart.getId());
        return cartDetailDtosList;
    }


    public boolean validateCartItem(Long cartItemId, String email) {
        Member curMember = memberRepository.findByEmail(email);
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(EntityNotFoundException::new);  //optional은 예외처리필수
        Member savedMember = cartItem.getCart().getMember();
        if(!StringUtils.equals(curMember.getEmail(), savedMember.getEmail())){
            return false;
        }
        return true;
    }


    public void updateCartItemCount(Long cartItemId, int count) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(EntityNotFoundException::new);
        cartItem.updateCount(count);
    }


    public void deleteCartItem(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(EntityNotFoundException::new);
        cartItemRepository.delete(cartItem);
        //deleteById보다 delete를 사용하는게 더 정석
    }



    public Long orderCartItem(List<CartOrderDto> cartOrderDtoList, String email){
        // 장바구니 항목 -> 주문 Dto
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (CartOrderDto cartOrderDto : cartOrderDtoList){
            CartItem cartitem = cartItemRepository.findById(cartOrderDto.getCartItemId())
                    .orElseThrow(EntityNotFoundException::new); //장바구니 항모을 하나씩 조회
            OrderDto orderDto = new OrderDto();
            orderDto.setItemId(cartitem.getItem().getId()); //각 항목의 상품Id
            orderDto.setCount(cartitem.getCount()); //각 항목의 수량을 꺼냄
            orderDtoList.add(orderDto);
            //orderService.orders() 에서 이 리스트를 사용
        }
        //주문 생성
        Long orderId = orderService.orders(orderDtoList, email); //주문 생성

        for(CartOrderDto cartOrderDto : cartOrderDtoList){
            CartItem cartItem = cartItemRepository.findById(cartOrderDto.getCartItemId()) //장바구니 항목을 하나씩 조회
                                                    .orElseThrow(EntityNotFoundException::new);
            cartItemRepository.delete(cartItem);
            //주문한 장바구니 항목을 다시 조회해서 삭제
        }
        return orderId;
    }
}
