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
import model.Home;
import model.Room;

/**
 *
 * @author 84983
 */
public class HomeDAO extends DBContext{
    public void deleteHomebyid(int Home_id){
        String sql="delete from Home\n" +
                "where Home_id=?";
        try {
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setInt(1, Home_id);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteRoombyhomeid(int Home_id){
        String sql="delete from room \n" +
                    "where house_id=?";
        try {
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setInt(1, Home_id);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public void deleteRoombyroomid(int room_id){
        String sql="delete from room \n" +
                    "where house_id=?";
        try {
            PreparedStatement pre=connection.prepareStatement(sql);
            pre.setInt(1, room_id);
            pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }       
    public void changeroomto0(int room_id){
        String sql="update room\n" +
            "set avaliable=0\n" +
            "where room_id=?";
        try {
           PreparedStatement pre= connection.prepareStatement(sql);
           pre.setInt(1, room_id);
           pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void changeroomto1(int room_id){
        String sql="update room\n" +
            "set avaliable=1\n" +
            "where room_id=?";
        try {
           PreparedStatement pre= connection.prepareStatement(sql);
           pre.setInt(1, room_id);
           pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int countRoombyhomeid(int House_id){
        int count=0;
        String sql="select count(*) as rnumber from room \n" +
                    "where house_id=?";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, House_id);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt("rnumber");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public List<Home> getAllHome(){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                    JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    ORDER BY h.Home_id ASC;";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public List<Home> getAllHomebyid(int owner_id){
        List<Home> list= new ArrayList();
        String sql="select * from home \n" +
                    "where owner_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, owner_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public Home getHomebyhomeid(int Home_id){
        Home home= null;
        String sql="select * from home \n" +
                    "where Home_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,  Home_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                 Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                
                home=new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return home;
    }
    public Room getRoombyRoomid(int room_id){
        Room room= null;
        String sql="select * from room \n" +
                    "where room_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,  room_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                 room_id=rs.getInt("room_id");
                int room_price=rs.getInt("room_price");
                String room_name=rs.getString("room_name");
                float dt=rs.getFloat("dt");
                String photo=rs.getString("photo");
                boolean avaliable=rs.getBoolean("avaliable");
                int House_id=rs.getInt("House_id");
                int numberHuman=rs.getInt("numberHuman");
                
                room=new Room(room_id, room_price, room_name, dt, photo, avaliable, House_id, numberHuman);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return room;
    }
    public List<Home> get3Home(int index){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                    JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    ORDER BY h.Home_id ASC\n" +
"                   offset ? rows\n" +
"                   fetch next 3 rows only";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, (index-1)*3);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public List<Home> desc(){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                    JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    ORDER BY h.reveiw_score DESC;";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public List<Home> asc(){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                    JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    ORDER BY h.reveiw_score ASC;";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public List<Home> getHomebyAddress(String address){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                    JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    where h.address=?\n" +
"                    ORDER BY h.Home_id ASC;";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setString(1, address);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                 address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public List<Home> getHomebyPrice(int min, int max){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                    JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    WHERE r.room_price >= ? AND r.room_price < ?\n" +
"                    ORDER BY r.room_price ASC;";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1, min);
            pre.setInt(2, max);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Home> searchByName(String txtSearch){
        List<Home> list= new ArrayList();
        String sql="SELECT h.*, r.room_price, r.dt\n" +
"                    FROM home h\n" +
"                   JOIN room r ON h.Home_id = r.House_id\n" +
"                    JOIN (\n" +
"                        SELECT House_id, MIN(room_price) AS min_price\n" +
"                        FROM room\n" +
"                        GROUP BY House_id\n" +
"                    ) min_rooms ON r.House_id = min_rooms.House_id AND r.room_price = min_rooms.min_price\n" +
"                    WHERE h.Name like ?\n" +
"                    ORDER BY r.House_id ASC;";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setString(1,"%"+ txtSearch+"%");
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int Home_id=rs.getInt("Home_id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                String description=rs.getString("description");
                int elec_price=rs.getInt("elec_price");
                int service_price=rs.getInt("service_price");
                int owner_id=rs.getInt("owner_id");
                float reveiw_score=rs.getFloat("reveiw_score");
                String image=rs.getString("image");
                int room_price=rs.getInt("room_price");
                float dt=rs.getFloat("dt");
                list.add(new Home(Home_id, name, address, description, elec_price, service_price, owner_id, reveiw_score, image, room_price, dt));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public List<Room> getAllRoomByHomeid(int House_id){
        List<Room> list= new ArrayList();
        String sql="select r.*,h.Name\n" +
                    "from home h, room r\n" +
                    "where h.Home_id=r.House_id\n" +
                    "and h.Home_id=?\n" +
                    "ORDER BY room_id ASC;";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,House_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int room_id=rs.getInt("room_id");
                int room_price=rs.getInt("room_price");
                String room_name=rs.getString("room_name");
                float dt=rs.getFloat("dt");
                String photo=rs.getString("photo");
                boolean avaliable=rs.getBoolean("avaliable");
                 House_id=rs.getInt("House_id");
                int numberHuman=rs.getInt("numberHuman");
                String Name=rs.getString("Name");
                list.add(new Room(room_id, room_price, room_name, dt, photo, avaliable, House_id, numberHuman, Name));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public Room getRoomByHomeid(String Name){
        Room room= null;
        String sql="select TOP 1 r.*,h.Name\n" +
"                    from home h, room r\n" +
"                    where h.Home_id=r.House_id\n" +
"                    and h.Name=?\n" +
"                    ORDER BY room_id ASC";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setString(1,Name);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int room_id=rs.getInt("room_id");
                int room_price=rs.getInt("room_price");
                String room_name=rs.getString("room_name");
                float dt=rs.getFloat("dt");
                String photo=rs.getString("photo");
                boolean avaliable=rs.getBoolean("avaliable");
                int House_id=rs.getInt("House_id");
                int numberHuman=rs.getInt("numberHuman");
                 Name=rs.getString("Name");
                room=new Room(room_id, room_price, room_name, dt, photo, avaliable, House_id, numberHuman, Name);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return room;
    }
    public int countPageHome(){
        String sql="select count(*) as totalHome\n" +
                    "from Home";
         try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                int total=rs.getInt("totalHome");
                int countPage = 0;
                countPage=total/3;
                if(total % 3 !=0){
                    countPage+=1;
                }
                return countPage;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    public void insertHome(Home home){
        String sql="INSERT INTO Home (Name, address, description, service_price, elec_price, owner_id, reveiw_score, image) VALUES\n" +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, home.getName());
            pre.setString(2, home.getAddress());
            pre.setString(3, home.getDescription());
            pre.setInt(4, home.getService_price());
            pre.setInt(5, home.getElec_price());
            pre.setInt(6, home.getOwner_id());
            pre.setFloat(7, home.getReview_score());
            pre.setString(8, home.getImage());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public void updateHome(String name, String address, String description, int elec_price, int service_price, String image, int Home_id){
        String sql="update home set\n" +
"Name =?,\n" +
"    address= ?,\n" +
"    description =?,\n" +
"	elec_price =?,\n" +
"	service_price =?,\n" +
"	image= ?\n" +
"	where Home_id =?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, address);
            pre.setString(3, description);
            pre.setInt(4, elec_price);
            pre.setInt(5, service_price);
             pre.setString(6, image);
            pre.setInt(7, Home_id);
           
            
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public void insertroom(Room room){
        String sql="INSERT INTO room (room_price, room_name, dt, photo, avaliable, House_id, numberHuman) VALUES\n" +
                    "(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, room.getRoom_price());
            pre.setString(2, room.getRoom_name());
            pre.setFloat(3, room.getDt());
            pre.setString(4, room.getPhoto());
            pre.setBoolean(5, room.isAvaliable());
            pre.setInt(6, room.getHouse_id());
            pre.setInt(7, room.getNumberHuman());
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public void updateroom(int room_price, String room_name, float dt, String photo, int numberHuman,boolean avaliable, int room_id){
        String sql="update room set\n" +
"	room_price =?,\n" +
"	room_name =?,\n" +
"	dt =?,\n" +
"	photo =?,\n" +
"	numberHuman =?,\n" +
"	avaliable=?\n" +
"	where room_id =?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, room_price);
            pre.setString(2, room_name);
            pre.setFloat(3, dt);
            pre.setString(4, photo);
            pre.setInt(5, numberHuman);
            pre.setBoolean(6, avaliable);
            pre.setInt(7, room_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public int demnha(int owner_id){
        int count=0;
        String sql="select count(*) as soluong from home \n" +
                    "where owner_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,owner_id);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt("soluong");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return count;
    }
    public int TotalRoom(int owner_id){
        int count=0;
        String sql="select count(r.room_id) as totalroom from room r, Home h \n" +
                    "where r.House_id=h.Home_id\n" +
                    "and h.owner_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,owner_id);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt("totalroom");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return count;
    }
    public int TotalRoomFree(int owner_id){
        int count=0;
        String sql="select count(r.room_id) as totalroomfree from room r, Home h \n" +
                        "where r.House_id=h.Home_id\n" +
                        "and r.avaliable=1\n" +
                        "and h.owner_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,owner_id);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt("totalroomfree");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return count;
    }
    public int TotalUser(int owner_id){
        int count=0;
        String sql="select count(c.hdid) as totaluser from HopDong c, room r, home h\n" +
                        "where c.phong_id=r.room_id and r.House_id=h.Home_id\n" +
                        "and h.owner_id=?";
        try{
            // thực thi câu truy vấn
            PreparedStatement pre= connection.prepareStatement(sql);
            pre.setInt(1,owner_id);
            ResultSet rs=pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt("totaluser");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        HomeDAO dao=new HomeDAO();
        int count= dao.TotalRoomFree(1);
        System.out.println(count);
        
    }
}
