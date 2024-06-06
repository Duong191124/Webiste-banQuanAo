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
            <select name="sp" value="${data.sp.ten}" class="form-control">
                <option value="${data.sp.ten}">${data.sp.ten}</option>
                <c:forEach var="product" items="${availableProducts}">
                    <option value="${product}">${product}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Màu sắc: </label>
            <select name="ms" value="${data.ms.ten}" class="form-control">
                <option value="${data.ms.ten}">${data.ms.ten}</option>
                <c:forEach var="color" items="${availableColors}">
                    <option value="${color}">${color}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Kích thước: </label>
            <select name="kt" value="${data.kt.ten}" class="form-control">
                <option value="${data.kt.ten}">${data.kt.ten}</option>
                <c:forEach var="size" items="${availableSizes}">
                    <option value="${size}">${size}</option>
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
            <label for="" class="form-label">Trang thai: </label>
            <select name="trangThai" id="" class="form-control" value="${data.trangThai}">
                <option value="1">Hoạt động</option>
                <option value="0">Không hoạt động</option>
            </select>
        </div>
        <div class="mt-2">
            <button type="submit" class="btn btn-success w-25 rounded rounded-2">Update</button>
        </div>
    </form>
</body>
</html>