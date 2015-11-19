/**
 * Author : Hemrajsinh Gharia Date : 30/10/2014
 */
$(document).ready(function() {
    $('#personform').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	firstname: {
                message: 'The firstname is not valid',
                validators: {
                    notEmpty: {
                        message: 'Please enter your firstname'
                    }                  
                }
            },
            lastname: {
                message: 'The lastname is not valid',
                validators: {
                    notEmpty: {
                        message: 'Please enter your lastname'
                    }                  
                }
            },
            zip: {
                message: 'The zip is not valid',
                validators: {
                    notEmpty: {
                        message: 'Please enter zip code'
                    }                  
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'Please enter a valid email address'
                    }
                }
            },
            mobileno: {
                message: 'The mobile no is not valid',
                validators: {
                    notEmpty: {
                        message: 'Please enter mobile no'
                    }                  
                }
            }
        }
    });
    
    //Change css of error block
    $("span.error").closest("div").addClass('has-error');
    $("span.error").addClass('help-block');
});