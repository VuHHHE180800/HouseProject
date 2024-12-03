/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dal.CartDao;
import dal.ContractDao;
import dal.HomeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import model.Cart;
import model.Contract;
import model.Room;
import model.Users;

/**
 *
 * @author 84983
 */
public class booking extends HttpServlet {
   
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
        HttpSession session= request.getSession();
        Users u =(Users) session.getAttribute("acc");
        CartDao dao=new CartDao();
        HomeDAO hdao=new HomeDAO();
        ContractDao cdao=new ContractDao();
        int cartid=Integer.parseInt(request.getParameter("cartid"));
        LocalDate Date = LocalDate.now();
        String bookingDate=Date.toString();
        LocalDate nextWeek = Date.plusWeeks(1);
        String enterDate=nextWeek.toString();
        Cart cart=dao.detailCart(cartid, u.getUser_id());
        int count=cdao.countContractbyCusid(u.getUser_id());
        Room room= hdao.getRoombyRoomid(cart.getPhong_id());
        if(count==0&&room.isAvaliable()){
        Contract contract= new Contract(0, u.getUser_id(), cart.getPhong_id(), bookingDate,cart.getTimeRent(),cart.getRoom_price(),enterDate);
        cdao.insertcontract(contract);
        hdao.changeroomto0(cart.getPhong_id());
        dao.deleteCartByID(cartid, u.getUser_id());
        }else if(!room.isAvaliable()){
            session.setAttribute("mess", "Phòng này hiện không còn trống");
        }
        else{
            session.setAttribute("mess", "Bạn không được đặt quá nhiều phòng");
        }
        response.sendRedirect("cart");
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
