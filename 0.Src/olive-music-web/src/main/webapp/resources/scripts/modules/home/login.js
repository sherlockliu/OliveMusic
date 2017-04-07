define(['jQuery','olive','serviceFactory','overlay','services/authenticationService'],function(require, exports, module){
        //var $ = require('jQuery');
        var serviceFactory = require('serviceFactory');
        var loginController = {};
        loginController.showDialog = function (id) {
            $('.widget-box.visible').removeClass('visible');
            $('#' + id).addClass('visible');
        };
        loginController.login = function () {
            let dto = {};
            dto.userAccount = $('#userAccount').val();
            dto.password = $('#password').val();
            dto.isKeepLogin = $('#isPersistent')[0].checked;
            console.log(dto);
            //if ($('#loginForm').valid()) {
            if (true) {
                $('#login-box').overlay('load');
                setTimeout(function () {
                	try{
                		var service = require('services/authenticationService');
                        service.login({
                            data:dto
                        }).then((result)=>{
                            if(result && result.success){
                                window.location.href = `/home/index`.serverPath();
                            }else{
                                alert('login failed.')//TODO
                                $('#login-box').overlay('close');
                            }
                        }).catch((e)=>{
                        	console.log(e);
                        	$('#login-box').overlay('close');
                        })
                	}catch(e){
                		console.log(e);
                		$('#login-box').overlay('close');
                	}
                }, 50);
            }
        };
        loginController.init = function(){
            if (window.top != window.self) {
                window.top.location.href = window.location.href;
            }
            "use strict";
            $('#loginForm').validate({
                errorElement: 'div',
                errorClass: 'help-block',
                focusInvalid: false,
                rules: {
                    userAccount: {
                        required: true
                    },
                    password: {
                        required: true,
                        minlength: 6
                    },
                    messages: {
                        userAccount: {
                            required: "用户名不能为空."
                        },
                        password: {
                            required: "密码不能为空."
                        }
                    },

                    invalidHandler: function (event, validator) { //display error alert on form submit
                        $('.alert-danger', $('.login-form')).show();
                    },

                    highlight: function (e) {
                        $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
                    },

                    success: function (e) {
                        $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                        $(e).remove();
                    },

                    errorPlacement: function (error, element) {
                        if (element.is(':checkbox') || element.is(':radio')) {
                            var controls = element.closest('div[class*="col-"]');
                            if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
                            else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                        }
                        else if (element.is('.select2')) {
                            error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                        }
                        else if (element.is('.chosen-select')) {
                            error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                        }
                        else error.insertAfter(element.parent());
                    },
                    submitHandler: function (form) {
                    }
                }
            });
        }
        module.exports = loginController;
});