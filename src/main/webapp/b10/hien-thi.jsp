<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 10/2/2024
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/get-all" method="post">
    <label>Tên thương hiệu: </label>
    <input type="text" name="searchName" placeholder="Nhập tên cần tìm">
    <button type="button">Search</button>
    <br>
    <label>Mã: </label><input type="text" name="maGV" required><br>
    <label>Ten: </label><input type="text" name="ten"  required><br>
    <label>Loai: </label>
    <%--        <input type="text" name="thuongHieu" value="${ts.thuongHieu}" required><br>--%>
    <select name="loai">
        <option value="Loai 1">Loai 1</option>
        <option value="Loai 2" >Loai 2</option>
    </select>
    <label>Tuoi: </label>
    <input type="number" name="tuoi"  required><br>
    <label>Bac: </label>
    <input type="number" name="bac"  required><br>
    <label>Gioi Tinh:</label>
    <input type="radio" value="1" name="gioiTinh" required>Nam
    <input type="radio" value="0" name="gioiTinh" required>Nu<br>
    <button type="submit" name="action" value="add">Add</button>
</form>
<br>
<table>
    <thead>
    <th>STT</th>
    <th>Mã</th>
    <th>Ten</th>
    <th>Loai</th>
    <th>Tuoi</th>
    <th>Bac</th>
    <th>Gioi Tinh</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="gv" items="${giangViens}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${gv.maGV}</td>
            <td>${gv.ten}</td>
            <td>${gv.loai}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.bac}</td>
            <td>${gv.gioiTinh ? "Nam": "Nu"}</td>
            <td>
                <a href="">Detail</a>
                <a href="">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
