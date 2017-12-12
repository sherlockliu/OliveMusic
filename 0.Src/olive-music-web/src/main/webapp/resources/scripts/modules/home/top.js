/**
 * Created by user on 2017/4/8.
 */
define(function(require,exports,module){
    "use strict";
    var siteMap = (function ($) {
        var instance = {};
        instance.render = function (data) {
            var $breadcrumb = $('.breadcrumb');
            var primaryMenu = $('<li><li class="' + data['icon'] + '"></li>' + data['menuName'] + '</li>');
            $breadcrumb.append(primaryMenu);
            if (data.secondMenuName !== undefined) {
                var secondMenu = $('<li class="active">' + data.secondMenuName + '</li>');
            }
        }
        return instance;
    }(window.jQuery))

    function resize() {
        var contentHeight = document.getElementById('mainFrame').contentWindow.document.body.offsetHeight;
        contentHeight = contentHeight < 800 ? 800 : contentHeight;
        document.getElementById('mainFrame').style.height = contentHeight + 'px';
        //$("#mainFrame").height($("#mainFrame").contents().find("body").height());
        $('.page-content').height(contentHeight + 'px');
    }
    module.exports = {
        resize:resize,
        siteMap:siteMap
    }
})