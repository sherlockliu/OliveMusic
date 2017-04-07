<!--界面上直接用   ${basePath}  -->
<#assign BasePath = springMacroRequestContext.getContextPath()/>
<#assign version = 1.0/>
<script>
	var contextPath = '${springMacroRequestContext.getContextPath()}',
		options = [${options}],
		resourcesUrl = '${resourcesUrl}',
		staticurl = '${staticFileUrl}';
</script>
<link type="text/css" rel="stylesheet" href="/olive/resources/asserts/content/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="/olive/resources/asserts/content/css/font-awesome.min.css" />

<link type="text/css" rel="stylesheet" href="/olive/resources/asserts/content/css/jquery-ui-1.10.3.full.min.css" />
<link type="text/css" rel="stylesheet" href="/olive/resources/asserts/content/css/datepicker.css" />
<link type="text/css" rel="stylesheet" href="/olive/resources/asserts/content/css/ui.jqgrid.css" />
<link type="text/css" rel="stylesheet" href="/olive/resources/asserts/content/css/chosen.css" />
<!--[if IE 7]>
<link rel="stylesheet" href="/olive/resources/asserts/content/css/font-awesome-ie7.min.css" />
<![endif]-->
<link rel="stylesheet" href="/olive/resources/asserts/content/css/ace-fonts.css" />
<link rel="stylesheet" href="/olive/resources/asserts/content/css/ace.min.css" />
<link rel="stylesheet" href="/olive/resources/asserts/content/css/ace-rtl.min.css" />
<link rel="stylesheet" href="/olive/resources/asserts/content/css/ace-skins.min.css" />

<!--[if lte IE 8]>
<link rel="stylesheet" href="/olive/resources/asserts/content/css/ace-ie.min.css" />
<![endif]-->
<!-- inline styles related to this page -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="/olive/resources/asserts/scripts/html5shiv.js?version=${version}"></script>
<script src="/olive/resources/asserts/scripts/respond.src.js?version=${version}"></script>
<![endif]-->
<script type="text/javascript" src="/olive/resources/asserts/scripts/ace-extra.min.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/jquery-1.4.4.min.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/jquery-2.0.3.min.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/bootstrap.min.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/typeahead-bs2.min.js?version=${version}" ></script>

<!-- page specific plugin scripts -->
<script type="text/javascript" src="/olive/resources/asserts/scripts/jqGrid/jquery.jqGrid.min.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/jqGrid/i18n/grid.locale-cn.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/chosen.jquery.min.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/jquery-ui-1.10.3.full.min.js"></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/date-time/bootstrap-datepicker.min.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/date-time/locales/bootstrap-datepicker.zh-CN.js?version=${version}" ></script>

<!-- ace scripts -->
<script type="text/javascript" src="/olive/resources/asserts/scripts/ace-elements.min.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/ace.min.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/bootbox.min.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/jquery.validate.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/asserts/scripts/seajs/2.2.0/sea-debug.js?version=${version}" ></script>
<!-- olive scripts -->
<script type="text/javascript" src="/olive/resources/scripts/boot.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/scripts/olive.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/scripts/olive.prototype.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.service.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.ui.dialog.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.ui.form.js?version=${version}"></script>

<script type="text/javascript" src="/olive/resources/scripts/olive/olive.ui.format.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.ui.grid.js?version=${version}" ></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.resource.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.ui.selectBox.js?version=${version}"></script>
<script type="text/javascript" src="/olive/resources/scripts/olive/olive.ui.utils.js?version=${version}"></script>





