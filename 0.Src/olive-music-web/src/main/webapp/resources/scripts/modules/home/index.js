/**
 * Created by user on 2017/4/6.
 */
define(['jQuery','serviceFactory','./menu','spinner','./top'],function(require,exports,module){
    "use strict";
    var spinner = require('spinner'),
        top = require('./top'),
        menu = require('./menu'),
        instance = {};
        instance.loadPage = function (linkObj) {
            spinner.display();
            var url = $(linkObj).attr('url');
            if (url !== '') {
                $('#mainFrame').load(function () {
                    setTimeout(top.resize, 100);
                });
                $('#mainFrame').attr('src', url);
            }
            return false;
        };
        instance.init = function () {
            menu.loading('sidebar');
            var service = olive.serviceFacory.getService('menuInfoService');
            service.getCurrentUserMenuList(function (data) {
                menu.dataBind('menuView', data);
                menu.complete('sidebar');
                menu.loadDefaultPage();
            });
        };
        instance.logOut = function () {
            var service = olive.serviceFacory.getService('authenticationService');
            service.logOut(function () {
                window.location.href = '@Url.Content("~/InternalUser/Login")';
            });
        }
    module.exports = instance;
})