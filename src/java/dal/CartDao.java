/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;

/**
 *
 * @author 84983
 */
public class CartDao extends DBContext{
    public void insertCart(Cart cart){
        String sql="INSERT INTO cart (cusid, bookingDate, phong_id,  timeRent)\n" +
                    "values(?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cart.getCusid());
            pre.setString(2, cart.getBookingDate());
            pre.setInt(3, cart.getPhong_id());
            pre.setInt(4, cart.getTimeRent());
            
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }    
    }
    public int countTotalCart(int cusid){
        int count = 0 ;
        
        
        String sql ="select count(*) as totalCart\n" +
                    "from cart\n" +
                    "where cusid=?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cusid);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                count = rs.getInt("totalCart");
            }
        } catch (SQLException ex) {
        }

                                    
        return count;
    }
    public List<Cart> getAllCart(int cusid){
        List<Cart> list=new ArrayList();
        String sql="select c.*, r.photo, r.room_name,r.room_price, h.Name\n" +
                    "from Cart c,room r, home h \n" +
                    "where c.phong_id=r.room_id\n" +
                    "and r.House_id=h.Home_id and\n" +
                    "cusid=?;";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, cusid);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int cartid=rs.getInt("cartid");
                cusid=rs.getInt("cusid")  ;
                String bookingDate=rs.getString("bookingDate") ;
                int phong_id=rs.getInt("phong_id")  ;
                int timeRent=rs.getInt("timeRent");

                String photo=rs.getString("photo");
                String room_name=rs.getString("room_name");
                int room_price=rs.getInt("room_price");
                String name=rs.getString("name");
                list.add(new Cart(cartid, cusid, bookingDate, phong_id, timeRent, photo, room_name, room_price, name));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public void deleteCartByID(int cartid, int cusid ){
        String sql ="delete from Cart\n" +
                    "where Cartid=? and cusid=?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cartid);
            pre.setInt(2, cusid);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    public void updateCartByID(int cartid,int cusid,int timeRent){
        String sql ="update cart\n" +
                    "set timeRent=?\n" +
                    "where cartid=? and cusid=?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, timeRent);
            pre.setInt(2, cartid);
            pre.setInt(3, cusid);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public Cart detailCart(int cartid, int cusid){
        Cart cart = null;
        String sql="select c.*,r.photo, r.room_name,r.room_price*c.timeRent as totalrent, h.Name, u.username, u.phone_number,u.email\n" +
                    "from Cart c,room r, home h, users u\n" +
                    "where c.phong_id=r.room_id\n" +
                    "and r.House_id=h.Home_id\n" +
                    "and h.owner_id=u.user_id\n" +
                    "and cusid =? and cartid=?";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, cusid);
            pre.setInt(2, cartid);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                 cartid=rs.getInt("cartid") ;
                cusid=rs.getInt("cusid") ;
                String bookingDate=rs.getString("bookingDate");
                int phong_id=rs.getInt("phong_id");
                int timeRent=rs.getInt("timeRent");
                String photo=rs.getString("photo");
                String room_name=rs.getString("room_name");
                int room_price=rs.getInt("totalrent");
                String name=rs.getString("name");
                String username=rs.getString("username");
                String phone_number=rs.getString("phone_number");
                String email=rs.getString("email");
                cart=new Cart(cartid, cusid, bookingDate, phong_id, timeRent, photo, room_name, room_price, name, username, phone_number, email);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return cart;
    }
    public static void main(String[] args) {
        CartDao dao= new CartDao();
        /*LocalDate Date = LocalDate.now();
        String bookingDate=Date.toString();
        int countcart=dao.countTotalCart(11);
        System.out.println("đang có "+countcart);
        
        List<Cart> list= dao.getAllCart(11);
        for (Cart cart : list) {
            System.out.println(cart);
        }*/
        
        Cart cart=dao.detailCart(1, 11);
        System.out.println(cart);
    }
}
