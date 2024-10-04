<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 10/4/2024
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>ID</th>
    <th>CateName</th>
    <th>CateCode </th>
    <th>ProductCode</th>
    <th>ProductName</th>
    <th>Price</th>
    <th>Description</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="product" items="${listProducts}" varStatus="i">
        <tr>
            <td>${product.id}</td>
            <td>${product.category.name}</td>
            <td>${product.category.code}</td>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <a href="">Detail</a>
                <a href="">Delete</a>
                <a href="">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
