/**
 * Created by user on 2017/4/8.
 */
define(['jQuery','AjaxPromise','serviceFactory'],function(require,exports,module){
    "use strict";
    var AjaxPromise = require('AjaxPromise'),
        serviceFactory = require('serviceFactory'),
        menuInfoService = {};
    menuInfoService.login = function(data){
        let promise = new AjaxPromise({
            url:'menu_info/list'.serverPath(),
            data:data.data
        })
        return promise;
    }
    serviceFactory.register('menuInfoService',menuInfoService);
    module.exports = menuInfoService;
})
