define('utils',['jQuery'],function(require,exports,module){
    "use strict";
    var olive = require('olive'),
        jQuery = require('jQuery');

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
            $(`[name=${name}]`).remove();
        };
        instance.getDomain = function () {
            return window.location.orgin;
        };
        instance.absolutePath =  function(path){
            return `${window.location.origin}/${path}/`;
        }
        return instance;
    }(olive.ui || {}, jQuery))

    module.exports = olive.ui.utils;
})
