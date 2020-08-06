<%--
  Created by IntelliJ IDEA.
  User: zhu
  Date: 2020/6/27
  Time: 6:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>入门程序</h3>
<a href="test/sayhello">入门程序</a>

<form action="test/sayhello" method="post">
    用户：<input type="text" name="name"><br>
    <%--    密码：<input type="text" name="password"><br>--%>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>

<form action="test/fileupload" method="post" enctype="multipart/form-data">
    文件上传:<input type="file" name="upload1" multiple="multiple">
<%--    文件上传:<input type="file" name="upload1">--%>
<%--    文件上传:<input type="file" name="upload1">--%>

    <input type="submit" value="提交">
</form>
<form action="test/filedownload" method="get" enctype="multipart/form-data">

    <input type="submit" value="下载">
</form>
<%--<form action="test/sayhello1" method="get">--%>
<%--    用户：<input type="text" name="name"><br>--%>
<%--    &lt;%&ndash;    密码：<input type="text" name="password"><br>&ndash;%&gt;--%>
<%--    年龄：<input type="text" name="age"><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</html>
