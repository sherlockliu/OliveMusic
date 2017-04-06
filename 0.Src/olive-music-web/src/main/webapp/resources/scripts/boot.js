/**
 * Created by user on 2017/4/6.
 */
(function(){
    if(seajs){
        seajs.config({
            "base":"/",
            map: [
                [ /^(.*\.(?:css|js))(.*)$/i, '$1?'+ window.version]
            ],
            "paths": {
                "asserts": "/resources/asserts/scripts",
                "module":  "/resources/scripts/modules",
                "lib": "/resources/scripts/olive"
            }
        });
    }
}())
