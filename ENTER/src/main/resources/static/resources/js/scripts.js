(function($) {
    "use strict";

    $('body').scrollspy({
        target: '.navbar-fixed-top',
        offset: 60
    });

    $('#topNav').affix({
        offset: {
            top: 200
        }
    });

    new WOW().init();

    $('a.page-scroll').bind('click', function(event) {
        var $ele = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($ele.attr('href')).offset().top - 55)
        }, 1450, 'easeInOutExpo');
        event.preventDefault();
    });

    $('.navbar-collapse ul li a').click(function() {
        /* always close responsive nav after click */
        $('.navbar-toggle:visible').click();
    });

    $('#galleryModal').on('show.bs.modal', function (e) {
       $('#galleryImage').attr("src",$(e.relatedTarget).data("src"));
    });

    $(document).on('click','body *',function(){
    	    $('.navbar-collapse').removeClass('in');

   	});


     $('#galleryVideoModal').on('show.bs.modal', function (e) {
	     $('#galleryVideoImage').attr("src",$(e.relatedTarget).data("src"));
    });

     $('#galleryVideoModal').on('hidden.bs.modal', function () {
        $('#galleryVideoImage').attr("src",'');
  	})

     $('#YoutubeModal').on('show.bs.modal', function (e) {
         $('#srciframe').attr("src",$(e.relatedTarget).data("src"));
      });
     $('#YoutubeModal').on('hidden.bs.modal', function (e) {
         $('#srciframe').attr('src', '');
      });



})(jQuery);

