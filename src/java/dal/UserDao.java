/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Users;

/**
 *
 * @author 84983
 */
public class UserDao extends DBContext{
     public Users login(String username, String password){
        Users a =null;
        String sql="select * from users\n" +
                    "where username = ?\n" +
                    "and password = ?";
        try {
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                username = rs.getString("username");
                password  = rs.getString("password");
                int user_id= rs.getInt("user_id"); 
                String email=rs.getString("email"); 
                String phone_number=rs.getString("phone_number"); 
                boolean gender=rs.getBoolean("gender");
                boolean role=rs.getBoolean("role"); 
                a= new Users(user_id, username, password, email, phone_number, gender, role);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         return a;
    }
    public Users checkAccount(String username){
        Users a =null;
        String sql="select * from users\n" +
            "where username=?";
            
        try {
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setString(1, username);
            
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                 username = rs.getString("username");
                String password  = rs.getString("password");
                int user_id= rs.getInt("user_id"); 
                String email=rs.getString("email"); 
                String phone_number=rs.getString("phone_number"); 
                boolean gender=rs.getBoolean("gender");
                boolean role=rs.getBoolean("role"); 
                a= new Users(user_id, username, password, email, phone_number, gender, role);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         return a;
    }
    public void signup(String username,String password,String email,String phone_number, boolean gender ){
        String sql="INSERT INTO users (username, password, email, phone_number, gender, role) VALUES\n" +
                    "(?, ?, ?, ?, ?, 0)";
        try {
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            pre.setString(3, email);
            pre.setString(4, phone_number);
            pre.setBoolean(5, gender);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Users getUserById(int user_id){
        Users u= null;
        String sql="select * from users\n" +
        "where user_id=?";
        try {
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, user_id);
            
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password  = rs.getString("password");
                user_id= rs.getInt("user_id"); 
                String email=rs.getString("email"); 
                String phone_number=rs.getString("phone_number"); 
                boolean gender=rs.getBoolean("gender");
                boolean role=rs.getBoolean("role"); 
                u= new Users(user_id, username, password, email, phone_number, gender, role);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         return u;
    }
    public void updateUser(String username, String email,String phone_number,boolean gender, int user_id){
        
        String sql="update  users \n" +
                    "set username=?,\n" +
                    "email=?,\n" +
                    "phone_number=?,\n" +
                    "gender=?\n" +
                    "where user_id=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, email);
            pre.setString(3, phone_number);
            pre.setBoolean(4, gender);
            pre.setInt(5, user_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Can not update!");
        }
    }
    public void changetosell(int user_id){
        String sql="update users\n" +
                    "set role=1\n" +
                    "where user_id=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, user_id);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void changetobuy(int user_id){
        String sql="update users\n" +
                    "set role=0\n" +
                    "where user_id=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, user_id);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void changepass(int user_id, String npass){
        String sql = "update users\n" +
                    "set password=?\n" +
                    "where user_id=?";
        
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1, npass);
            pre.setInt(2, user_id);
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public static void main(String[] args) {
        UserDao dao =new UserDao();
        dao.changepass(1, "1234");
        Users st= dao.getUserById(1);
        System.out.println(st);
    }
}
