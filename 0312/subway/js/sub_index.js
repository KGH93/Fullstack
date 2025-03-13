$(function(){
    var slidver = $('.slider1').bxSlider({
        auto: true,
        pager: true,
        controls: true,
    });

    $('.s2s1').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
         moveSlides: 4,     
        slideWidth: 350,   
        minSlides: 4,      
        maxSlides: 4,      
        slideMargin: 30,    
        pager:true,           
        autoHover: true,   
        controls: true,    
    });
    $('.s2s3').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
         moveSlides: 4,     
        slideWidth: 350,   
        minSlides: 4,      
        maxSlides: 4,      
        slideMargin: 30,    
        pager:true,           
        autoHover: true,   
        controls: true,    
    });
    $('.s2s2').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
         moveSlides: 1,     
        slideWidth: 350,   
        minSlides: 1,      
        maxSlides: 1,      
        slideMargin: 30,    
        pager:true,           
        autoHover: true,   
        controls: true,    
    });
    $('.s2s4').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
         moveSlides: 1,     
        slideWidth: 350,   
        minSlides: 1,      
        maxSlides: 1,      
        slideMargin: 30,    
        pager:true,           
        autoHover: true,   
        controls: true,    
    });
    
    $('.slider3').bxSlider( {
        mode: 'horizontal',
        speed: 500,        
        pause: 2000,
         moveSlides: 1,     
        slideWidth: 300,   
        minSlides: 1,      
        maxSlides: 1,      
        slideMargin: 30, 
        auto:true,   
        pager:true,           
        autoHover: true,   
        controls: false,    
    });

    $('nav > ul > li').click(function(){
		$('li').removeClass('on');
		$(this).addClass('on');
	});
});

