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
public class changepass extends HttpServlet {
   
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
        HttpSession session=request.getSession();
        UserDao dao= new UserDao();
        Users u =(Users) session.getAttribute("acc");
        String opass= request.getParameter("opass");
        String npass=request.getParameter("npass");
        String cpass=request.getParameter("cpass");
        
        if (opass.equals(u.getPassword())==false) {
            session.setAttribute("loi", "Old password is incorrect!");
            request.getRequestDispatcher("changepass.jsp").forward(request, response);
        } else {
            if (npass.equals(cpass)==false) {
                session.setAttribute("loi", "New password and Confirm password are not the same!");
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            }else if(opass.equals(npass)){
                session.setAttribute("loi", "Old password and new password must be different!");
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
            }  else {
                dao.changepass(u.getUser_id(), npass);
                session.setAttribute("loi","Change successful!");
                request.getRequestDispatcher("changepass.jsp").forward(request, response);
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
