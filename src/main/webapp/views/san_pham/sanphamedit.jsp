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
    <form action="/san-pham/sanphamupdate/${data.id}" method="POST">
        <div class="mt-2">
            <label for="" class="form-label">Ma: </label>
            <input type="text" placeholder="Ma" class="form-control" name="ma" value="${data.ma}">
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Ten: </label>
            <input type="text" placeholder="Ten" class="form-control" name="ten" value="${data.ten}">
        </div>
        <div class="mt-2">
            <label for="" class="form-label">Trang thai: </label>
            <select name="trangThai" id="" class="form-control">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Hoạt động</option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Không hoạt động</option>
            </select>
        </div>
        <div class="mt-2">
            <button type="submit" class="btn btn-success w25 rounded rounded-2">Update</button>
        </div>
    </form>
</body>
</html>