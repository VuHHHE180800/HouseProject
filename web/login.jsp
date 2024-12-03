<%-- 
    Document   : login
    Created on : 4 thg 6, 2024, 14:18:20
    Author     : 84983
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
         body {
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
                background-color: #f1f1f1;
            }
            .container {
                width: 300px;
                padding: 20px;
                background-color: white;
                border: 1px solid black;
                border-radius: 4px;
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            }
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }
            button:hover {
                opacity: 0.8;
            }
    </style>
</head>
<body>
    <div class="container">
            <form name="login" action="login" method="post"> 
            <h2> Login Form</h2>
            <input type="text" name="username" placeholder="Username" value="" required /> 
            <input type="password" name="password" placeholder="Password" value="" required/> 
            <input type="checkbox" id="remember" name="remember">
            <label for="remember">Remember Me</label><br>
            <button type="submit"> Login </button>
            <div style="color: red"> ${sessionScope.loi} </div><br>
        </form>
        <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
    </div>
</body>
</html>