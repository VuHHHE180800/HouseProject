/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contract;

/**
 *
 * @author 84983
 */
public class ContractDao extends DBContext{
    public void insertcontract(Contract contract){
        String sql="insert into HopDong(cusid, phong_id ,bookingDate ,timeRent ,totalPrice, enterDate ) values\n" +
                    "(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, contract.getCusid());
            pre.setInt(2, contract.getPhong_id());
            pre.setString(3,contract.getBookingDate());
            pre.setInt(4, contract.getTimeRent());
            pre.setInt(5, contract.getTotalPrice());
            pre.setString(6, contract.getEnterDate());
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int countContractbyCusid(int cusid){
        int count = 0;
        String sql="select count(*) as tongHoaDon\n" +
                    "from HopDong \n" +
                    "where cusid = ?";
         try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cusid);
            ResultSet rs = pre.executeQuery();
            
            
            while (rs.next()) {
                count = rs.getInt("tongHoaDon");
            }
        } catch (SQLException ex) {
        }

                                    
        return count;
    }
    public Contract detailcontract(int cusid){
        Contract contract = null;
        String sql="select d.*,r.room_name,r.dt,r.photo,r.numberHuman,h.name,h.address,\n" +
                    "h.elec_price,h.service_price,h.description, u.username,u.phone_number,u.email\n" +
                    "from HopDong d, Room r, Home h, users u\n" +
                    "where d.phong_id= r.room_id and r.House_id=h.home_id\n" +
                    "and h.owner_id=u.user_id and d.cusid=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, cusid);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int hdid=rs.getInt("hdid");
                cusid=rs.getInt("cusid");
                int phong_id=rs.getInt("phong_id");
                String bookingDate=rs.getString("bookingDate");
                int timeRent=rs.getInt("timeRent");
                int totalPrice=rs.getInt("totalPrice");
                String enterDate=rs.getString("enterDate");
                /*Thêm*/
                String room_name=rs.getString("room_name");
                float dt=rs.getFloat("dt");
                String photo=rs.getString("photo");
                int numberHuman=rs.getInt("numberHuman");
                String name=rs.getString("name");
                String address=rs.getString("address");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                String description=rs.getString("description");
                String username=rs.getString("username");
                String phone_number=rs.getString("phone_number");
                String email=rs.getString("email");
                contract=new Contract(hdid, cusid, phong_id, bookingDate, timeRent, totalPrice, enterDate, room_name, dt, photo, numberHuman, name, address, elec_price, service_price, description, username, phone_number, email);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return contract;
    }
    public void updatedatebyhdid(int hdid, int cusid, String enterDate){
        String sql="update HopDong\n" +
                    "set enterDate=?\n" +
                    "where cusid=? and hdid=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1,enterDate);
            pre.setInt(2, cusid);
            pre.setInt(3, hdid);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deletecontract(int hdid){
        String sql="delete from HopDong \n" +
                    "where hdid = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, hdid);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
    public List<Contract> shopcontract(int owner_id){
        List<Contract> list=new ArrayList();
        String sql="select d.*, u.username, r.room_name,h.Name\n" +
                    "from HopDong d, users u, room r, home h\n" +
                    "where d.cusid=u.user_id and d.phong_id=r.room_id\n" +
                    "and r.House_id=h.Home_id\n" +
                    "and h.owner_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, owner_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int hdid=rs.getInt("hdid");
                int cusid=rs.getInt("cusid");
                int phong_id=rs.getInt("phong_id");
                String bookingDate=rs.getString("bookingDate");
                int timeRent=rs.getInt("timeRent");
                int totalPrice=rs.getInt("totalPrice");
                String enterDate=rs.getString("enterDate");
                
                String room_name=rs.getString("room_name");
                String name=rs.getString("name");
                String username=rs.getString("username");
                list.add(new Contract(hdid, cusid, phong_id, bookingDate, timeRent, totalPrice, enterDate, room_name, name, username));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public int getTotalSale(int owner_id){
        int TotalSales = 0;
        String sql = "SELECT SUM(d.totalPrice) AS totalSales\n" +
                "FROM HopDong d\n" +
                "JOIN room r ON d.phong_id = r.room_id\n" +
                "JOIN home h ON r.House_id = h.Home_id\n" +
                "JOIN users u ON h.owner_id = u.user_id\n" +
                "WHERE h.owner_id = ?;";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, owner_id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                TotalSales = rs.getInt("totalSales");
            }
            
        } catch (SQLException ex) {
        }
        return TotalSales;
    } 
    
    public static void main(String[] args) {
        ContractDao dao=new ContractDao();
        dao.updatedatebyhdid(1, 11, "2024-07-12");
        int count=dao.getTotalSale(1);
        List<Contract> contract= dao.shopcontract(1);
        System.out.println(count);
    }
}
