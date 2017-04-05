<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Login Page - Ace Admin</title>

    <meta name="description" content="Mordor Administrator Login" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->
    @Styles.Render("~/Content/css/bootstrap.min.css");
    @Styles.Render("~/Content/css/font-awesome.min.css");

    <!--[if IE 7]>
      <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
    <![endif]-->
    <!-- page specific plugin styles -->
    <!-- fonts -->
    @Styles.Render("~/Content/css/ace-fonts.css")

    <!-- ace styles -->
    @Styles.Render("~/Content/css/ace.min.css")
    @Styles.Render("~/Content/css/ace-rtl.min.css")
    <!--[if lte IE 8]>
      <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-layout">
    <div class="main-container">
        <div class="main-content">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="login-container">
                        <div class="center">
                            <h1>
                                <i class="icon-leaf green"></i>
                                <span class="red">Mordor</span>
                                <span class="white">后台管理系统</span>
                            </h1>
                            <h4 class="blue">&copy; MagicSoft</h4>
                        </div>

                        <div class="space-6"></div>

                        <div class="position-relative">
                            <div id="login-box" class="login-box visible widget-box no-border">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <h4 class="header blue lighter bigger">
                                            <i class="icon-coffee green"></i>
                                           		 输入用户名和密码
                                        </h4>

                                        <div class="space-6"></div>

                                        <form id="loginForm">
                                            <fieldset>
                                                <label class="block clearfix">
                                                    <span class="block input-icon input-icon-right">
                                                        <input type="text" class="form-control" id="userAccount" name="userAccount" value="admin" />
                                                        <i class="icon-user"></i>
                                                    </span>
                                                </label>

                                                <label class="block clearfix">
                                                    <span class="block input-icon input-icon-right">
                                                        <input type="password" class="form-control" id="password" name="password" value="123456" />
                                                        <i class="icon-lock"></i>
                                                    </span>
                                                </label>

                                                <div class="space"></div>

                                                <div class="clearfix">
                                                    <label class="inline">
                                                        <input type="checkbox" id="isPersistent" name="isPersistent" class="ace" />
                                                        <span class="lbl"> 自动登录</span>
                                                    </label>

                                                    <button type="button" class="width-35 pull-right btn btn-sm btn-primary" onclick="loginController.login()">
                                                        <i class="icon-key"></i>
                                                        登录
                                                    </button>
                                                </div>

                                                <div class="space-4"></div>
                                            </fieldset>
                                        </form>
                                    </div><!-- /widget-main -->

                                    <div class="toolbar clearfix">
                                        <div>
                                            <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                                                <i class="icon-arrow-left"></i>
                                               		 忘记密码
                                            </a>
                                        </div>
                                    </div>
                                </div><!-- /widget-body -->
                            </div><!-- /login-box -->

                            <div id="forgot-box" class="forgot-box widget-box no-border">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <h4 class="header red lighter bigger">
                                            <i class="icon-key"></i>
                                        		重置密码
                                        </h4>

                                        <div class="space-6"></div>
                                        <p>
                                           	输入邮箱地址
                                        </p>
                                        <form>
                                            <fieldset>
                                                <label class="block clearfix">
                                                    <span class="block input-icon input-icon-right">
                                                        <input type="email" class="form-control" placeholder="Email" />
                                                        <i class="icon-envelope"></i>
                                                    </span>
                                                </label>
                                                <div class="clearfix">
                                                    <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                        <i class="icon-lightbulb"></i>
                                                        	发送
                                                    </button>
                                                </div>
                                            </fieldset>
                                        </form>
                                    </div><!-- /widget-main -->

                                    <div class="toolbar center">
                                        <a href="#" onclick="loginController.showDialog('login-box'); return false;" class="back-to-login-link">
                                            Back to login
                                            <i class="icon-arrow-right"></i>
                                        </a>
                                    </div>
                                </div><!-- /widget-body -->
                            </div><!-- /forgot-box -->

                        </div><!-- /position-relative -->
                    </div>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div>
    </div><!-- /.main-container -->
    <!-- basic scripts -->
    <!--[if !IE]> -->

    <script type="text/javascript">
        window.jQuery || document.write("<script src='@Url.Content("~/Scripts/jquery-2.0.3.min.js")'>" + "<" + "/script>");
    </script>
    @Scripts.Render("~/Scripts/mordor/mordor.module.service.js")
    @Scripts.Render("~/Scripts/mordor/mordor.ui.utils.js")
    @Scripts.Render("~/Scripts/mordor/mordor.ui.overlay.js")
    @Scripts.Render("~/Scripts/jquery.validate.js")
    <!-- <![endif]-->
    <!--[if IE]>
    <script type="text/javascript">
     window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
    </script>
    <![endif]-->
    <!-- inline scripts related to this page -->

    <script type="text/javascript">
    </script>
</body>
</html>
