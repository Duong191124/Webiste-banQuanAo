<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="d-flex justify-content-between mt-2">
    <h4>Danh sách hóa đơn chi tiết</h4>
    <a href="/hoa-don/hoadon" class="btn btn-info">Back</a>
</div>
<div class="mt-2">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã hóa đơn</th>
            <th>Mã spct</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Thời gian</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="hdct" varStatus="HDCT">
            <tr>
                <td>${hdct.id}</td>
                <td>${hdct.hd.id}</td>
                <td>${hdct.spct.maSPCT}</td>
                <td>${hdct.soLuong}</td>
                <td>${hdct.donGia}</td>
                <td>${hdct.thoiGian}</td>
                <td>${hdct.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                <td>
                    <a href="/hdct/hdctedit/${hdct.id}" class="btn btn-danger">Edit</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>