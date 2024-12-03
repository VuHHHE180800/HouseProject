<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/styles.css" rel="stylesheet">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
        /* CSS for the dropdown */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #3e8e41;
        }

        .dropbtn {
            background-color: #f9f9f9;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }
        a {
            text-decoration: none;
        }
        /* Pagination container */
.pagination {
    display: flex;
    justify-content: center;
    padding-left: 0;
    list-style: none;
    border-radius: 0.25rem;
}

/* Pagination items */
.pagination .page-item {
    margin: 0 4px; /* Adjust spacing between items */
}

/* Pagination links */
.pagination .page-link {
    position: relative;
    display: block;
    padding: 0.75rem 1.25rem;
    margin-left: -1px;
    line-height: 1.25;
    color: #007bff;
    background-color: #fff;
    border: 1px solid #dee2e6;
    text-decoration: none; /* Remove underline */
    transition: background-color 0.3s, color 0.3s;
}

/* Hover and focus states for pagination links */
.pagination .page-link:hover,
.pagination .page-link:focus {
    z-index: 2;
    color: #0056b3;
    background-color: #e9ecef;
    border-color: #dee2e6;
}

/* Active page */
.pagination .page-item.active .page-link {
    z-index: 3;
    color: #fff; /* Text color */
    background-color: #28a745; /* Green background */
    border-color: #28a745;
}

/* Disabled page */
.pagination .page-item.disabled .page-link {
    color: #6c757d;
    pointer-events: none;
    background-color: #fff;
    border-color: #dee2e6;
}

    </style>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="home">HolaHome</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <c:if test="${sessionScope.acc.role}">
                        <li class="nav-item ">
                            <a class="nav-link "  href="shophome?uid=${sessionScope.acc.user_id}" >Shop</a>
                        </li>
                        </c:if>
                        <c:if test="${!sessionScope.acc.role}">
                        <li class="nav-item ">
                            <a class="nav-link "  href="changerole" >Sell</a>
                        </li>
                        </c:if>
                    </ul>
                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <c:if test="${!sessionScope.acc.role}">
                    <form class="d-flex" style="margin-left: 10px">
                        <button class="btn btn-outline-dark" type="submit" >
                            <i class="bi-cart-fill me-1"></i>
                            <a href="cart" style="color: #000">Cart</a>
                            <%
            String totalCart = (session.getAttribute("totalCart") != null) ? session.getAttribute("totalCart").toString() : "0";
        %>
                            <span class="badge bg-dark text-white ms-1 rounded-pill"><%=totalCart%></span>
                        </button>
                    </form>
                    </c:if>
                    <div class="dropdown"style="margin-left: 10px" >
                        <div class="dropbtn"><img src="img/user.png" alt="User" width="32" height="32" class="rounded-circle"></div>
                        <div class="dropdown-content">
                            
                            <a href="#">Hello ${sessionScope.acc.username}</a>
                            <c:if test="${!sessionScope.acc.role}">
                            <a href="deal">Your deal</a>
                            </c:if>
                            <a href="profile?uid=${sessionScope.acc.user_id}">Your profile</a>
                            <a href="changepass.jsp">Change password</a>
                            <hr>
                            <a href="logout">Logout</a>
                        </div>
                    </div>

                   
                </div>
            </div>
        </nav>
        <header class="bg-dark" style="padding: 0;    height: 600px;">
            <div style="width: 100%; height: 100%; overflow: hidden;">
                <img src="img/header.jpg" style="width: 100%; height: 100%; object-fit: cover;" alt="Header Image">
            </div>
        </header>        
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
         <!-- End of menu -->
        <div class="container" style="margin-top: 10px">
            <div class="row">
                <jsp:include page="filter.jsp"></jsp:include>

                <div class="col-sm-9">
                    <div class="row" >
                        <c:forEach items="${listP}" var="o">
                            
                            <div class="col-12 col-md-6 col-lg-4" style="margin-top: 10px">
                                <div class="card">
                                    <img class="card-img-top" style="width: 100%;height:  250px;" src="${o.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.home_id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">Địa chỉ: ${o.address}</p>
                                        <p class="card-text show_txt">Mô tả: ${o.description}</p>
                                        <p class="card-text show_txt">Giá điện: ${o.elec_price}đ/1 số</p>
                                        <p class="card-text show_txt">Giá dịch vụ: ${o.service_price}đ</p>
                                        <div class="row">
                                            <div class="col">
                                                <h4 class="btn btn-danger btn-block">${o.review_score}</h4>

                                            </div>
                                            <div class="col">
                                                <h4  class="btn btn-success btn-block">${o.room_price} vnđ</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                        <c:forEach begin="1" end="${numPage}" var="i">
                            <li class="page-item ${tag == i ? 'active' : ''}"><a class="page-link" href="home?index=${i}">${i}</a></li>
                        </c:forEach>

                        </ul>
                      </nav>
                </div>
                
            </div>
        </div>

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright © Your Website 2023</p></div>
        </footer>
    </body>
</html>

