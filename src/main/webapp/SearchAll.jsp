<%--
  Created by IntelliJ IDEA.
  User: fulia
  Date: 2022/5/26
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>所有用户</title>
</head>
<body>
<h1><%=request.getAttribute("message")%></h1>
<table width="600" border="1" cellpadding="0">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>家乡</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${userAll}"  >
        <form action="UpdateServlet" method="post">
            <tr>
                <td><input type="text" value="${U.id}" name="id" ></td>
                <td><input type="text" value="${U.name}" name="name"></td>
                <td><input type="text" value="${U.sex}" name="sex"></td>
                <td><input type="text" value="${U.pwd}" name="pwd"></td>
                <td><input type="text" value="${U.home}" name="home"></td>
                <td><input type="text" value="${U.info}" name="info"></td>
                <td><a href="DeleteServlet?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
