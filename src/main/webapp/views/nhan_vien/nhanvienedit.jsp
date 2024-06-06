<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
<form action="/nhan-vien/nhanvienupdate/${data.id}" method="POST">
    <div class="mt-2">
        <label for="" class="form-label" >Mã: </label>
        <input type="text" name="ma" class="form-control" placeholder="Mã" value="${data.ma}">
    </div>
    <div class="mt-2">
        <label for="" class="form-label" >Tên: </label>
        <input type="text" name="ten" class="form-control" placeholder="Tên" value="${data.ten}">
    </div>
    <div class="mt-2">
        <label for="" class="form-label" >Tên đăng nhập: </label>
        <input type="text" name="tenDangNhap" class="form-control" placeholder="Tên đăng nhập" value="${data.tenDangNhap}">
    </div>
    <div class="mt-2">
        <label for="" class="form-label" >Mật khẩu: </label>
        <input type="password" name="matKhau" class="form-control" placeholder="Mật khẩu" value="${data.matKhau}">
    </div>
    <div class="mt-2">
        <label for="" class="form-label" >Chức vụ: </label>
        <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="role" value="1" ${data.role == 1 ? "checked" : ""}>Admin
            <label class="form-check-label" for="radio1"></label>
        </div>
        <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="role" value="0" ${data.role == 0 ? "checked" : ""}>NhanVien
            <label class="form-check-label" for="radio2"></label>
        </div>
    </div>
    <div class="mt-2">
        <button type="submit" class="btn btn-success w25 rounded rounded-2">Update</button>
    </div>
</form>
</body>
</html>