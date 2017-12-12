define(['olive'],function(require,exports,module){
    var olive = require('olive');

    olive.resource = (function (resource) {
        resource.statusCode = resource.statusCode || {};
        resource.statusCode.success = 200;
        resource.statusCode.serverError = 500;
        return resource;
    }(olive.resource||{}))

});