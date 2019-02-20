
(function ($) {
    "use strict";
    
    $('#password, #confirm_password').on('keyup', function () {
    	  if ($('#password').val() == $('#confirm_password').val()) {
    	    $('#message').html('Matching').css('color', 'green');
    	  } else 
    	    $('#message').html('Not Matching').css('color', 'red');
    	});
    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'text' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^[-+]?[0-9]+\.[0-9]+$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);

