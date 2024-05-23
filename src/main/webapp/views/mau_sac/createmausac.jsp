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
        <form action="/mau-sac/mausacstore" method="post">
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
                <label for="" class="form-label" >Trạng thái: </label>
                <select name="trangThai" class="form-control" id="">
                    <option value="1">Hoạt động</option>
                    <option value="0">Ngừng hoạt động</option>
                </select>
            </div>
            <div class="mt-2 d-flex justify-content-center">
                <a href="/mau-sac/mausac" class="btn btn-primary w-25 me-2">Back</a>
                <button type="submit" class="btn btn-success w-25">Tạo mới</button>
            </div>
        </form>
    </div>
</body>
</html>