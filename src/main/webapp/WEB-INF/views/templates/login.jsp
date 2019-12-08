<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <!--    &lt;!&ndash; jquery &ndash;&gt;-->
    <!--    <script type="text/javascript" th:src="@{/js/jquery.min.js}"></script>-->
    <!--    &lt;!&ndash; bootstrap &ndash;&gt;-->
    <!--    <link rel="stylesheet" type="text/css" th:href="@{/bootstrap/css/bootstrap.min.css}" />-->
    <!--    <script type="text/javascript" th:src="@{/bootstrap/js/bootstrap.min.js}"></script>-->
    <!--    &lt;!&ndash; jquery-validator &ndash;&gt;-->
    <!--    <script type="text/javascript" th:src="@{/jquery-validation/jquery.validate.min.js}"></script>-->
    <!--    <script type="text/javascript" th:src="@{/jquery-validation/localization/messages_zh.min.js}"></script>-->
    <!--    &lt;!&ndash; layer &ndash;&gt;-->
    <!--    <script type="text/javascript" th:src="@{/layer/layer.js}"></script>-->
    <!--    &lt;!&ndash; md5.js &ndash;&gt;-->
    <!--    <script type="text/javascript" th:src="@{/js/md5.min.js}"></script>-->
    <!--    &lt;!&ndash; common.js &ndash;&gt;-->
    <!--    <script type="text/javascript" th:src="@{/js/common.js}"></script>-->
    <script type="text/javascript" src="../static/js/jquery.min.js"></script>
    <!-- bootstrap -->
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="../static/bootstrap/js/bootstrap.min.js"></script>
    <!-- jquery-validator -->
    <script type="text/javascript" src="../static/jquery-validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/jquery-validation/localization/messages_zh.min.js"></script>
    <!-- layer -->
    <script type="text/javascript" src="../static/layer/layer.js"></script>
    <!-- md5.js -->
    <script type="text/javascript" src="../static/js/md5.min.js"></script>
    <!-- common.js -->
    <script type="text/javascript" src="../static/js/common.js"></script>

</head>
<body>

<form name="loginForm" id="loginForm" method="post"  style="width:50%; margin:0 auto">

    <h2 style="text-align:center; margin-bottom: 20px">用户登录</h2>

    <div class="form-group">
        <div class="row">
            <label class="form-label col-md-4">请输入手机号码</label>
            <div class="col-md-5">
                <input id="mobile" name = "mobile" class="form-control" type="text" placeholder="手机号码" required="true"  minlength="11" maxlength="11" />
            </div>
            <div class="col-md-1">
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="row">
            <label class="form-label col-md-4">请输入密码</label>
            <div class="col-md-5">
                <input id="password" name="password" class="form-control" type="password"  placeholder="密码" required="true" minlength="6" maxlength="16" />
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <button class="btn btn-primary btn-block" type="reset" onclick="reset()">重置</button>
        </div>
        <div class="col-md-5">
            <button class="btn btn-primary btn-block" type="submit" onclick="login()">登录</button>
        </div>
    </div>

</form>
</body>
<script>
    function login(){
        $("#loginForm").validate({
            submitHandler:function(form){
                doLogin();
            }
        });
    }
    function doLogin(){
        g_showLoading();

        var inputPass = $("#password").val();
        var salt = g_passsword_salt;
        var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
        var password = md5(str);

        $.ajax({
            url: "/login/do_login",
            type: "POST",
            data:{
                mobile:$("#mobile").val(),
                password: password
            },
            success:function(data){
                layer.closeAll();
                console.log(data);
                if(data.code == 0){
                	layer.msg("成功");
                	window.location.href="/goods/to_list";
                }else{
                	layer.msg(data.msg);
                }
            },
            error:function(){
                layer.closeAll();
            }
        });
    }
</script>
</html>