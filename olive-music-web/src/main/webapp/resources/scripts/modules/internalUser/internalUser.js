/**
 * Created by user on 2017/5/9.
 */
define(['grid'],function(require,exports,module){
	"use strict";
    var instance = {};
    instance.init = function(){
        let $ = jQuery;
        $(document).ready((function(){
            var gridSelector = "#grid-table";
            var pagerSelector = "#grid-pager";
            var options = {
                url: '/sys_internal_user/jqgird_list'.serverPath(),
                gridSelector: "#grid-table",
                pagerSelector: "#grid-pager",
                pager: "#grid-pager",
                sortname: "user_id",
                colNames: ['ID', '用户登录名', '用户名称', '是否禁用', '角色', '上次登录时间', '修改时间', '创建时间'],
                colModel: [
                    { name: 'userId', index: 'UserID', key: true, width: 60, sorttype: "int", editable: true, editoptions: { size: 70,readonly: 'readonly' } },
                    { name: 'userAccount', index: 'userAccount', width: 90, editable: true, editoptions: { size: 70 }, editrules: { required: true }, formoptions: { elmsuffix: '<span style="color:red;">*</span>' } },
                    { name: 'userName', index: 'userName', width: 150, editable: true, editoptions: { size: 70 }, editrules: { required: true }, formoptions: { elmsuffix: '<span style="color:red;">*</span>' } },
                    { name: 'invalid', index: 'invalid', width: 70, editable: true, edittype: "checkbox", editoptions: { value: "1:0" } },
                    { name: 'roleIds', index: 'roleIds', width: 200, editable: true, edittype: "select", formatter: 'select', editoptions: { size: 70, value: getRoleItems(), multiple: true } },
                    { name: 'lastLoginTime', index: 'lastLoginTime', width: 90, editable: true, formatter: "date", formatoptions: { srcformat: "Y-m-d H:i:s", newformat: "Y-m-d H:i:s" }, editoptions: { size: 70, readonly: 'readonly' } },
                    { name: 'modifyTime', index: 'modifyTime', width: 90, editable: true, formatter: "date", formatoptions: { srcformat: "Y-m-d H:i:s", newformat: "Y-m-d H:i:s" }, editoptions: { size: 70, readonly: 'readonly' } },
                    { name: 'createTime', index: 'createTime', width: 90, editable: true, formatter: "date", formatoptions: { srcformat: "Y-m-d H:i:s", newformat: "Y-m-d H:i:s" }, editoptions: { size: 70, readonly: 'readonly' } }
                ],
                controls: [
                    { ctlId: "roleIds", ctlType: "multiSelect" }
                ],
                height: "500",
                editurl: "sys_internal_user/jqgrid_save".serverPath(),//nothing is saved
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
