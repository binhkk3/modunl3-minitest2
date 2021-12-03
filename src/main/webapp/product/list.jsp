<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: binhd
  Date: 12/2/2021
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CHÀO MỪNG BẠN</h1>
<p>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
<a href="/products?action=create">Thêm Sản phẩm</a>
<p>~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
<a href="/products?action=sort">sắp xếp</a>
<p>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
<form action="/products">
    <input type="text" name="key">
    <button>tim</button>
</form>
<p>******************************************************</p>
<h1>danh  sách sản phẩm</h1>
    <c:forEach var="action" items="${dssp}">
        <h2>${action.id},${action.name},${action.price},${action.quantity}</h2>
    </c:forEach>
</body>
</html>
