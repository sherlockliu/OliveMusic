/**
 * Created by user on 2017/4/6.
 */
define(['jQuery'],function(require,exports,module){
    "use strict";
    $.fn.overlay = function (options) {
        var settings = $.extend({}, $.fn.overlay.defauts, options);
        var $box = $(this);
        var $remove = false;
        var method = arguments[0];//method name

        var methods = {
            load: function (options) {
                $(this).blur();
                if ($box.css('position') == 'static') {
                    $remove = true;
                    $box.addClass('position-relative');
                }
                $box.append('<div class="widget-box-overlay"><i class="icon-spinner icon-spin icon-2x white"></i></div>');
            },
            close: function (options) {
                $box.find('.widget-box-overlay').remove();
                if ($remove) {
                    $box.removeClass('position-relative')
                };
            }
        };
        var args = null;
        if (methods[method]) {
            method = methods[method];
            args = Array.prototype.slice.call(arguments, 1);
        } else if (typeof method === "object" || !method) {
            method = methods.load;
        } else {
            $.error("Method" + method + "does not exist on jQuery.pluginName");
            return this;
        }
        return method.apply(this, args);
    }
    $.fn.overlay.defauts = {
        //loadComplete:null
    };
    module.exports = $.fn.overlay;
    return $.fn.overlay;
})
