<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" pageEncoding="UTF-8" %>
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
    <div class="d-flex justify-content-between mt-2">
        <h4>Danh sách màu sắc</h4>
        <a href="/spct/spct" class="btn btn-info">Back</a>
    </div>
    <div class="mt-2">
        <a href="/mau-sac/createmausac" class="btn btn-success">Thêm màu sắc</a>
    </div>
    <div class="mt-2">
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Mã</th>
                    <th>Tên</th>
                    <th>Trạng thái</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${data}" var="mausac" varStatus="MS">
                    <tr>
                        <td>${mausac.id}</td>
                        <td>${mausac.ma}</td>
                        <td>${mausac.ten}</td>
                        <td>${mausac.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                        <td>
                            <a href="/mau-sac/mausacdelete/${mausac.id}" class="btn btn-danger">Delete</a>
                            <a href="/mau-sac/mausacedit/${mausac.id}" class="btn btn-danger">Edit</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="mt-2 d-flex justify-content-center">
        <ul class="pagination">
            <li class="page-item">
                <c:if test="${page > 1}">
                    <a href="?page=${page - 1}" class="page-link">Previous</a>
                </c:if>
            </li>
            <c:forEach var="pageNumber" begin="1" end="${maxPage}">
                <li class="page-item">
                    <a href="?page=${pageNumber}" class="page-link">${pageNumber}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <c:if test="${page < maxPage}">
                    <a href="?page=${page + 1}" class="page-link">Next</a>
                </c:if>
            </li>
        </ul>
    </div>
</body>
</html>