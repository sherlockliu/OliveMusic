// need to be done.

var olive = olive || {};

olive.ui = olive.ui || {};

(function ($) {
    $.fn.selectBox = function (options) {
        var settings = $.extend({}, $.fn.selectBox.defauts, options);
    }
    $.fn.selectBox.defauts = {
        modual:true
    };
}(jQuery))