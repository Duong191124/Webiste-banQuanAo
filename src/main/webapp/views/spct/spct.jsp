<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
<div class="d-flex justify-content-between mt-2">
    <h4>Danh sách sản phẩm chi tiết</h4>
    <a href="/san-pham/sanpham" class="btn btn-info">Back</a>
</div>
<div class="mt-2">
    <a href="/spct/createspct" class="btn btn-success">Thêm sản phẩm chi tiết</a>
</div>
    <div class="mt-2">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Tên màu sắc</th>
                <th>Tên kích thước</th>
                <th>Mã SPCT</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Trạng thái</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${foundData.content}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.sp.ten}</td>
                    <td>${product.ms.ten}</td>
                    <td>${product.kt.ten}</td>
                    <td>${product.maSPCT}</td>
                    <td>${product.soLuong}</td>
                    <td>${product.donGia}</td>
                    <td>${product.trangThai == 1 ? "Hoạt động" : "Không hoạt động"}</td>
                    <td>
                        <a href="/mau-sac/mausac" class="btn btn-primary">Màu sắc</a>
                        <a href="/kich-thuoc/kichthuoc" class="btn btn-secondary">Kích thước</a>
                        <a href="/spct/spctdelete/${product.id}" class="btn btn-danger">Delete</a>
                        <a href="/spct/spctedit/${product.id}" class="btn btn-warning">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="d-flex justify-content-center">
    <ul class="pagination">
        <c:if test="${!foundData.isFirst()}">
            <li class="page-item">
                <a class="page-link" href="<c:url value='/spct/spct?idSanPham=${idSanPham}&page=${foundData.number}&limit=${pageSize}'/>">Previous</a>
            </li>
        </c:if>
        <c:forEach begin="1" end="${foundData.totalPages}" var="page">
            <c:if test="${page == 1 || page == foundData.totalPages || (page >= foundData.number - 1 && page <= foundData.number + 2)}">
                <li class="page-item <c:if test='${page == foundData.number + 1}'>active</c:if>'">
                    <a class="page-link"  href="<c:url value='/spct/spct?idSanPham=${idSanPham}&page=${page}&limit=${pageSize}'/>">${page}</a>
                </li>
            </c:if>
        </c:forEach>
        <c:if test="${!foundData.isLast()}">
            <li class="page-item">
                <a class="page-link" href="<c:url value='/spct/spct?idSanPham=${idSanPham}&page=${foundData.number + 2}&limit=${pageSize}'/>">Next</a>
            </li>
        </c:if>
    </ul>
    </div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>