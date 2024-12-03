<%-- 
    Document   : Detail.jsp
    Created on : 1 thg 7, 2024, 22:49:40
    Author     : 84983
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
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
        </style>
    </head>
    <body>
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
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            <a href="cart" style="color: #000">Cart</a>
                            <%
            String totalCart = (session.getAttribute("totalCart") != null) ? session.getAttribute("totalCart").toString() : "0";
        %>
                            <span class="badge bg-dark text-white ms-1 rounded-pill"><%=totalCart%></span>
                        </button>
                    </form>
                        </c:if>
                   <div class="dropdown" >
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
        <div class="container" style="margin-top: 10px">
            <div class="row">
                <jsp:include page="filter.jsp"></jsp:include>
                <div class="col-sm-9">
                    <div class="container">
                        <c:forEach items="${sessionScope.listR}" var="o">
                        <div class="card" style="margin-top: 10px">
                            <div class="row">
                                
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${o.photo}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">PHÒNG ${o.room_name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency"></span><span class="num"> ${o.room_price} VNĐ</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Mô tả</dt>
                                            <dd><p><img style="width: 12px; height: auto" src="img/human.png"> ${o.numberHuman}</p></dd>
                                            <dd><p><img style="width: 20px; height: auto" src="img/square.png"> ${o.dt} m²</p></dd>
                                        </dl>

                                        
                                        <hr>
                                        <c:if test="${o.avaliable}">
                                        <a href="addtocart?rid=${o.room_id}" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng </a>
                                        </c:if>
                                        <c:if test="${!o.avaliable}">
                                            <div style="color: red"> Phòng hiện đang không còn trống </div><br>
                                        </c:if>
                                            
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->
            </c:forEach>

                    </div>
                </div>
            </div>
        </div>
       <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright © Your Website 2023</p></div>
        </footer>
    </body>
</html>
