<%--
  Created by IntelliJ IDEA.
  User: fulia
  Date: 2022/5/26
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>success</title>
</head>
<body>
<%=request.getAttribute("message")%>
<a href="SearchallServlet">查看所有用户</a>
</body>
</html>
