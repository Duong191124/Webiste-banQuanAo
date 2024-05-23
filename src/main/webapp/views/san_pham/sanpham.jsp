<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ page language="java" pageEncoding="UTF-8" %>
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
    <h4>Danh sách sản phẩm</h4>
    <a href="${pageContext.request.contextPath}/back" class="btn btn-info">Back</a>
</div>
<div class="mt-2">
    <form action="/san-pham/searchsanpham" method="get">
        <select name="name" style="width: 300px; height: 35px; border-radius: 7px;" class="mt-2">
            <c:forEach var="name" items="${productNames}">
                <option value="${name}">${name}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-info ms-2">Search</button>
    </form>
</div>
<div class="mt-2">
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.ma}</td>
                <td>${product.ten}</td>
                <td>${product.trangThai == 1 ? "Hoạt động" : "Không hoạt động"}</td>
                <td>
                    <a href="/spct/spctdetail?idSanPham=${product.id}" class="btn btn-primary">Chi Tiết</a>
                    <a href="/san-pham/sanphamdelete/${product.id}" class="btn btn-danger">Delete</a>
                    <a href="/san-pham/sanphamedit/${product.id}" class="btn btn-warning">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="mt-2 d-flex justify-content-center">
    <ul class="pagination">
        <li class="page-item">
            <c:if test="${page > 1}">
                <a href="?page=${page - 1}" class="page-link">Previous</a>
            </c:if>
        </li>
        <c:forEach var="pageNumber" begin="1" end="${maxPage}">
            <li class="page-item">
                <a href="?page=${pageNumber}" class="page-link">${pageNumber}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <c:if test="${page < maxPage}">
                <a href="?page=${page + 1}" class="page-link">Next</a>
            </c:if>
        </li>
    </ul>
</div>
</body>
</html>