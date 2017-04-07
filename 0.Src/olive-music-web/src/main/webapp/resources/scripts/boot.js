/**
 * Created by user on 2017/4/6.
 */
(function(){
    if(seajs){
        seajs.config({
            "base":"/",
            alias:{
                'serviceFactory':'olive/resources/scripts/olive/olive.io.serviceFactory',
                'jQuery':'olive/resources/asserts/scripts/jquery-2.0.3.min',
                'olive':'olive/resources/scripts/olive',
                'overlay':'olive/resources/scripts/lib/magicsoft.ui.overlay',
                'AjaxPromise':'olive/resources/scripts/lib/magicsoft.io.AjaxPromise',
                'spinner':'olive/resources/scripts/lib/magicsoft.ui.spinner'
            },
            map: [
                [ /^(.*\.(?:css|js))(.*)$/i, '$1']
            ],
            "paths": {
                "asserts": "olive/resources/asserts/scripts",
                "module":  "olive/resources/scripts/modules",
                "lib": "olive/resources/scripts/lib",
                "services":'olive/resources/scripts/modules/services'
            }
        });
    }
}())

