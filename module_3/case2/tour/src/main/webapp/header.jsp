<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/5/2023
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%--    <link rel="stylesheet" href="/bootstrap-5.2.3-dist/css/bootstrap.css">--%>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700&display=swap"
          rel="stylesheet">
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.css"
            rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <style>
        nav {
            background-color: #0F3371;
        }

    </style>
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
</head>
<body>
<div id="side-bar">
    <nav>
        <div class="logo-name">
            <div class="logo-image">
                <img src="images/logo.png" alt="">
            </div>
            <span class="logo-name" style="font-size:30px ;color: white ">Simple </span>
        </div>

        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="home.jsp">
                    <i class="uil uil-estate" style="color:white;"></i>
                    <span class="link-name" style="color:white;">Thống kê</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-estate" style="color:white;"></i>
                    <span class="link-name" style="color:white;">Tài khoản</span>
                </a></li>
                <li><a href="/employeeServlet">
                    <i class="uil uil-files-landscapes" style="color:white;"></i>
                    <span class="link-name" style="color:white;">Nhân viên</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-chart" style="color:white;"></i>
                    <span class="link-name" style="color:white;">Khách hàng</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-thumbs-up" style="color:white;"></i>
                    <span class="link-name" style="color:white;">Tour</span>
                </a></li>
            </ul>

            <ul class="logout-mode">
                <li><a href="#">
                    <i class="uil uil-signout" style="color:white;"></i>
                    <span class="link-name" style="color:white;">Logout</span>
                </a></li>
            </ul>
        </div>
    </nav>
</div>

<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.js"
></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<%--<script src="/bootstrap-5.2.3-dist/js/bootstrap.bundle.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="/js/script.js"></script>

</body>
</html>