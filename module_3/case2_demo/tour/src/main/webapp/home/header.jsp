<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/7/2023
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    header {
        position: fixed;
        top: 0;
        botop: 0;
        left: 0;
        right: 0;
        z-index: 9999;
        background-color: white;
    }

    .carousel .input-group {
        padding-top: 280px;
        padding-left: 150px;
        position: absolute;
        z-index: 2;
    }

    ​
    .carousel .intro span {
        color: rgba(255, 255, 255, 1);
        font-size: 20px;
        font-family: Arial;
    }

    ​
    .carousel .form-control {
        font-size: 1.5rem;
    }
</style>
<header>
        <div class="col-md-12" style="position: fixed;padding-top: 0">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <svg class="bi me-2" width="40" height="32">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
                    <span class="fs-4" style=" font-family: 'Lobster';font-size: 70px;color: #ff5b00 ">Simple Booking </span>
                </a>
                <input type="text" placeholder=" Search..."
                       style="border-radius: 35px;width: 200px;background-color: #f5f5f5">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/RoleServlet" class="nav-link" style="color: #222222">Trang Chủ</a>
                    </li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: #222222">Tour</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: #222222">Liên Hệ</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: #222222">Đăng Kí</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="margin-top: -15px">
                        <button style="background-color: #ff5b00;border-radius: 35px;border: none;height: 40px;text-align: center;width: 100px;color: white;padding-top: 0px;padding-bottom: 0px ">
                            Đăng Nhập
                        </button>
                    </a></li>
                </ul>
            </header>
        </div>
</header>

