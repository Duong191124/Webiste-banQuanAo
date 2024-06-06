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
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h4>Thêm màu sắc</h4>
<div>
    <form action="/nhan-vien/nhanvienstore" method="post">
        <div class="mt-2">
            <label for="" class="form-label" >Mã: </label>
            <input type="text" name="ma" class="form-control" placeholder="Mã" value="${data.ma}">
            <c:if test="${not empty error['ma']}">
                <small style="color: red">${error['ma']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label" >Tên: </label>
            <input type="text" name="ten" class="form-control" placeholder="Tên" value="${data.ten}">
            <c:if test="${not empty error['ten']}">
                <small style="color: red">${error['ten']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label" >Tên đăng nhập: </label>
            <input type="text" name="tenDangNhap" class="form-control" placeholder="Tên đăng nhập" value="${data.tenDangNhap}">
            <c:if test="${not empty error['tenDangNhap']}">
                <small style="color: red">${error['tenDangNhap']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label" >Mật khẩu: </label>
            <input type="password" name="matKhau" class="form-control" placeholder="Mật khẩu" value="${data.matKhau}">
            <c:if test="${not empty error['matKhau']}">
                <small style="color: red">${error['matKhau']}</small>
            </c:if>
        </div>
        <div class="mt-2">
            <label for="" class="form-label" >Chức vụ: </label>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="radio1" name="role" value="1" checked>Admin
                <label class="form-check-label" for="radio1"></label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="radio2" name="role" value="0">NhanVien
                <label class="form-check-label" for="radio2"></label>
            </div>
        </div>
        <div class="mt-2 d-flex justify-content-center">
            <a href="/nhan-vien/nhanvien" class="btn btn-primary w-25 me-2">Back</a>
            <button type="submit" class="btn btn-success w-25">Tạo mới</button>
        </div>
    </form>
</div>
</body>
</html>