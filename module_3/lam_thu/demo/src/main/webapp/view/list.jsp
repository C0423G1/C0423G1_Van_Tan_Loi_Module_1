<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/9/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/fixedheader/3.4.0/css/fixedHeader.bootstrap5.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>

    </style>
</head>
<body>
<h1 style=" font-family: 'Montagu Slab', serif;text-align: center"> Hiển Thị Danh Sách</h1>
<table id="example" class="table" >
    <a href="/BookServlet?action=theloai"><button type="button" class="btn btn-outline-primary" style="margin: 1%">Thêm Mới </button></a>
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên Sách</th>
        <th scope="col">Số trang</th>
        <th scope="col">tác Giả</th>
        <th scope="col">Thể loại</th>
        <th scope="col" style="width: 150px"></th>
    </tr>
    </thead>
    <tbody class="table-group-divider">
    <c:forEach var="books" items="${books}">
    <tr>
        <th name="id" data-id="${books.idBook}">${books.idBook}</th>
        <td>${books.title}</td>
        <td>${books.pageSize}</td>
        <td>${books.author}</td>
        <td>${books.category}</td>
        <td>
            <button type="button" class="btn btn-outline-info">Sửa</button>
            <button class="btn btn-outline-danger deleteButton">Xóa</button>
        </td>
    </tr>

    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        const deleteButtons = document.querySelectorAll('.deleteButton');

        deleteButtons.forEach(button => {
            button.addEventListener('click', function() {
                const id = this.closest('tr').querySelector('[data-id]').getAttribute('data-id');

                const swalWithBootstrapButtons = Swal.mixin({
                    customClass: {
                        confirmButton: 'btn btn-success',
                        cancelButton: 'btn btn-danger'
                    },
                    buttonsStyling: false
                });

                swalWithBootstrapButtons.fire({
                    title: 'Bạn có chắc không?',
                    text: "Bạn sẽ không thể hoàn tác điều này",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Vâng, tôi muốn xóa',
                    cancelButtonText: 'Không, hủy bỏ',
                    reverseButtons: true
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Khi xác nhận xóa
                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'Your file will be deleted.',
                            'success'
                        ).then(() => {
                            window.location.href = "/BookServlet?action=delete&id=" + id; // Chuyển hướng đến servlet xóa
                        });
                    } else if (result.dismiss === Swal.DismissReason.cancel) {
                        // Khi hủy bỏ
                        swalWithBootstrapButtons.fire(
                            'Cancelled',
                            'Your imaginary file is safe :)',
                            'error'
                        ).then(() => {
                            window.location.href = "/BookServlet"; // Chuyển hướng đến servlet hủy bỏ
                        });
                    }
                });
            });
        });
    });
</script>

<script>
    new DataTable('#example', {
        paging: true,
        searching: false,
        fixedHeader: true,
        language: {
            info: "Hiển thị từ _START_ đến _END_ trong tổng số _TOTAL_ mục",
            infoEmpty: "Không có mục để hiển thị",
            infoFiltered: "(đã lọc từ _MAX_ mục)",
            zeroRecords: "Không tìm thấy mục phù hợp",
            lengthMenu: "Hiển thị _MENU_ mục",
            paginate: {
                first: "Đầu",
                last: "Cuối",
                next: "Sau",
                previous: "Trước"
            },
        },
    });
</script>

</body>
</html>