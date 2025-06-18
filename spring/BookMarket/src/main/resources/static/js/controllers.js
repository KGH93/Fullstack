function addToCart(bookid){
    if(confirm("장바구니에 도서를 추가합니까?")==true){
        document.addForm.action="/BookMarket/cart/book/"+bookid;
        document.addForm.submit();
    }
}
function removeFromCart(bookid, cartId) {

	   document.removeForm.action = "/BookMarket/cart/book/"+bookid;
	   document.removeForm.submit();
	   setTimeout('location.reload()',100);
	}
//장바구니에 등록된 도서 항목을 삭제하는 메소드

function clearCart(cartId) {
	if (confirm("모든 도서를 장바구니에서 삭제합니까?")==true){

	   document.clearForm.submit();
	   setTimeout('location.reload()',10);

	}
}