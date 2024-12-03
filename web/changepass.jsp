<%-- 
    Document   : profile
    Created on : May 24, 2024, 1:21:04 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
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
            
/* Style for the form label */
.form-label {
    font-weight: bold;
    margin-bottom: 10px;
}

/* Style for the form-check class */
.form-check {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
}

/* Style for the form-check input */
.form-check-input {
    margin-right: 10px;
}

/* Style for the form-check label */
.form-check-label {
    margin-bottom: 0;
}


        </style>

    </head>
    <body class="bg-body-tertiary">

        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <i style="margin-right: 10px;
                       font-size: 24px;" class="bi bi-arrow-90deg-left"></i>
                    <span class="fs-4">Back to home</span>
                </a>                
            </header>
        </div>


        <div class="container">
            <main>
                <div class="py-5 text-center" >
                    <img class="d-block mx-auto mb-4" src="img/changepass.png" alt="" width="72">
                    <h2>Change your password</h2>
                </div>

                <div class="row g-5" style="justify-content: center;">
                    <div class="col-md-8">
                        <form class="needs-validation" action="changepass" >
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="opass" class="form-label">Old password</label>
                                    <input  type="text" class="form-control" id="opass" name="opass" placeholder="Old password">
                                </div>

                                <div class="col-12">
                                    <label for="npass" class="form-label">New password</label>
                                    <input type="text" class="form-control" name="npass" id="npass" placeholder="New password">
                                </div>
                                
                                <div class="col-12">
                                    <label for="cpass" class="form-label">Confirm password</label>
                                    <input type="text" class="form-control" name="cpass" id="cpass" placeholder="Confirm password" required>
                                    
                                </div>
                                
                                <input value="${sessionScope.u.user_id}" type="hidden"name="uid" >
                                
                            </div>

                            <hr class="my-4">
                             <!-- Error check Username and Password -->
                             <c:if test="${sessionScope.loi != null}">
                             <div style="text-align: left;
                                        color: red;
                                        margin-left: 5px;">
                                 <p>${sessionScope.loi}</p>
                             </div>
                            </c:if>
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
