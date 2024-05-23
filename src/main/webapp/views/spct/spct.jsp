<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="d-flex justify-content-between mt-2">
    <h4>Danh sách sản phẩm chi tiết</h4>
    <a href="/san-pham/sanpham" class="btn btn-info">Back</a>
</div>
    <div class="mt-2">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Trạng thái</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${foundData}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.idSanPham}</td>
                    <td>${product.ma}</td>
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
    <div class="mt-2 d-flex justify-content-center">
        <ul class="pagination">
            <li class="page-item">
                <c:if test="${page > 1}">
                    <a href="spctdetail?idSanPham=${idSanPham}&page=${page - 1}" class="page-link">Previous</a>
                </c:if>
            </li>
            <c:forEach var="pageNumber" begin="1" end="${maxPage}">
                <li class="page-item ${pageNumber == page ? 'active' : ''}">
                    <a href="spctdetail?idSanPham=${idSanPham}&page=${pageNumber}" class="page-link">${pageNumber}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <c:if test="${page < maxPage}">
                    <a href="spctdetail?idSanPham=${idSanPham}&page=${page + 1}" class="page-link">Next</a>
                </c:if>
            </li>
        </ul>
    </div>
</body>
</html>