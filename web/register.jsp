<%-- 
    Document   : login
    Created on : 4 thg 6, 2024, 14:18:20
    Author     : 84983
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SIGN UP</title>
        
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
                width: 800px;
                padding: 20px;
                background-color: white;
                border: 1px solid black;
                border-radius: 4px;
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            }
            input[type=text] {
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
            .radio-group {
                width: 100%;
                padding: 15px;
                border-radius: 5px;
                margin-bottom: 10px;
                display: inline-block;
                align-items: center;
        }
        
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        </style>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <div class="container">
            <form name="register" action="register" method="post"> 
                <h2>Create an account</h2>
                <table>
                <td>
                <input type="text" name="username" placeholder="Username" value="" required /> 
                <input type="text" name="email" placeholder="Email" value="" required /> 
                <input type="text" name="phone_number" placeholder="Phone number" value="" required/> 
                </td>
                <td>
                <div class="radio-group">
                <label for="gender">Gender:</label>
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label>
                </div>
                <input type="text" name="password" placeholder="Password" value="" required/> 
                <input type="text" name="re_password" placeholder="Confirm password" value="" required/> 
                </td> 
                </table>
                <button type="submit"> Submit </button> 
                <div style="color: red"> ${sessionScope.result} </div><br>
               
            </form> 
            <p>Have already an account? <a href="login.jsp">Login here</a>.</p>
        </div>
    </body>
</html>
