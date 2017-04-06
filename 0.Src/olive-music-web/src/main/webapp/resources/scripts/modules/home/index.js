/**
 * Created by user on 2017/4/6.
 */

var homeController = (function ($) {
    var instance = {};
    instance.loadPage = function (linkObj) {
        displaySpinner();
        var url = $(linkObj).attr('url');
        if (url !== '') {
            $('#mainFrame').load(function () {
                setTimeout(homeController.resizeFrame, 100);
            });
            $('#mainFrame').attr('src', url);
        }
        return false;
    };
    instance.init = function () {
        menuView.loading('sidebar');
        var service = olive.serviceFacory.getService('menuInfoService');
        service.getCurrentUserMenuList(function (data) {
            menuView.dataBind('menuView', data);
            menuView.complete('sidebar');
            menuView.loadDefaultPage();
        });
    };
    instance.resizeFrame = function () {
        resize();//TODO
    };
    instance.logOut = function () {
        var service = olive.serviceFacory.getService('authenticationService');
        service.logOut(function () {
            window.location.href = '@Url.Content("~/InternalUser/Login")';
        });
    }
    return instance;
}(window.jQuery));

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
$(document).ready(function () {
    homeController.init();
});
var spinner;
var isSpinnerClosed = true;
function displaySpinner() {
    var opts = {
        lines: 13, // loading小块的数量
        length: 7, // 小块的长度
        width: 4, // 小块的宽度
        radius: 10, // 整个圆形的半径
        corners: 1, // 小块的圆角，越大则越圆
        rotate: 0, // loading动画的旋转度数，貌似没什么实际作用
        color: '#000', // 颜色
        speed: 1, // 变换速度
        trail: 60, // 余晖的百分比
        shadow: false, // 是否渲染出阴影
        hwaccel: false, // 是否启用硬件加速
        className: 'spinner', // 给loading添加的css样式名
        zIndex: 2e9, // The z-index (defaults to 2000000000)
        top: 'auto', // Top position relative to parent in px
        left: 'auto' // Left position relative to parent in px
    };
    var target = document.getElementById('iframeContainer');
    if (isSpinnerClosed) {
        spinner = new Spinner(opts).spin(target);
    }
    isSpinnerClosed = false;
}
function hideSpinner() {
    spinner.stop();
    isSpinnerClosed = true;
}
function resize() {
    var contentHeight = document.getElementById('mainFrame').contentWindow.document.body.offsetHeight;
    contentHeight = contentHeight < 800 ? 800 : contentHeight;
    document.getElementById('mainFrame').style.height = contentHeight + 'px';
    //$("#mainFrame").height($("#mainFrame").contents().find("body").height());
    $('.page-content').height(contentHeight + 'px');
}
