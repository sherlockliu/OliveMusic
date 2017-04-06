var olive = olive || {};
olive.ui = olive.ui||{};
olive.ui.utils = (function (utils, $) {
    var instance = {};
    function appendFormElement(formId, key, value) {
        var formObj = $("#" + formId);
        formObj.append($("<input type='hidden' name=" + key + " value=" + value + ">"));
    };
    instance.appendFormElement = function (formId, key, value) {
        appendFormElement(formId, key, value);
    };
    instance.clearFormElement = function (name) {
        $('[name=' + name + ']').remove();
    };
    instance.getDomain = function () {
        return window.location.orgin;
    }
    return instance;
}(olive.ui || {}, jQuery));

