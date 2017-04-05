if (window.top != window.self) {
            window.top.location.href = window.location.href;
}
var loginController = (function ($) {
    var instance = {};
    instance.showDialog = function (id) {
        $('.widget-box.visible').removeClass('visible');
        $('#' + id).addClass('visible');
    }
    instance.login = function () {
            var userAccount = $('#userAccount').val();
            var password = $('#password').val();
            var isKeepLogin = $('#isPersistent')[0].checked;
            var dto = {};
            dto.userAccount = userAccount;
            dto.password = password;
            dto.isKeepLogin = isKeepLogin;

            var isValid = $('#loginForm').valid();
            if (isValid) {
                $('#login-box').overlay('load');
                setTimeout(function () {
                    var service = mordor.serviceFacory.getService('authenticationService');
                    service.login(dto, function (data) {
                        window.location.href = '@Url.Content("~/Home/Index")';
                    })
                }, 50);
            }
    }
    return instance;
}(jQuery));

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
        },
        invalidHandler: function (form) {
        }
    }
});