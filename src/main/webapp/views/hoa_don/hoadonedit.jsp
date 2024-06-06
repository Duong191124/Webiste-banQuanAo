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
<form action="/hoa-don/hoadonupdate/${data.id}" method="POST">
    <div class="mt-2">
        <label for="" class="form-label">Khách hàng: </label>
        <select name="kh.id" class="form-control">
            <option value="${data.kh.id}" selected>${data.kh.ten}</option>
            <c:forEach var="user" items="${availableUser}">
                <option value="${user.id}" <c:if test="${user.id == data.kh.id}">selected</c:if>>${user.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-2">
        <label for="" class="form-label">Nhân viên: </label>
        <select name="nv.id" class="form-control">
            <option value="${data.nv.id}" selected>${data.nv.ten}</option>
            <c:forEach var="employee" items="${availableEmployee}">
                <option value="${employee.id}" <c:if test="${employee.id == data.nv.id}">selected</c:if>>${employee.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-2">
        <label for="" class="form-label">Ngày mua hàng: </label>
        <input type="date" placeholder="Ngày mua hàng" class="form-control" name="ngayMuaHang" value="${data.ngayMuaHang}">
    </div>
    <div class="mt-2">
        <label for="" class="form-label">Trang thai: </label>
        <select name="trangThai" id="" class="form-control">
            <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Đã thanh toán</option>
            <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Chưa thanh toán</option>
        </select>
    </div>
    <br>
    <div>
        <button type="submit" class="btn btn-success w25 rounded rounded-2">Update</button>
    </div>
</form>
</body>
</html>