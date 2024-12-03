<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="icon" href="img/webLogo.jpg" type="image/x-icon" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <!-- CSS Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <!-- Script Link Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </head>

    <body>
        <section class="h-100">
  <div class="container h-100 py-5">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-10">
          <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <i style="margin-right: 10px;
                       font-size: 24px;" class="bi bi-arrow-90deg-left"></i>
                    <span class="fs-4">Back to home</span>
                </a>                
            </header>
        </div>
        <div class="d-flex justify-content-between align-items-center mb-4">
          <h3 class="fw-normal mb-0">Shopping Cart</h3>
          <div>
              <p class="mb-0">Cart: <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.totalCart}</span></p>
          </div>
        </div>
        <c:forEach items="${sessionScope.listC}" var="o">
        <div class="card rounded-3 mb-4">
          <div class="card-body p-4">
            <div class="row d-flex justify-content-between align-items-center">
              <div class="col-md-2 col-lg-2 col-xl-2">
                <img
                  src="${o.photo}"
                  class="img-fluid rounded-3" >
              </div>
              <div class="col-md-3 col-lg-3 col-xl-3">
                <p class="lead fw-normal mb-2">${o.name}</p>
                <p><span class="text-muted">Phòng: </span>${o.room_name} </p>
              </div>
              
              <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                  
                  <form action="updatecart">
                  <input type="hidden" name="cid" value="${o.cartid}"/> 
                  <label for="quantity" class="form-label">Thời gian thuê</label>
                  <input type="number" name="quantity" max="12" value="${o.timeRent}" id="quantity" style="width: 60px;height: auto;text-align: center "/>
                  <button type="submit">+</button>
                  </form>
              </div>
                  
              <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                <h5 class="mb-0">${o.room_price*o.timeRent}</h5>
              </div>
              <form class="col-md-1 col-lg-1 col-xl-1 text-end" action="booking" >
                                <input type="hidden" name="cartid" value="${o.cartid}"/> 
                                <button class="btn btn-link btn-xs" type="submit"><img src="img/sell.png" style="width: auto;height: 40px"/></button>
                            
                </form>
              
              <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                  <a href="removecart?cid=${o.cartid}}" ><img src="img/delete.png" style="width: auto;height: 35px""/></a>
              </div>
            </div>
          </div>
        </div>
        </c:forEach> 
              <c:if test="${sessionScope.mess!=null}">
        <div class="card mb-4">
          <div class="card-body p-4 d-flex flex-row">
              <p style="color: red">${sessionScope.mess}</p>
          </div>
        </div>
            </c:if>
      </div>
    </div>
  </div>
</section>
    </body>

</html>
