<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/11/2024
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Login</title>
</head>
<body>
    <h1>${message}</h1>
<%--   Ctrl + /: comment --%>
<%--    Ctrl +D: dupilicate nội dung--%>
    <%--    Form Control
        @action: địa chỉ URL nhận dữ liệu form khi nhấp nút submit
        @method: hình thức gửi dữ liệu form, có 2 giá trị
             -   GET: Tạo chuỗi truy vấn và đính kèm URL của @action
             -   POST: Mở kênh truyền thông ngầm gửi dữ liệu lên server
    --%>
    <form action="/ket-qua" method="post">
        <div class="container">
            <label> Username: </label> </br>
            <input type="text" placeholder="Enter username" name="usn" required></br>
            <label> Password: </label> </br>
            <input type="password" placeholder="Enter password" name="pw" required></br>
            <button type="submit">Login</button>
        </div>
    </form>
</body>
</html>
