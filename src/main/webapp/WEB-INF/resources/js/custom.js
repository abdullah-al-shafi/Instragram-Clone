$(window).scroll(function(){
    var $scrolling=$(this).scrollTop();
    if($scrolling > .1){
        $(".navbar").addClass("fixed");
    }
    else{
        $(".navbar").removeClass("fixed");
    }
})