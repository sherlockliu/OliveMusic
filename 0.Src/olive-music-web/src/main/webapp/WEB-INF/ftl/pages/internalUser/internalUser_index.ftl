<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Olive Administration</title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <#include "/WEB-INF/ftl/shared/header.ftl" >
    <script>
            var userController;
            seajs.use(['module/internalUser/internalUser'], function(user) {
                userController = user;
                userController.init();
            });
    </script>
</head>
<body style="background-color:#ffffff">
<div class="page-content-mordor">
	<div class="row">
	    <div class="col-xs-12">
	        <!-- PAGE CONTENT BEGINS -->
	        <table id="grid-table"></table>
	        <div id="grid-pager"></div>
	        <script type="text/javascript">
	            var $path_base = "/";//this will be used in gritter alerts containing images
	        </script>
	        <!-- PAGE CONTENT ENDS -->
	    </div><!-- /.col -->
	</div>
</div>
</body>


