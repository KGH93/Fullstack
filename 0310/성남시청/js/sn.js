$(function () {
    var sld = $('.slider').bxSlider({
        auto: true,
        controls: false,
        pager: false,
        onSlideAfter: function ($slideElement, oldIndex, newIndex) {
            $('.count span').text(newIndex + 1);
        }
    });
    $('.prev').click(function(){
        sld.goToPrevSlide();
        return false;
    });

    $('.next').click(function(){
        sld.goToNextSlide();
        return false;
    });

    $('.stop').click(function(){
        if( $(this).hasClass('on') === false){
            $(this).addClass('on');
            sld.stopAuto();
        }
        else{
            $(this).removeClass('on');
            sld.startAuto();
        }
        return false;
    });
});
