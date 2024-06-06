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
    <h4>Danh sách hóa đơn</h4>
    <a href="/admin/adminindex" class="btn btn-info">Back</a>
</div>
<div class="mt-2">
    <form action="/hoa-don/searchhoadon" method="get">
        <select name="trangThai" style="width: 300px; height: 35px; border-radius: 7px;" class="mt-2">
            <option value="1">Đã thanh toán</option>
            <option value="0">Chưa thanh toán</option>
        </select>
        <button type="submit" class="btn btn-info ms-2">Search</button>
    </form>
</div>
<div class="mt-2">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên khách hàng</th>
            <th>Mã nhân viên</th>
            <th>Ngày mua hàng</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="hoadon" varStatus="HD">
            <tr>
                <td>${hoadon.id}</td>
                <td>${hoadon.kh.ten}</td>
                <td>${hoadon.nv.ma}</td>
                <td>${hoadon.ngayMuaHang}</td>
                <td>${hoadon.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                <td>
                    <a href="/hdct/hdctdetail?idHoaDon=${hoadon.id}" class="btn btn-primary">Chi Tiết</a>
                    <a href="/hoa-don/hoadonedit/${hoadon.id}" class="btn btn-warning">Edit</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div class="mt-2 d-flex justify-content-center">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="/hoa-don/hoadon?page=${data.number - 1}">Previous</a>
        </li>
        <c:forEach begin="1" end="${ data.totalPages }" var="page">
            <c:if test="${ page == 1 || page == data.totalPages || ( page >= data.number - 1 && page <= data.number + 1 ) }">
                <li class="page-item">
                    <a class="page-link"
                       href="/hoa-don/hoadon?page=${page}">
                            ${ page }
                    </a>
                </li>
            </c:if>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="/hoa-don/hoadon?page=${data.number + 1}">Next</a></li>
    </ul>
</div>
</body>
</html>