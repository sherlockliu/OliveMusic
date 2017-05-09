/**
 * Created by user on 2017/4/6.
 */
define(['jQuery','serviceFactory','./menu','spinner','./top','services/menuInfoService'],function(require,exports,module){
    "use strict";
    var top = require('./top'),
        menu = require('./menu'),
        instance = {};
        instance.loadPage = function (linkObj) {
            let spinner = require('spinner');
            spinner.display();
            var url = $(linkObj).attr('url');
            if (url !== '') {
                $('#mainFrame').load(function () {
                    setTimeout(top.resize, 100);
                });
                $('#mainFrame').attr('src', url.serverPath());
            }
            return false;
        };
        instance.stopSpinner = function(){
            let spinner = require('spinner');
            spinner.hide();
        };
        instance.init = function () {
            menu.loading('sidebar');
            var service = require('services/menuInfoService');
            service.getCurrentUserMenuList().then((data)=>{
                    menu.dataBind('menuView', JSON.parse(data));
                    menu.complete('sidebar');
                    menu.loadDefaultPage();
            });
        };
        instance.logOut = function () {
            var service = require('services/authenticationService');
            service.logOut(function () {
                window.location.href = '/home/login'.serverPath();
            });
        }
    module.exports = instance;
})