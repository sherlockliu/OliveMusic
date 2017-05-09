/**
 * Created by user on 2017/5/9.
 */
define(['jQuery','grid'],function(require,exports,module){
    var instance = {};
    instance.init = function(){
        let $ = jQuery;
        $(document).ready((function(){
            var gridSelector = "#grid-table";
            var pagerSelector = "#grid-pager";
            var options = {
                url: '/sys_internal_user/list.json'.serverPath(),
                gridSelector: "#grid-table",
                pagerSelector: "#grid-pager",
                pager: "#grid-pager",
                sortname: "UserID",
                colNames: ['ID', '用户登录名', '用户名称', '是否禁用', '角色', '上次登录时间', '修改时间', '创建时间'],
                colModel: [
                    { name: 'UserID', index: 'UserID', key: true, width: 60, sorttype: "int", editable: true, editoptions: { size: 70,readonly: 'readonly' } },
                    { name: 'UserAccount', index: 'UserAccount', width: 90, editable: true, editoptions: { size: 70 }, editrules: { required: true }, formoptions: { elmsuffix: '<span style="color:red;">*</span>' } },
                    { name: 'UserName', index: 'UserName', width: 150, editable: true, editoptions: { size: 70 }, editrules: { required: true }, formoptions: { elmsuffix: '<span style="color:red;">*</span>' } },
                    { name: 'Invalid', index: 'Invalid', width: 70, editable: true, edittype: "checkbox", editoptions: { value: "1:0" } },
                    { name: 'RoleIDs', index: 'RoleIDs', width: 200, editable: true, edittype: "select", formatter: 'select', editoptions: { size: 70, value: getRoleItems(), multiple: true } },
                    { name: 'LastLoginTime', index: 'LastLoginTime', width: 90, editable: true, formatter: "date", formatoptions: { srcformat: "Y-m-d H:i:s", newformat: "Y-m-d H:i:s" }, editoptions: { size: 70, readonly: 'readonly' } },
                    { name: 'ModifyTime', index: 'ModifyTime', width: 90, editable: true, formatter: "date", formatoptions: { srcformat: "Y-m-d H:i:s", newformat: "Y-m-d H:i:s" }, editoptions: { size: 70, readonly: 'readonly' } },
                    { name: 'CreateTime', index: 'CreateTime', width: 90, editable: true, formatter: "date", formatoptions: { srcformat: "Y-m-d H:i:s", newformat: "Y-m-d H:i:s" }, editoptions: { size: 70, readonly: 'readonly' } }
                ],
                controls: [
                    { ctlId: "RoleIDs", ctlType: "multiSelect" }
                ],
                height: "500",
                editurl: "sys_internal_user/save".serverPath(),//nothing is saved
                caption: "后台用户管理",
                formWidth: 750
            };
            require('grid');
            $("#grid-table").oliveGrid(options);
        }));
    }
    function getRoleItems() {
            var states = {};
            //var service = mordor.serviceFacory.getService('roleInfoService');
            //service.getRoleItems(function (data) {
            //
            //    states = data;
            //    console.log(data);
            //});
            //console.log(states);
            return states;
    }
    module.exports = instance;
});
