<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 9/13/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Đăng Ký</title>
</head>
<body>
    <form action="/ket-qua-sign-in" method="post">
        <br class="container">
            <label>Họ và tên: </label>
            <input type="text" placeholder="Nhập họ và tên" name="hoVaTen" required> </br>
            <label>Ngày sinh:</label>
            <input type="date" name="ngaySinh" required></br>
            <label>SĐT:</label>
            <input type="tel" placeholder="Nhập số điện thoại" name="sdt" required> </br>
            <label>Giới tính:</label>
            <input type="radio" name="gioiTinh" value="Nam" id="male" checked>
            <label for="male"> Nam </label>
            <input type="radio" name="gioiTinh" value="Nữ" id="female">
            <label for="female"> Nữ </label></br>
            <label> Địa chỉ: </label></br>
            <textarea name="diaChi" rows="5" cols="40">
            </textarea></br>
<%--            Combobox--%>
            <label>Chọn Quốc gia:</label>
            <select name="quocGia" id="country">
                <option value="VN">Việt Nam</option>
                <option value="HQ">Hàn Quốc</option>
                <option value="NB">Nhật Bản</option>
                <option value="TQ">Trung Quốc</option>
            </select></br>
        <%--            List box--%>
            <label>Chọn Môn học:</label>
            <select name="monHoc" id="subject" size="3" multiple>
                <option value="toan">Toán</option>
                <option value="van">Văn</option>
                <option value="anh">Anh</option>
            </select></br>
<%--        List Check box--%>
            <label>Chọn Sở thích:</label></br>
            <input type="checkbox" name="soThich" value="reading" id="hobby1">
            <label for="hobby1">Đọc sách</label></br>
            <input type="checkbox" name="soThich" value="travelling" id="hobby2">
            <label for="hobby2">Du lịch</label></br>
            <input type="checkbox" name="soThich" value="music" id="hobby3">
            <label for="hobby3">Nghe nhạc</label></br>

            <label>Ảnh đại diện</label></br>
            <input type="file" name="photo"></br>

            <button type="submit"> Đăng Ký</button>
        </div>
    </form>

</body>
</html>
