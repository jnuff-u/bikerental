
<html lang="zh">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/../css-reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/module.css">
</head>
<body>
<div>
    <h2>注册页</h2>
    <p>注册用户</p>
    <p>message:${jsonResult.msg}</p>
    <div>
        <form action="/admin/reg" method="post">
            <input type="hidden" name="_method" value="POST">
            <div class="tab-pane " id="panel-710019">
                <div class="control-group">
                    <label class="control-label" for="username">用户名</label>
                    <div class="controls">
                        <input id="username" name="userName" type="text" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">密码</label>
                    <div class="controls">
                        <input id="inputPassword" name="password" type="password" />
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="inputEmail">邮箱</label>
                    <div class="controls">
                        <input id="inputEmail" name="email" type="text" />
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <button class="btn" type="submit">注册</button>
                    </div>
                </div>

            </div>
        </form>
    </div>


</div>


</body>
</html>

<script src="${pageContext.request.contextPath}/stat/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/css/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/layer/layer.js"></script>