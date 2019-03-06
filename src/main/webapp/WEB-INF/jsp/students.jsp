<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Title</title>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/stat/../css-reset.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/module.css">
</head>
<body>
<div>
<h2>测试页面</h2>

    <span>message:${jsonResult.msg}</span>
    <div class="container">
        <div class="row">
            <div class="span12">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="container-fluid">
                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="tabbable" id="tabs-433654">
                                        <ul class="nav nav-tabs">
                                            <li>
                                                <a data-toggle="tab" href="#panel-739096">学生列表</a>
                                            </li>
                                            <li class="active">
                                                <a data-toggle="tab" href="#panel-710019">添加学生</a>
                                            </li>
                                        </ul>

                                        <div class="tab-content">
                                            <div class="tab-pane" id="panel-739096">
                                                <p>学生列表</p>

                                                <div class="container-fluid">
                                                    <div class="row-fluid">
                                                        <div class="span12">
                                                            <table class="table table-hover">
                                                                <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>学生编号</th>
                                                                    <th><span>用户名</span></th>
                                                                    <th>密码</th>
                                                                    <th>邮箱</th>
                                                                    <th>手机</th>
                                                                    <th>状态</th>
                                                                    <th>注册时间</th>
                                                                    <th>最后修改时间 </th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <c:forEach items="${students}" var="stu">
                                                                    <tr class="success">
                                                                        <td>${stu.id}</td>
                                                                        <td>${stu.studentNum}</td>
                                                                        <td>${stu.username}</td>
                                                                        <td>${stu.password}</td>
                                                                        <td>${stu.email}</td>
                                                                        <td>${stu.tell}</td>
                                                                        <td>${stu.status}</td>
                                                                        <td class=""> ${stu.createAt}</td>
                                                                        <td>${stu.updateAt}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="pagination pagination-centered">
                                                    <ul>
                                                        <li>
                                                            <a href="#">上一页</a>
                                                        </li>
                                                        <li>
                                                            <a href="#">1</a>
                                                        </li>
                                                        <li>
                                                            <a href="#">2</a>
                                                        </li>
                                                        <li>
                                                            <a href="#">3</a>
                                                        </li>
                                                        <li>
                                                            <a href="#">4</a>
                                                        </li>
                                                        <li>
                                                            <a href="#">5</a>
                                                        </li>
                                                        <li>
                                                            <a href="#">下一页</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="tab-pane active" id="panel-710019">
                                                <p>
                                                    添加学生
                                                </p>
                                                <div>
                                                    <form action="/student" class="form-horizontal" method="post">
                                                        <input name="_method" type="hidden" value="POST" />
                                                        <div class="control-group">
                                                            <label class="control-label" for="studentNum">学生编号</label>
                                                            <div class="controls">
                                                                <input id="studentNum" name="studentNum" type="text" />
                                                            </div>
                                                        </div>
                                                        <div class="control-group">
                                                            <label class="control-label" for="username">用户名</label>
                                                            <div class="controls">
                                                                <input id="username" name="username" type="text" />
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
                                                            <label class="control-label" for="tell">手机</label>
                                                            <div class="controls">
                                                                <input id="tell" name="tell" type="text" />
                                                            </div>
                                                        </div>
                                                        <div class="control-group">
                                                            <div class="controls">
                                                                <button class="btn" type="submit">添加</button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>


</body>
</html>

<script src="${pageContext.request.contextPath}/stat/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/css/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/layer/layer.js"></script>