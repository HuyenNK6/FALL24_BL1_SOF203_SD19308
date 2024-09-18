<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/18/2024
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/sinh-vien/add" method="post">
        MSSV: <input type="text" name="mssv" required></br>
        Tên: <input type="text" name ="ten" required></br>
        Tuổi: <input type="text" name="tuoi" required></br>
        Địa chỉ: <input type="text" name="diaChi" required></br>
        Giới tính:
        <input type="radio" name="gioiTinh" checked> Nam
        <input type="radio" name="gioiTinh" > Nữ</br>
        <button type="submit">Add</button>
    </form>


</body>
</html>
