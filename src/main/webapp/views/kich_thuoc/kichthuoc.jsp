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
        <h4>Danh sách kích thước</h4>
        <a href="/san-pham/sanpham" class="btn btn-info">Back</a>
    </div>
    <div class="mt-2">
        <a href="/kich-thuoc/createkichthuoc" class="btn btn-success">Thêm kích thước</a>
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
                <c:forEach items="${data.content}" var="kichthuoc" varStatus="KT">
                    <tr>
                        <td>${kichthuoc.id}</td>
                        <td>${kichthuoc.ma}</td>
                        <td>${kichthuoc.ten}</td>
                        <td>${kichthuoc.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                        <td>
                            <a href="/kich-thuoc/kichthuocdelete/${kichthuoc.id}" class="btn btn-danger">Delete</a>
                            <a href="/kich-thuoc/kichthuocedit/${kichthuoc.id}" class="btn btn-danger">Edit</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="mt-2 d-flex justify-content-center">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/kich-thuoc/kichthuoc?page=${data.number - 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${ data.totalPages }" var="page">
                <c:if test="${ page == 1 || page == data.totalPages || ( page >= data.number - 1 && page <= data.number + 1 ) }">
                    <li class="page-item">
                        <a class="page-link"
                           href="/kich-thuoc/kichthuoc?page=${page}">
                                ${ page }
                        </a>
                    </li>
                </c:if>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="/kich-thuoc/kichthuoc?page=${data.number + 1}">Next</a></li>
        </ul>
    </div>
</body>
</html>