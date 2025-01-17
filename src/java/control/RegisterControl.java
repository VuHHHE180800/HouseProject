/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dal.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author 84983
 */
public class RegisterControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        String username= request.getParameter("username");
        String email=request.getParameter("email");
        String phone_number=request.getParameter("phone_number");
        String gender=request.getParameter("gender");
        String password=request.getParameter("password");
        String re_password=request.getParameter("re_password");
        String phone_regex="^[0-9]{10}$";
        String mail_regex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        boolean gen = false;
        UserDao dao = new UserDao();
        Users u=dao.checkAccount(username);
        switch (gender) {
            case "male":
                gen=false;
                break;
            case "female":
                gen=true;
                break;
        }
        if(u!=null){
            session.setAttribute("result", "Username is already exist!");
            response.sendRedirect("register.jsp");
        }else{
            if(!password.equals(re_password)){
            session.setAttribute("result", "Password and confirm password are  not the same!");
            response.sendRedirect("register.jsp");
            }else if(!phone_number.matches(phone_regex)){
            session.setAttribute("result", "Phone number must have at least 10 numbers!");
            response.sendRedirect("register.jsp");   
            }else if(!email.matches(mail_regex)){
            session.setAttribute("result", "Email was wrong format!");
            response.sendRedirect("register.jsp");   
        }else{
                dao.signup(username, password, email, phone_number, gen);
                response.sendRedirect("login.jsp");
            }
        
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
