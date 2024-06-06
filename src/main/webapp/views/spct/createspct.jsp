<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h4>Create</h4>
    <form action="/spct/spctstore" method="POST">
        <div class="mt-2">
            <label for="" class="form-label">Sản phẩm: </label>
            <select name="sp.id" class="form-control">
                <c:forEach var="product" items="${availableProducts}">
                    <option value="${product.id}">${product.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Màu sắc: </label>
            <select name="ms.id" class="form-control">
                <c:forEach var="color" items="${availableColors}">
                    <option value="${color.id}">${color.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Kích thước: </label>
            <select name="kt.id" class="form-control">
                <c:forEach var="size" items="${availableSizes}">
                    <option value="${size.id}">${size.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Ma: </label>
            <input type="text" placeholder="Ma" class="form-control" name="maSPCT" value="${data.maSPCT}">
            <c:if test="${not empty error['maSPCT']}">
                <small style="color: red">${error['maSPCT']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Số lượng: </label>
            <input type="number" placeholder="Số lượng" class="form-control" name="soLuong" value="${data.soLuong}">
            <c:if test="${not empty error['soLuong']}">
                <small style="color: red">${error['soLuong']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Đơn giá: </label>
            <input type="number" placeholder="Đơn giá" class="form-control" name="donGia" value="${data.donGia}">
            <c:if test="${not empty error['donGia']}">
                <small style="color: red">${error['donGia']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Trang thai: </label>
            <select name="trangThai" id="" class="form-control" value="${data.trangThai}">
                <option value="1">Hoạt động</option>
                <option value="0">Không hoạt động</option>
            </select>
        </div>
        <div class="mt-2 d-flex justify-content-center">
            <a href="/san-pham/sanpham" class="btn btn-primary me-2 w-25 rounded rounded-2">Back</a>
            <button type="submit" class="btn btn-success w-25 rounded rounded-2">Create</button>
        </div>
    </form>
</body>
</html>