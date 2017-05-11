/**
 * Created by user on 2017/5/11.
 */
define(function (require,exports,module) {
    "use strict"
    var zTree;
    var selectedNode = null;
    var action = '';//new edit
    var setting = {
        async: {
            enable: true,
            url: "Menu/GetTreeNode".serverPath(),
            autoParam: ["id", "name=name", "level=level"],
            otherParam: {"otherParam": "zTreeAsyncTest"}
        },
        check: {
            enable: false
        },
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
            simpleData: {
                //enable: true,
                //idKey: "id",
                //pIdKey: "pId",
                //rootPId: ""
                enable: true
            }
        },
        callback: {
            beforeClick: function (treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if (treeNode.isParent) {
                    return false;
                } else {
                    return true;
                }
            },
            onClick: function (event, treeId, treeNode) {
                removeHoverDom(treeId, treeNode);
            },
            //beforeRemove: ConfirmDelete,
            onExpand: function (event, treeId, treeNode) {
                window.parent.resize();
            }
        }
    };

    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
        if (treeNode.level < 2) {
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var addBtn = $("#addBtn_" + treeNode.tId);
            if (addBtn) {
                addBtn.bind("click", function () {
                    action = 'new';
                    OpenDialog(treeNode, action);
                    window.parent.resize();
                });
            }
        }
        if (treeNode.level > 0) {
            if (treeNode.editNameFlag || $("#editBtn_" + treeNode.tId).length > 0) return;
            var editStr = "<span class='button edit' title='编辑' id='editBtn_" + treeNode.tId + "'></span>";
            sObj.after(editStr);
            var editBtn = $("#editBtn_" + treeNode.tId);
            if (editBtn) {
                editBtn.bind("click", function () {
                    action = 'edit';
                    OpenDialog(treeNode, action);
                    window.parent.resize();
                });
            }
            var removeStr = "<span class='button remove' title='删除' id='removeBtn_" + treeNode.tId + "'></span>";
            sObj.after(removeStr);
            var removeBtn = $("#removeBtn_" + treeNode.tId);
            if (removeBtn) {
                removeBtn.bind("click", function (e) {
                    selectedNode = treeNode;
                    ConfirmDelete(function () {
                        var service = mordor.serviceFacory.getService('menuInfoService');
                        service.remove({menuId: selectedNode.id}, function () {
                            var zTree = $.fn.zTree.getZTreeObj("menuTree");
                            zTree.removeNode(selectedNode, false);
                            selectedNode = null;
                        })
                    });
                });
            }
        }
    };

    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_" + treeNode.tId).unbind().remove();
        $("#removeBtn_" + treeNode.tId).unbind().remove();
        $("#editBtn_" + treeNode.tId).unbind().remove();
    };

//override dialog's title function to allow for HTML titles
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function (title) {
            var $title = this.options.title || '&nbsp;'
            if (("title_html" in this.options) && this.options.title_html == true) {
                title.html($title);
            }
            else {
                title.text($title);
            }
        }
    }));

    function OpenDialog(treeNode, action) {
        selectedNode = treeNode;
        initDialog(treeNode, action);
        var dialog = $("#editBox").removeClass('hide').dialog({
            modal: true,
            title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>编辑菜单</h4></div>",
            title_html: true,
            width: 500,
            buttons: [
                {
                    text: "取消",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                    }
                },
                {
                    text: "确认",
                    "class": "btn btn-primary btn-xs",
                    click: function () {
                        var zTree = $.fn.zTree.getZTreeObj("menuTree");
                        $("#editBox").overlay('load');
                        var postData = createPostData();
                        var service = mordor.serviceFacory.getService('menuInfoService');
                        if (action === 'new') {
                            service.add(postData, function (data) {
                                zTree.addNodes(treeNode, {
                                    id: data.id,
                                    pId: treeNode.id,
                                    name: data.name
                                });
                            });
                        } else {
                            service.update(postData, function (data) {
                                console.log(data);
                                treeNode.name = data.name;
                                treeNode.URL = data.URL;
                                zTree.editName(treeNode);
                                zTree.cancelEditName(treeNode.name);
                                removeHoverDom("menuTree", treeNode);
                                console.log(treeNode);
                            });
                        }
                        $(this).dialog("close");
                        $("#editBox").overlay('close');
                        action = '';
                    }
                }
            ]
        });
    }

    function initDialog(treeNode, action) {
        var parentMenuName = $("#parentMenuName"),
            menuId = $("#menuId"),
            menuName = $("#menuName"),
            menuUrl = $("#menuUrl"),
            parentId = $("#parentId"),
            treeObj = $.fn.zTree.getZTreeObj("menuTree"),
            parentObj = treeNode.parentTId && treeObj.getNodeByTId(treeNode.parentTId);

        if (treeNode && action === 'edit') {
            menuId.val(treeNode.id);
            menuName.val(treeNode.name);
            parentId.val(treeNode.pId);
            menuUrl.val(treeNode.URL);
            if (parentObj == null || parentObj.name === '') {
                parentMenuName.val('Olive Admin');//DOTO
            } else {
                parentMenuName.val(parentObj.name);
            }
            parentId.val(treeNode.pId === '' ? '0' : treeNode.pId);
        } else {
            parentMenuName.val(treeNode.name);
            menuId.val('');
            menuName.val('');
            menuUrl.val('');
            parentId.val(treeNode.id);
        }
        console.log(menuUrl.val());
    }

    function createPostData() {
        var data = {};
        data.menuName = $("#menuName").val();
        data.menuUrl = $("#menuUrl").val();
        data.parentId = $("#parentId").val();
        data.menuId = $("#menuId").val();
        return data;
    }

    function ConfirmDelete(callback) {
        $("#dialog-confirm").removeClass('hide').dialog({
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='icon-warning-sign red'></i>删除确认</h4></div>",
            title_html: true,
            buttons: [
                {
                    html: "<i class='icon-trash bigger-110'></i>&nbsp; 删除",
                    "class": "btn btn-danger btn-xs",
                    click: function () {
                        $(this).dialog("close");
                        callback();
                        return true;
                    }
                },
                {
                    html: "<i class='icon-remove bigger-110'></i>&nbsp; 取消",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                        return false;
                    }
                }
            ]
        });
        return false;
    }
    var instance = {};
    instance.init = function () {
        $(document).ready(function () {
            $.fn.zTree.init($("#menuTree"), setting);
        });
    };
    module.exports = instance;
})

