/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84983
 */
public class Contract {
        int hdid;
        int cusid;
        int phong_id;
        String bookingDate;
	int timeRent;
	int totalPrice;
        String enterDate;
        /*Thêm*/
        String room_name;
        float dt;
        String photo;
        int numberHuman;
        String name;
        String address;
        int elec_price;
        int service_price;
        String description;
        String username;
        String phone_number;
        String email;
    public Contract() {
    }

    public Contract(int hdid, int cusid, int phong_id, String bookingDate, int timeRent, int totalPrice, String enterDate) {
        this.hdid = hdid;
        this.cusid = cusid;
        this.phong_id = phong_id;
        this.bookingDate = bookingDate;
        this.timeRent = timeRent;
        this.totalPrice = totalPrice;
        this.enterDate = enterDate;
    }

    public Contract(int hdid, int cusid, int phong_id, String bookingDate, int timeRent, int totalPrice, String enterDate, String room_name, String name, String username) {
        this.hdid = hdid;
        this.cusid = cusid;
        this.phong_id = phong_id;
        this.bookingDate = bookingDate;
        this.timeRent = timeRent;
        this.totalPrice = totalPrice;
        this.enterDate = enterDate;
        this.room_name = room_name;
        this.name = name;
        this.username = username;
    }
    
    public Contract(int hdid, int cusid, int phong_id, String bookingDate, int timeRent, int totalPrice, String enterDate, String room_name, float dt, String photo, int numberHuman, String name, String address, int elec_price, int service_price, String description, String username, String phone_number, String email) {
        this.hdid = hdid;
        this.cusid = cusid;
        this.phong_id = phong_id;
        this.bookingDate = bookingDate;
        this.timeRent = timeRent;
        this.totalPrice = totalPrice;
        this.enterDate = enterDate;
        this.room_name = room_name;
        this.dt = dt;
        this.photo = photo;
        this.numberHuman = numberHuman;
        this.name = name;
        this.address = address;
        this.elec_price = elec_price;
        this.service_price = service_price;
        this.description = description;
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getHdid() {
        return hdid;
    }

    public void setHdid(int hdid) {
        this.hdid = hdid;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public int getPhong_id() {
        return phong_id;
    }

    public void setPhong_id(int phong_id) {
        this.phong_id = phong_id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(int timeRent) {
        this.timeRent = timeRent;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNumberHuman() {
        return numberHuman;
    }

    public void setNumberHuman(int numberHuman) {
        this.numberHuman = numberHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getElec_price() {
        return elec_price;
    }

    public void setElec_price(int elec_price) {
        this.elec_price = elec_price;
    }

    public int getService_price() {
        return service_price;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contract{" + "hdid=" + hdid + ", cusid=" + cusid + ", phong_id=" + phong_id + ", bookingDate=" + bookingDate + ", timeRent=" + timeRent + ", totalPrice=" + totalPrice + ", enterDate=" + enterDate + ", room_name=" + room_name + ", dt=" + dt + ", photo=" + photo + ", numberHuman=" + numberHuman + ", name=" + name + ", address=" + address + ", elec_price=" + elec_price + ", service_price=" + service_price + ", description=" + description + ", username=" + username + ", phone_number=" + phone_number + ", email=" + email + '}';
    }

    

    
    
    
        
}
