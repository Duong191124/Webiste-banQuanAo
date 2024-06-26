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
    <h4>Danh sách khách hàng</h4>
    <c:choose>
        <c:when test="${sessionScope.role == 1}">
            <a href="${pageContext.request.contextPath}/admin/adminindex" class="btn btn-info">Back</a>
        </c:when>
        <c:when test="${sessionScope.role == 0}">
            <a href="${pageContext.request.contextPath}/user/userindex" class="btn btn-info">Back</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login" class="btn btn-info">Back</a>
        </c:otherwise>
    </c:choose>
</div>
<div class="mt-2">
    <form action="/khach-hang/searchkhachhang" method="get">
        <select name="ten" style="width: 300px; height: 35px; border-radius: 7px;" class="mt-2">
            <c:forEach var="name" items="${productNames}">
                <option value="${name}">${name}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-info ms-2">Search</button>
    </form>
</div>
<div class="mt-2">
    <a href="/khach-hang/khachhangcreate" class="btn btn-success">Thêm khách hàng</a>
</div>
<div class="mt-2">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>SĐT</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="kh" varStatus="KH">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.soDienThoai}</td>
                <td>${kh.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/khach-hang/khachhangdelete/${kh.id}" class="btn btn-danger">Delete</a>
                    <a href="/khach-hang/khachhangedit/${kh.id}" class="btn btn-danger">Edit</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div class="mt-2 d-flex justify-content-center">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="/khach-hang/khachhang?page=${data.number - 1}">Previous</a>
        </li>
        <c:forEach begin="1" end="${ data.totalPages }" var="page">
            <c:if test="${ page == 1 || page == data.totalPages || ( page >= data.number - 1 && page <= data.number + 1 ) }">
                <li class="page-item">
                    <a class="page-link"
                       href="/khach-hang/khachhang?page=${page}">
                            ${ page }
                    </a>
                </li>
            </c:if>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="/khach-hang/khachhang?page=${data.number + 1}">Next</a></li>
    </ul>
</div>
</body>
</html>