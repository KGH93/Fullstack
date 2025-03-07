$(function(){
    var visual = $('#brandVisual > ul > li');  //큰사진
    var button = $('#buttonList > li');  //page 버튼
    var current = 0; //현재의 인덱스번호를 기억
    var id;
    var i = 0;

    button.click(function(){
        i = $(this).index(); //클릭한 버튼의 인덱스 번호
        // alert(i);
        button.removeClass('on');
        button.eq(i).addClass('on');
        move();
        return false;
    });

    timer();
    function timer(){
        id = setInterval(function(){
            var n = current + 1
            console.log(n);
            if(n === 3) n = 0;
            button.eq(n).trigger('click');
            // n번째 버튼을 3초마다 강제로 클릭 
        },3000);
    };


    function move(){
        if(current == i) return;
        //현재 활성화된 button과 클릭한 button이 같으면 빠져 나간다.
        var cu = visual.eq(current); //현재사진
        var ne = visual.eq(i);  //슬라이드되서 들어올사진
        cu.css('left','0').stop().animate({'left':'-100%'},500);
        ne.css('left','100%').stop().animate({'left':'0%'},500);
        current=i;
    };
});