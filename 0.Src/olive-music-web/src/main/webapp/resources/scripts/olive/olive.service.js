var olive = {};
olive.serviceModule = {};
olive.serviceFacory = (function ($) {
    var instance = {};
    instance.getService = function (serviceName) {
        if (serviceName in olive.serviceModule) {
            return olive.serviceModule[serviceName];
        } else {
            return null;
        }
    }
    return instance;
}(jQuery))

//menuInfo serive
olive.serviceModule = (function (module, $) {
    module.menuInfoService = {};//service name 
    module.menuInfoService.add = function (data, callback) {
        $.ajax({
            type: "POST",
            url: "/Menu/AddMenu",
            data: data,
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };
    module.menuInfoService.remove = function (postData, callback) {
        $.ajax({
            type: "POST",
            url: "/Menu/RemoveMenu",
            data: postData,
            dataType: "POST",
            success: function (data) {
                console.log(data);
                if (data.ResponseCode == 200) {
                    callback();
                }
            }
        });
    };
    module.menuInfoService.update = function (postData, callback) {
        $.ajax({
            type: "POST",
            url: "/Menu/UpdateMenu",
            data: postData,
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };
    module.menuInfoService.getMenuFunctionItem = function (postData, callback) {
        $.ajax({
            type: "GET",
            url: "/Menu/getMenuFunctionItem",//TODO
            data: postData,
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };
    module.menuInfoService.getAuthorizationMenuFuncItem = function (postData, callback) {
        $.ajax({
            type: "GET",
            url: "/Menu/getAuthorizationMenuFuncItem",//TODO
            data: postData,
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    }
    module.menuInfoService.getCurrentUserMenuList = function (callback) {
        $.ajax({
            type: "GET",
            url: "/Home/GetCurrentUserMenuList",//TODO
            dataType: "json",
            success: function (data) {
                console.log(data);
                callback(data);
            }
        });
    }
    return module;
}(olive.serviceModule || {}, jQuery))

//Get Role Items Info serive
olive.serviceModule = (function (module, $) {
    module.roleInfoService = {};
    module.roleInfoService.getRoleItems = function (callback) {
        $.ajax({
            type: "GET",
            async: false,
            url: "/Role/GetRoleItems",
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };
    module.roleInfoService.updateAuthorization = function (postData,callback) {
        $.ajax({
            type: "POST",
            async: false,
            data:postData,
            url: "/Role/addAuthorization",
            success: function (data) {
                callback(data);
            }
        });
    };
    module.roleInfoService.getMenuFunctionByRoleId = function () {
        
    };
    return module;
}(olive.serviceModule || {}, jQuery))

//Get Categorys Info serive
olive.serviceModule = (function (module, $) {
    module.categoryInfoService = {};
    module.categoryInfoService.getCategorys = function (postData,callback) {
        $.ajax({
            type: "GET",
            async: false,
            data: postData,
            url: "/Category/GetCategorys",
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };

module.categoryInfoService.getCategoryItems = function (postData, callback) {
    $.ajax({
        type: "GET",
        async: false,
        data: postData,
        url: "/CategoryItem/GetCategoryItems",
        dataType: "json",
        success: function (data) {
            callback(data);
        }
    });
};

    return module;
}(olive.serviceModule || {}, jQuery))

//Authentication  serive
olive.serviceModule = (function (module, $) {
    module.authenticationService = {};
    module.authenticationService.login = function (postData, callback) {
        $.ajax({
            type: "POST",
            async: false,
            data: postData,
            url: "/InternalUser/Login",
            dataType: "text",//TODO
            success: function (data) {
                callback(data);
            }
        });
    };
    module.authenticationService.logOut = function (callback) {
        $.ajax({
            type: "GET",
            async: false,
            url: "/InternalUser/LogOut",
            success: function (data) {
                callback(data);
            }
        });
    };

    return module;
}(olive.serviceModule || {}, jQuery))

//Get Artist Info serive
olive.serviceModule = (function (module, $) {
    module.artistInfoService = {};
    module.artistInfoService.getArtists = function (postData, callback) {
        $.ajax({
            type: "GET",
            async: false,
            data: postData,
            url: "/Artist/GetArtists",
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };


    return module;
}(olive.serviceModule || {}, jQuery))

//Get Tag Info serive
olive.serviceModule = (function (module, $) {
    module.tagInfoService = {};
    module.tagInfoService.getTags = function (postData, callback) {
        $.ajax({
            type: "GET",
            async: false,
            data: postData,
            url: "/Tag/GetTags",
            dataType: "json",
            success: function (data) {
                callback(data);
            }
        });
    };


    return module;
}(olive.serviceModule || {}, jQuery))


