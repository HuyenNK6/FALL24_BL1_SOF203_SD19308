<%@ page import="b6.trasua.entity.TraSua" %><%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/25/2024
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tra Sua Hehe</title>
</head>
<body>
    <%
        TraSua ts= (TraSua) request.getAttribute("ts");
        String selectedThuongHieu ="Tocotoco";
        if(ts!=null){
            selectedThuongHieu= ts.getThuongHieu();
        }
    %>
    <form action="/tra-sua/hien-thi" method="post">
        <label>Tên thương hiệu: </label>
        <input type="text" name="searchName" placeholder="Nhập tên cần tìm">
        <button type="button">Search</button>
        <br>
        <label>Mã: </label><input type="text" name="ma" value="${ts.ma}" required><br>
        <label>Vị: </label><input type="text" name="vi" value="${ts.vi}" required><br>
        <label>Giá: </label><input type="text" name="gia" value="${ts.gia}" required><br>
        <label>Size: </label><input type="text" name="size" value="${ts.size}" required><br>
        <label>Thương hiệu: </label>
<%--        <input type="text" name="thuongHieu" value="${ts.thuongHieu}" required><br>--%>
        <select name="thuongHieu">
            <option value="Tocotoco" <%= selectedThuongHieu.equalsIgnoreCase("Tocotoco") ? "selected": ""%>>Tocotoco</option>
            <option value="DingTea" <%= selectedThuongHieu.equalsIgnoreCase("DingTea") ? "selected": ""%>>DingTea</option>
            <option value="Highland" <%= selectedThuongHieu.equalsIgnoreCase("Highland") ? "selected": ""%>>Highland</option>
            <option value="The Coffee House" <%= selectedThuongHieu.equalsIgnoreCase("The Coffee House") ? "selected": ""%>>The Coffee House</option>
            <option value="Mixue" <%= selectedThuongHieu.equalsIgnoreCase("Mixue") ? "selected": ""%>>Mixue</option>
        </select>
        <button type="submit" name="action" value="add">Add</button>
        <button type="submit" name="action" value="update">Update</button>
    </form>
        <br>
        <table>
            <thead>
                <th>STT</th>
                <th>Mã</th>
                <th>Vị</th>
                <th>Giá</th>
                <th>Size</th>
                <th>Thương hiệu</th>
                <th>Action</th>
            </thead>
            <tbody>
                <c:forEach var="ts" items="${listTraSua}" varStatus="i">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>${ts.ma}</td>
                        <td>${ts.vi}</td>
                        <td>${ts.gia}</td>
                        <td>${ts.size}</td>
                        <td>${ts.thuongHieu}</td>
                        <td>
                            <a href="/tra-sua/chi-tiet?ma=${ts.ma}">Detail</a>
                            <a href="/tra-sua/xoa?ma=${ts.ma}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

</body>
</html>
