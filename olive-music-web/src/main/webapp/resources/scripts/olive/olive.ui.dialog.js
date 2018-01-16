var modor = olive || {};


olive.ui = (function (module, $) {
    //override dialog's title function to allow for HTML titles
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function (title) {
            var $title = this.options.title || '&nbsp;'
            if (("title_html" in this.options) && this.options.title_html == true)
                title.html($title);
            else title.text($title);
        }
    }));

    var messageTemplate = '<div id="dialog-message" class="hide"></div>';
    var confirmTemplate = '<div id="dialog-confirm" class="hide"></div>';
    var messageDefaults = {
        modal: true,
        title_html: true,
        buttons: [
            {
                text: "确认",
                "class": "btn btn-primary btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    };
    module.dialog = {};
    module.dialog.confirm = function (options) {

    };
    module.dialog.showMessage = function (title, message) {
        if ($('#dialog-message').length == 0) {
            $(messageTemplate).appendTo($('body'));
        }
        $('#dialog-message').html('');
        var title = {
            title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>" + title !== undefined ? title : '提示' + "</h4></div>"
        }
        var settings = $.extend({}, messageDefaults, title);
        if (message !== undefined) {
            $('#dialog-message').append('<p>' + message + '</p>');
        }
        var dialog = $("#dialog-message").removeClass('hide').dialog(settings);
    };
    return module;
}(olive.ui || {}, jQuery))

