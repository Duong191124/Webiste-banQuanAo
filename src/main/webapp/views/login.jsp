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
    <title>Login page</title>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3 class="d-flex justify-content-center card-title">Login Form</h3>
                <div class="mt-3">
                    <form action="/login" method="post">
                        <div class="mt-2">
                            <label for="" class="form-label">Username: </label>
                            <input type="text" placeholder="Username" name="tenDangNhap" class="form-control">
                        </div>
                        <div class="mt-2">
                            <label for="" class="form-label">Password: </label>
                            <input type="text" placeholder="Password" name="matKhau" class="form-control">
                        </div>
                        <div class="mt-2 d-flex justify-content-center">
                            <button type="submit" class="btn btn-success w-25">Login</button>
                        </div>
                    </form>
                    <c:if test="${not empty error}">
                        <p style="color: red">${error}</p>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>