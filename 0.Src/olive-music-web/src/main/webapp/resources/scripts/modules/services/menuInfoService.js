/**
 * Created by user on 2017/4/8.
 */
define(['jQuery','AjaxPromise','serviceFactory'],function(require,exports,module){
    "use strict";
    var AjaxPromise = require('AjaxPromise'),
        serviceFactory = require('serviceFactory'),
        menuInfoService = {};
    menuInfoService.getCurrentUserMenuList = function(){
        let promise = new AjaxPromise({
            url:'home/getAuthorizationMenuList'.serverPath(),
            dataType:'JSON'
        })
        return promise;
    }
    serviceFactory.register('menuInfoService',menuInfoService);
    module.exports = menuInfoService;
})
