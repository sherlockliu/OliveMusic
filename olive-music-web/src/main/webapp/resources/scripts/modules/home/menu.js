/**
 * Created by user on 2017/4/8.
 */
define(['olive','overlay'],function(require,exports,module){
    "use strict";
        var instance = {};

        instance.loading = function (containerId) {
            var $view = $('#' + containerId);
            require('overlay');
            $view.height('350px').overlay('load');
        }
        instance.complete = function (containerId) {
            var $view = $('#' + containerId);
            $view.overlay('close');
        }
        instance.dataBind = function (viewId, menuData) {
            var view = $("#" + viewId);
            $.each(menuData, function (index, obj) {
                var container = $('<li></li>');
                if (index == 0) {
                    container.addClass('active');
                    instance.setDefaultPage(obj.menuId);
                }

                var alink = $('<a href="#"></a>');
                alink.attr('id', obj.menuId);
                alink.attr('parentId', obj.parentId);
                var li = $('<i class="' + obj.menuIcon + '"></i>');
                var span = $('<span class="menu-text">' + obj.menuName + '</span>');
                alink.append(li);
                alink.append(span);
                if (obj.menuUrl !== '') {
                    alink.attr('url', obj.menuUrl);
                    alink.attr('onclick', 'return homeController.loadPage(this)');
                } else {
                    alink.addClass('dropdown-toggle');
                    alink.append($('<b class="arrow icon-angle-down"></b>'));
                }
                container.append(alink);

                if (obj.subMenu != null) {
                    var subContainer = $('<ul class="submenu"></ul>');
                    $.each(obj.subMenu, function (index, obj) {
                        var subli = $('<li></li>');
                        var subAlink = $('<a href="#" url="' + obj.menuUrl + '" onclick="return homeController.loadPage(this)"><i class="' + obj.menuIcon + '"></i>' + obj.menuName + '</a>');
                        subli.append(subAlink);
                        subContainer.append(subli);
                    })
                    container.append(subContainer);
                }
                view.append(container);
            });
        }
        instance.setDefaultPage = function (pageId) {
            instance.defaultPage = pageId;
        }
        instance.loadDefaultPage = function (pageId) {
            var defaultPage = $("#" + instance.defaultPage);
            if (defaultPage.length > 0) {
                defaultPage.click();
            }
        };
    module.exports = instance;
})
