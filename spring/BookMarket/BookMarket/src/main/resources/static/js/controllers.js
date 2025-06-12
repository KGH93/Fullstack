function addToCart(bookid){
    if(confirm("장바구니에 도서를 추가합니까?")==true)
        document.addForm.action="/BookMarket/cart/book/"+bookid;
        document.addForm.submit();
}


function removeFromCart(bookid, cartId){
            document.removeForm.action="/BookMarket/cart/book/"+bookid;
            document.removeForm.submit();
            setTimeout('location.reload()', 100);  //새로고침할때 약간 시간간격을 줘서 삭제한 데이터가 잔류하지않게
}
//장바구니에 등록한 도서 항목을 삭제하는 메소드


function clearCart(cartId) {
   if (confirm("모든 도서를 장바구니에서 삭제합니까?")==true){

      document.clearForm.submit();
      setTimeout('location.reload()',100);

   }
}
