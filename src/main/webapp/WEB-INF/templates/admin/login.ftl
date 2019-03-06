<#compress>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>${options.blog_title!} | 后台登录 </title>
    <style>
        body{background-color:#f5f5f5}*{outline:0}label{color:#4b1c0f}.loginForm{max-width:380px;margin:auto}.loginLogo{font-size:56px;text-align:center;margin-bottom:25px;font-weight:500;color:#444;text-shadow:#b2baba .1em .1em .2em}.loginBody{padding:20px;background-color:#fff;-o-box-shadow:-4px 7px 46px 2px rgba(0,0,0,.1);box-shadow:-4px 7px 46px 2px rgba(0,0,0,.1)}.login-button{background-color:#fff;border-radius:0;border:1px solid #000;transition:all .5s ease-in-out}.login-button:hover{border:1px solid #fff;background-color:#000;color:#fff}.form-group{padding-bottom:25px}#loginName,#loginPwd{border-radius:0}.control{padding-bottom:5px}
    </style>
</head>
<body>
<div class="container loginForm">
<#-- 虽然Halo使用了宽松的GPL协议，但开发不易，希望您可以保留一下版权声明。笔芯~ -->
    <div class="loginLogo animated fadeInUp">
        Halo
    </div>
    <div class="loginBody animated">
        <form id="loginForm" action="/admin/login" method="post">
            <input type="hidden" name="_method" value="POST" >
            <div class="form-group animated fadeInUp" style="animation-delay: 0.1s">
                <input type="text" class="form-control" name="loginName" id="loginName" placeholder="用户名/邮箱" autocomplete="username">
            </div>
            <div class="form-group animated fadeInUp" style="animation-delay: 0.2s">
                <input type="password" class="form-control" name="loginPwd" id="loginPwd" placeholder="密码" autocomplete="current-password">
            </div>
            <#--<button type="button" id="btnLogin" data-loading-text="<@spring.message code='login.btn.logining' />" class="btn btn-block login-button animated fadeInUp" onclick="doLogin()"  style="animation-delay: 0.4s;outline: none;"><@spring.message code='login.btn.login' /></button>-->
            <button type="submit" id="btnLogin" data-loading-text="登录中..." class="btn btn-block login-button animated fadeInUp"  style="animation-delay: 0.4s;outline: none;">登录</button>
            <button type="button" id="btnReg" class="btn btn-block login-button animated fadeInUp" onclick="doReg()"  style="animation-delay: 0.4s;outline: none;">注册</button>
        </form>
    </div>
</div>
</body>
<script>
    function doReg(){
        window.location.href = "/admin/reg";
    }
    function doLogin(){

    }

</script>
</html>
</#compress>