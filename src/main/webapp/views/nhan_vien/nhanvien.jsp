
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
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
    <h4>Danh sách nhân viên</h4>
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
    <a href="/nhan-vien/createnhanvien" class="btn btn-success">Thêm nhân viên</a>
</div>
<div class="mt-2">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Chức vụ</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="nhanvien">
            <tr>
                <td>${nhanvien.id}</td>
                <td>${nhanvien.ma}</td>
                <td>${nhanvien.ten}</td>
                <td>${nhanvien.tenDangNhap}</td>
                <td>${nhanvien.matKhau}</td>
                <td>${nhanvien.role == 1 ? "Admin" : "Nhân Viên"}</td>
                <td>
                    <a href="/nhan-vien/nhanviendelete/${nhanvien.id}" class="btn btn-danger">Delete</a>
                    <a href="/nhan-vien/nhanvienedit/${nhanvien.id}" class="btn btn-danger">Edit</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div class="mt-2 d-flex justify-content-center">
    <ul class="pagination">
        <li class="page-item ${data.number == 1 ? '' : 'disabled'}">
            <a class="page-link" href="/nhan-vien/nhanvien?page=${data.number - 1}">Previous</a>
        </li>
        <c:forEach begin="1" end="${data.totalPages}" var="page">
            <c:if test="${page == 1 || page == data.totalPages || (page >= data.number && page <= data.number + 1)}">
                <li class="page-item ${page == data.number ? 'active' : ''}">
                    <a class="page-link" href="/nhan-vien/nhanvien?page=${page}">
                            ${page}
                    </a>
                </li>
            </c:if>
        </c:forEach>
        <li class="page-item ${data.number + 1 >= data.totalPages ? 'disabled' : ''}">
            <a class="page-link" href="/nhan-vien/nhanvien?page=${data.number + 1}">Next</a>
        </li>
    </ul>
</div>
</body>
</html>