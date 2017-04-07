/**
 * Created by user on 2017/4/8.
 */
define([],function(require,exports,module){
    "use strict";

    var menuView = (function ($) {
        var instance = {};
        instance.loading = function (containerId) {
            var $view = $('#' + containerId);
            $view.height('50px').overlay('load');
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
                    instance.setDefaultPage(obj.MenuID);
                }

                var alink = $('<a href="#"></a>');
                alink.attr('id', obj.MenuID);
                alink.attr('parentId', obj.ParentID);
                var li = $('<i class="' + obj.MenuIcon + '"></i>');
                var span = $('<span class="menu-text">' + obj.MenuName + '</span>');
                alink.append(li);
                alink.append(span);
                if (obj.MenuURL !== '') {
                    alink.attr('url', obj.MenuURL);
                    alink.attr('onclick', 'return homeController.loadPage(this)');
                } else {
                    alink.addClass('dropdown-toggle');
                    alink.append($('<b class="arrow icon-angle-down"></b>'));
                }
                container.append(alink);

                if (obj.SubMenu != null) {
                    var subContainer = $('<ul class="submenu"></ul>');
                    $.each(obj.SubMenu, function (index, obj) {
                        var subli = $('<li></li>');
                        var subAlink = $('<a href="#" url="' + obj.MenuURL + '" onclick="return homeController.loadPage(this)"><i class="' + obj.MenuIcon + '"></i>' + obj.MenuName + '</a>');
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
        }
        return instance;
    }(window.jQuery))
})
