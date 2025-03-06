$(function(){
    // $('m_menu li ul').css('display','none');
    $('.sub').hide();
    // $('.m_menu li ul').eq(0)show();
    $('.sub').eq(0).show();

    $('.m_menu li a').click(function(){
        var kkk = $(this).next('.sub').css('display');
        //클릭 a 다음에 .sub의 display 상태가 none,block 알아냄
        // alert(kkk);
        if(kkk == "none"){
            $('.sub').slideUp();  //모든 슬라이드를 닫고
            $(this).next('.sub').slideDown();  //클릭한 다음에 sub를 보여줌
        }
        return false;  // a 를 지정할때는 링크막기 필수
    });
});