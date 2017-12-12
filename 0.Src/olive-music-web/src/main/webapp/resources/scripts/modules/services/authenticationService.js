/**
 * Created by user on 2017/4/7.
 */
define(['AjaxPromise','serviceFactory'],function(require,exports,module){
    "use strict";
    var AjaxPromise = require('AjaxPromise'),
        serviceFactory = require('serviceFactory'),
        authenticationService = {};
    authenticationService.login = function(data){
        let promise = new AjaxPromise({
            url:'sys_internal_user/login'.serverPath(),
            data:data.data
        })
        return promise;
    };
    authenticationService.logOut = function(data){
        let promise = new AjaxPromise({
            url:'sys_internal_user/logOut'.serverPath(),
            data:data.data
        })
        return promise;
    };
    serviceFactory.register('authenticationService',authenticationService);
    module.exports = authenticationService;
})
