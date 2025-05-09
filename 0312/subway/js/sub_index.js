$(function(){
    var slidver = $('.slider1').bxSlider({
        auto: true,
        pager: true,
        controls: false,
    });

    $('.s2slide').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
         moveSlides: 4,     
        slideWidth: 350,   
        minSlides: 4,      
        maxSlides: 4,      
        slideMargin: 30,    
        pager:false,           
        autoHover: true,   
        controls: true,    
    });
    
    $('.slider3').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
        moveSlides: 1,     
        slideWidth: 270,  
        slideHeight: 300, 
        minSlides: 1,      
        maxSlides: 1,      
        slideMargin: 30, 
        auto:true,   
        pager:true,           
        autoHover: true,   
        controls: false,    
    });

    $('#s2page ul li').click(function(){
        if(!$(this).hasClass('none')){
		$('#s2page ul li a').removeClass('on');
		$(this).find('a').addClass('on');
        }
	}); 
});

    
$(function(){
    $('#popup_wrap').draggable();
        
    if($.cookie('popup')==='none'){
        $('#popup_wrap').hide();
    }
    else {
        $('#popup_wrap').show(); 
    }

    var Chk = $("#expireschk");
    $('.closeBtn').on('click',closePop);

    function closePop(){
        if(Chk.is(":checked")){  
            $.cookie('popup','none',{expires:7});
        }
        $('#popup_wrap').fadeOut('fast');
    }
});

