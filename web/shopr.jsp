<%-- 
    Document   : shop
    Created on : 4 thg 7, 2024, 05:04:22
    Author     : 84983
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <!-- Font awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

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


.intro {
  height: 100%;
}

table td,
table th {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

thead th {
  color: #fff;
}

.card {
  border-radius: .5rem;
}

.table-scroll {
  border-radius: .5rem;
}

.table-scroll table thead th {
  font-size: 1.25rem;
}
thead {
  top: 0;
  position: sticky;
}
.criteria{
                border: 1px solid #bb9797;
                border-radius: 6px;
                padding: 10px;
                box-shadow: 1px 1px 1px 1px #eeafaf;
            }

            .icon{
                justify-content: left;
                display: flex;
                align-items: center;
                font-size: 30px;

            }

            .content{
                text-align: right;
                padding: 0;
            }

            .content p{
                margin: 0;
            }

            .list2{
                margin-bottom: 22px;
            }

            .products{
                border: 1px solid gray;
                border-radius: 12px;
                box-shadow: 1px 1px 4px gray;
            }

            .edit{
                display: inline-block;
                background-color: yellow;
                padding: 6px 8px;
                border-radius: 4px;
                cursor: pointer;
                box-shadow: 1px 1px 6px gray;
            }

            .remove{
                display: inline-block;
                background-color: red;
                padding: 6px 8px;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 12px;
                box-shadow: 1px 1px 6px gray;
            }
            .view{
                display: inline-block;
                background-color: green;
                padding: 6px 8px;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 12px;
                box-shadow: 1px 1px 6px gray;
            }
            .edit:hover,.remove:hover,.add:hover,.view:hover{
                opacity: 0.8;
            }
            
            .add{
                background-color: #c5c511;
                padding: 8px 10px;
                border-radius: 4px;
                color: white;
                cursor: pointer;
                box-shadow: 1px 1px 6px gray;
            }

            .product-img{
                width: 40%;
            }

            .product-img img{
                width: 60%;
            }
            
            .dropdown-toggle::after{
                color: white;
            }

            label{
                color: #8e7c7c;
            }

            select{
                padding: 16px;

            }

            .input{
                margin: 10px 0;
            }

            .search{
                width: 100%;
                margin-top: 10px;
                padding: 16px 0;
            }
    </style>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="home">HolaHome</a>
               <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    
                    <div class="dropdown text-end" style="margin-left: 1030px">
                        <div class="dropbtn"><img src="img/user.png" alt="User" width="32" height="32" class="rounded-circle"></div>
                        <div class="dropdown-content">
                            
                            <a href="#">Hello ${sessionScope.acc.username}</a>
                            <a href="profile?uid=${sessionScope.acc.user_id}">Your profile</a>
                            <a href="changepass.jsp">Change password</a>
                            <hr>
                            <a href="logout">Logout</a>
                        </div>
                    </div>

                    
                </div>
            </div>
        </nav>
            <div class="container" style="margin-top: 10px">
                <div class="row">  
                    <div class="col-sm-3">
                    <div class="card-header text-uppercase"> <i class="fa fa-list"></i> Filter </div>
                    <div class="card bg-light mb-3" style="margin-top: 10px">
                        <div class="card-header bg-primary text-white text-uppercase"> Quản lý</div>
                        
                        <ul class="list-group category_block">
                        
                            <li class="list-group-item text-white"><a  href="shophome?uid=${sessionScope.acc.user_id}" >Quản lý trọ</a></li>
                        
                            <li class="list-group-item text-white"><a  href="shopt?uid=${sessionScope.acc.user_id}" >Thống kê</a></li>
                            <li class="list-group-item text-white"><a  href="shopcontract?uid=${sessionScope.acc.user_id}" >Hợp đồng</a></li>
                        
                        </ul>
                    </div>
                    </div>
                    
                    <div class="col-sm-9">
                   
                        <div style="margin-top: 20px"">
                            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                                <div class="container-fluid">
                                    <h5 class="navbar-brand" href="#">Quản lý trọ</h5>

                                    


                                    <div class="">
                                        <div class="d-flex add" role="search">
                                            <a href="addroom.jsp"><i style="color: white;" class="fa-solid fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </nav>
                        <div class="card mb-4">
                            <c:forEach items="${sessionScope.listR}" var="a" >
          <div class="card-body p-4">
              
            <div class="row align-items-center">
              <div class="col-md-3">
                  <img src="${a.photo}"class="img-fluid" >
              </div>
              <div class="col-md-3 d-flex justify-content-center">
                <div>
                  <p class="small text-muted mb-4 pb-2">Phòng</p>
                  <p class="lead fw-normal mb-0">${a.room_name}</p>
                </div>
              </div>

              <div class="col-md-3 d-flex justify-content-center">
                <div>
                  <p class="small text-muted mb-4 pb-2">Giá thuê</p>
                  <p class="lead fw-normal mb-0">${a.room_price}</p>
                </div>
              </div>
              
              <div class="col-md-3 d-flex justify-content-center">
                <div>
                    <p class="small text-muted mb-4 pb-2">Action</p>
                  <div class="edit">
                        <a href="editroom?roomID=${a.room_id}"><i style="color: black;" class="fa-solid fa-pen"></i></a>
                                            
                        </div>
                    
                        <div class="remove">
                            <a onclick="return confirm('Do you want to delete this room')" href="removeroom?roomID=${a.room_id}"><i style="color: white;" class="fa-solid fa-trash-can"></i></a>     
                        </div>
                    
                </div>
              </div>
            </div>
                
          </div>
                        <hr>
                </c:forEach>          
        </div>
                        </div>
                
                     <!-- END PAGE -->
                    
                    
                    </div>
                </div>
            </div>
    </body>
</html>
