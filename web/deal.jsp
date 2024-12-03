<%-- 
    Document   : deal
    Created on : 5 thg 7, 2024, 16:05:59
    Author     : 84983
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deal Page</title>
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
        <style>
            .time-save-form {
    display: flex;
    align-items: center;
    margin-top: 10px;
}

.time-save-form input[type="date"] {
    margin-right: 10px;
    padding: 5px;
    font-size: 14px;
}

.save-button {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 15px;
    border-radius: 5px;
    cursor: pointer;
}

.save-button:hover {
    background-color: #0056b3;
}
        </style>
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
                    <h3 class="fw-normal mb-0">Your deal</h3>
                  </div>
                    <c:if test="${sessionScope.count!=0}">
                    <div class="container" style="margin-top: 18px ">
                        <div class="row">
                         <c:set var="o" value="${sessionScope.contract}"/> 
                         <div class="col-sm-6 border rounded" >
                             
                             <img src="${o.photo}" class="img-fluid rounded-3" style="margin: 10px;margin-left: 47px; width: 80%; height: auto"> 
                             
                         </div>
                         <div class="col-sm-6 border rounded">
                             <div style="margin: 20px; margin-left: 50px">
                             <h3 class="mb-0" >${o.name}</h3>
                             <div class="description" style="margin-top: 10px"> <h6>Phòng: ${o.room_name}</h6> </div>
                             <div class="description" style="margin-top: 5px"> Mô tả: ${o.description}</div>
                             <div class="description" style="margin-top: 5px"> Địa chỉ: ${o.address} </div>
                             <div class="description" style="margin-top: 5px"> Thời gian thuê: ${o.timeRent} tháng </div>
                             <div class="description" style="margin-top: 5px"> Tổng tiền đặt cọc: ${o.totalPrice}vnđ </div>
                             <div class="description" style="margin-top: 5px"> Thời gian đặt phòng: ${o.bookingDate} </div>
                            <form action="updatetime" class="time-save-form" >
                                <input type="hidden" name="hdid" value="${o.hdid}"/> 
                                <label for="enterDate"style="margin-right: 5px" >Thời gian nhận phòng: </label>
                                 <input name="enterDate" type="date" class="form-control style-input" id="enterDate" value="${o.enterDate}" style="width: 150px; height: 44px">
                                
                                <button type="submit" class="save-button">Save</button>
                            </form>
                             </div>
                                 <div class="row" style="margin-bottom: 10px">
                                     
                                        <div class="col-md-9">
                                            <div class="card-body p-4 d-flex flex-row">
                                      <c:if test="${sessionScope.mes!=null}">          
              <p style="color: red">${sessionScope.mes}</p>
               </c:if>
          </div>
                                        </div>
         
                                        <div class="col-md-3">
                                            <a href="cancle?hdid=${o.hdid}&rid=${o.phong_id}" onclick="return confirm('Do you want to cancel this deal?')" class="btn btn-danger">Cancel</a>
                                        </div>
                                    </div>  
                         </div>
                        </div>
                         
                         
                    </div>
                               </c:if>         
                </div>
              </div>
            </div>
          </section>
    </body>
</html>
