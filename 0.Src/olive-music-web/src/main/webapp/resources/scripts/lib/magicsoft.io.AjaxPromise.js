/**
 * Created by user on 2017/4/7.
 */
define(function(require,exports,module){
    "use strict";
    function AjaxPromise(options){
        options = $.extend(options,{
            type:'POST',
            async:false,
            dataType:'JSON'
        });
        let promise = new Promise((resolve,reject)=>{
            $.ajax({
                type: options.type,
                async: options.async,
                data: options.data,
                url: options.url,
                dataType: options.dataType,
                success: function (data) {
                    resolve(data);
                },
                error:function(e){
                    reject(e);
                }
            });
        });
        return promise;
    }
    module.exports = AjaxPromise;
})