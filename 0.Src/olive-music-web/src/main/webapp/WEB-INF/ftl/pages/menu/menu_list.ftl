<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Olive Administration</title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <#include "/WEB-INF/ftl/shared/header.ftl" />
    <script type="text/javascript" src="/resources/asserts/content/css/zTreeStyle/metro.css"/>
    <script type="text/javascript" src="/resources/asserts/content/css/zTreeStyle/jquery-ui-1.10.3.full.min.css"/>
    <script type="text/javascript" src="/resources/asserts/scripts/jquery.ztree.all-3.5.min.js"/>
    <script type="text/javascript" src="/resources/asserts/scripts/jquery.ztree.core-3.5.js"/>
    <script type="text/javascript" src="/resources/asserts/scripts/jquery.ztree.excheck-3.5.js"/>
    <script type="text/javascript" src="/resources/asserts/scripts/jquery.ztree.exedit-3.5.js"/>
</head>
<body>
<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div class="row">
            <div class="col-sm-12">
                <div class="widget-box">
                    <div class="widget-header header-color-blue2">
                        <h4 class="lighter smaller">菜单管理</h4>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main padding-8">
                            <ul id="menuTree" class="ztree"></ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row hide" id="editBox">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form class="form-horizontal" role="form">
                        <script type="text/javascript">
                            var $assets = "assets";//this will be used in fuelux.tree-sampledata.js
                        </script>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-input-readonly"> 上一级菜单 </label>

                            <div class="col-sm-9">
                                <input readonly="" type="text" class="col-xs-10 col-sm-5" id="parentMenuName" name="parentMenuName" />
                                <input readonly="" type="hidden" name="menuId" class="col-xs-10 col-sm-5" id="menuId" />
                                <input type="hidden" name="parentId" id="parentId" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 菜单名称 </label>

                            <div class="col-sm-9">
                                <input type="text" id="MenuName" name="MenuName" placeholder="菜单名称" class="col-xs-10 col-sm-5" />
                            </div>
                        </div>
                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> URL </label>

                            <div class="col-sm-9">
                                <input type="text" id="MenuURL" name="MenuURL" placeholder="菜单URL" class="col-xs-10 col-sm-5" />
                            </div>
                        </div>
                        <div class="space-4"></div>
                    </form>
                    <!-- PAGE CONTENT ENDS -->
                </div><!-- /.col -->
            </div><!-- /.row -->
            <div id="dialog-confirm" class="hide">
                <div class="space-6"></div>
                <p class="bigger-110 bolder center grey">
                    <i class="icon-hand-right blue bigger-120"></i>
                    确定要删除该菜单吗？
                </p>
            </div><!-- #dialog-confirm -->
        </div>
    </div>
</div>
</body>





