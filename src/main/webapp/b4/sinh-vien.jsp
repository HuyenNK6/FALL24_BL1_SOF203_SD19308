<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/16/2024
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý Sinh viên</title>
</head>
<body>
    <button><a href="/sinh-vien/view-add">Add New Student</a></button>
    <table>
        <tr>
            <th>STT</th>
            <th>MSSV</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th>Action</th>
        </tr>
        <tbody>
            <c:forEach var="sv" items="${listSV}" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${sv.mssv}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.gioiTinh}</td>
                    <td>${sv.diaChi}</td>
                    <td>
                        <a href="/sinh-vien/detail?mssv=${sv.mssv}">Detail</a>
                        <a href="/sinh-vien/view-update?mssv=${sv.mssv}">Update</a>
                        <a href="/sinh-vien/remove?mssv=${sv.mssv}">Remove</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>

    </table>
</body>
</html>
