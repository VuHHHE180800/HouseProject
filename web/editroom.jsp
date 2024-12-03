<%-- 
    Document   : profile
    Created on : May 24, 2024, 1:21:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Car Page</title>
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
    <body class="bg-body-tertiary">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="shop.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <i style="margin-right: 10px;
                       font-size: 24px;" class="bi bi-arrow-90deg-left"></i>
                    <span class="fs-4">Back to home</span>
                </a>                
            </header>
        </div>


        <div class="container">
            <main>
                <div class="py-5 text-center" >
                    <h2>Edit room</h2>
                </div>

                <div class="row g-5" style="justify-content: center;">


                    

                    <div class="col-md-8">
                        <form class="needs-validation" action="eroom"  enctype="multipart/form-data">
                            <div class="row g-3">
                                

                                <div class="col-sm-6">
                                    <label for="rname" class="form-label">Phòng</label>
                                    <input name="rname" type="text" class="form-control" id="rname" value="${sessionScope.room.room_name}"required>

                                </div>
                                <div class="col-sm-6">
                                    <label for="photo" class="form-label">Hình ảnh</label>
                                    <input name="photo" type="text" class="form-control" id="photo" required>
                                    <img style="margin-top: 10px;width: 312px;height: auto" src="${sessionScope.room.photo}" alt="alt"/>
                                </div>


                                <div class="col-sm-6">
                                    <label for="rprice" class="form-label">Giá phòng</label>
                                    <input name="rprice" type="text" class="form-control" id="rprice" value="${sessionScope.room.room_price}"required>
                                </div>
                                <div class="my-3 col-sm-6">
                                    <label for="available" class="form-label">Available</label>
                                    <div class="form-check">
                                        <input ${sessionScope.room.avaliable ? 'checked' : ''} value="1" id="available" name="available" type="radio" class="form-check-input">
                                        <label class="form-check-label" for="available">1</label>
                                    </div>
                                    <div class="form-check">
                                        <input ${!sessionScope.room.avaliable ? 'checked' : ''} value="0" id="available1" name="available" type="radio" class="form-check-input">
                                        <label class="form-check-label" for="available1">0</label>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <label for="nhuman" class="form-label">Số lượng người tối đa</label>
                                    <input name="nhuman" type="text" class="form-control" id="nhuman" value="${sessionScope.room.numberHuman}"required>
                                </div>

                                <div class="col-sm-6">
                                    <label for="dt" class="form-label">Diện tích</label>
                                    <input name="dt" type="text" class="form-control" id="dt" value="${sessionScope.room.dt}"required>
                                </div>

                                    <input name="room_id" type="hidden"  value="${sessionScope.room.room_id}">


                            </div>

                            <hr class="my-4">
                            <!-- Error check Username and Password -->
                            
                            

                            <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
                        </form>
                    </div>
                </div>
            </main>

            <footer class="my-5 pt-5 text-body-secondary text-center text-small">

            </footer>
        </div>

    </body>
</html>
