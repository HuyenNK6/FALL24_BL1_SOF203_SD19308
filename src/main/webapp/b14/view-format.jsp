<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 10/9/2024
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Số ban đầu: ${number}</h1>
<%--    groupingUsed: dấu phẩy để ngăn cách hàng nghìn--%>
    <h1>Số sau định dạng: <fmt:formatNumber value="${number}" type="number" groupingUsed="true" minFractionDigits="3" maxFractionDigits="3"> </fmt:formatNumber></h1>

    <h1>Số ban đầu: ${currency}</h1>
    <h1>Số ban đầu: <fmt:formatNumber value="${currency}" type="currency" currencySymbol="VND"></fmt:formatNumber></h1>
<%--useBean quản lý các đối tượng JavaBean--%>
    <jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
    <h1>Ngày hiện tại: <fmt:formatDate value="${now}"></fmt:formatDate></h1>
    <h1>Ngày định dạng: <fmt:formatDate value="${now}" pattern="dd-MM-yyyy"></fmt:formatDate></h1>
    <h1>Ngày định dạng: <fmt:formatNumber value="${now.time}" pattern="#,###.00"></fmt:formatNumber></h1>

</body>
</html>
