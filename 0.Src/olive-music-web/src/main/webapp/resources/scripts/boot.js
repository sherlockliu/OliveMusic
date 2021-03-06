/**
 * Created by user on 2017/4/6.
 */
(function(){
    if(seajs){
        seajs.config({
            "base":"/",
            alias:{
                'serviceFactory':'olive/resources/scripts/olive/olive.io.serviceFactory',
                'olive':'olive/resources/scripts/olive',
                'overlay':'olive/resources/scripts/lib/magicsoft.ui.overlay',
                'AjaxPromise':'olive/resources/scripts/lib/magicsoft.io.AjaxPromise',
                'spinner':'olive/resources/scripts/lib/magicsoft.ui.spinner',
                'grid':'olive/resources/scripts/olive/olive.ui.grid'
            },
            map: [
                [ /^(.*\.(?:css|js))(.*)$/i, '$1']
            ],
            "paths": {
                "asserts": "olive/resources/asserts/scripts",
                "module":  "olive/resources/scripts/modules",
                "lib": "olive/resources/scripts/lib",
                "services":'olive/resources/scripts/modules/services',
                'olivelib':'olive/resources/scripts/olive'
            }
        });
    }
}())

