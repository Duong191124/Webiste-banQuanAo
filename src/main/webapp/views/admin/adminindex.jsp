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
    <title>User Page</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container">
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto mt-2">
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/nhan-vien/nhanvien">Quản lý nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/khach-hang/khachhang">Quản lý khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/san-pham/sanpham">Quản lý sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="/hoa-don/hoadon">Quản lý hóa đơn</a>
                </li>
            </ul>
            <form class="d-flex">
                <h5 class="me-3 mt-2" style="color: white">Welcome, ${username}</h5>
                <a href="/logout" class="btn btn-danger">Logout</a>
            </form>
        </div>
    </div>
</nav>
</body>
</html>