<%@ page language="java" pageEncoding="UTF-8" %>
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
    <h4>Update</h4>
    <form action="/spct/spctupdate/${data.id}" method="POST">
        <div class="mt-2">
            <label for="" class="form-label">Sản phẩm: </label>
            <select name="sp.id" class="form-control">
                <option value="${data.sp.id}" selected>${data.sp.ten}</option>
                <c:forEach var="product" items="${availableProducts}">
                    <option value="${product.id}" <c:if test="${product.id == data.sp.id}">selected</c:if>>${product.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Màu sắc: </label>
            <select name="ms.id" class="form-control">
                <option value="${data.ms.id}" selected>${data.ms.ten}</option>
                <c:forEach var="color" items="${availableColors}">
                    <option value="${color.id}" <c:if test="${color.id == data.ms.id}">selected</c:if>>${color.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Kích thước: </label>
            <select name="kt.id" class="form-control">
                <option value="${data.kt.id}" selected>${data.kt.ten}</option>
                <c:forEach var="size" items="${availableSizes}">
                    <option value="${size.id}" <c:if test="${size.id == data.kt.id}">selected</c:if>>${size.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Ma: </label>
            <input type="text" class="form-control" name="maSPCT" value="${data.maSPCT}">
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Số lượng: </label>
            <input type="text" placeholder="Số lượng" class="form-control" name="soLuong" value="${data.soLuong}">
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Đơn giá: </label>
            <input type="text" placeholder="Đơn giá" class="form-control" name="donGia" value="${data.donGia}">
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Trạng thái: </label>
            <select name="trangThai" id="" class="form-control">
                <option value="1" <c:if test="${data.trangThai == 1}">selected</c:if>>Hoạt động</option>
                <option value="0" <c:if test="${data.trangThai == 0}">selected</c:if>>Không hoạt động</option>
            </select>
        </div>
        <div class="mt-2">
            <button type="submit" class="btn btn-success w-25 rounded rounded-2">Update</button>
        </div>
    </form>
</body>
</html>