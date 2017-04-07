/**
 * Created by user on 2017/4/7.
 */
define('serviceFactory',['jQuery','olive'],function(require,exports,module){
    var olive = require('olive');
    olive.serviceFacory = olive.serviceFacory || {};
    olive.serviceFacory.servicePool = {};
    olive.serviceFacory.register = function(serviceName,service){
            olive.serviceFacory.servicePool[serviceName] = service;
    };
    olive.serviceFacory.resolve = function(serviceName){
        if(serviceName in olive.serviceFacory.servicePool){
            return olive.serviceFacory.servicePool[serviceName];
        }
        throw new Error(`${serviceName} cannot be resolved.`)
    }
    olive.serviceFacory.unRegister = function(serviceName){
        "use strict";
        if(serviceName in olive.serviceFacory.servicePool){
            delete olive.serviceFacory.servicePool[serviceName];
        }
    }
    module.exports = olive.serviceFacory;
})