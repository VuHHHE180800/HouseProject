/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author 84983
 */
public class Cart {
      int cartid  ;
	int cusid  ;
	String bookingDate ;
	int phong_id  ;
        int timeRent;
        
        String photo;
        String room_name;
        int room_price;
        String name;
        
        String username, phone_number,email;
    public Cart(int cartid, int cusid, String bookingDate, int phong_id, int timeRent) {
        this.cartid = cartid;
        this.cusid = cusid;
        this.bookingDate = bookingDate;
        this.phong_id = phong_id;
        this.timeRent = timeRent;
    }

    public Cart(int cartid, int cusid, String bookingDate, int phong_id, int timeRent, String photo, String room_name, int room_price, String name) {
        this.cartid = cartid;
        this.cusid = cusid;
        this.bookingDate = bookingDate;
        this.phong_id = phong_id;
        this.timeRent = timeRent;
        this.photo = photo;
        this.room_name = room_name;
        this.room_price = room_price;
        this.name = name;
    }

    public Cart(int cartid, int cusid, String bookingDate, int phong_id, int timeRent, String photo, String room_name, int room_price, String name, String username, String phone_number, String email) {
        this.cartid = cartid;
        this.cusid = cusid;
        this.bookingDate = bookingDate;
        this.phong_id = phong_id;
        this.timeRent = timeRent;
        this.photo = photo;
        this.room_name = room_name;
        this.room_price = room_price;
        this.name = name;
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
    }

    

    public Cart() {
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    

    public int getPhong_id() {
        return phong_id;
    }

    public void setPhong_id(int phong_id) {
        this.phong_id = phong_id;
    }

    public int getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(int timeRent) {
        this.timeRent = timeRent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Cart{" + "cartid=" + cartid + ", cusid=" + cusid + ", bookingDate=" + bookingDate + ", phong_id=" + phong_id + ", timeRent=" + timeRent + ", photo=" + photo + ", room_name=" + room_name + ", room_price=" + room_price + ", name=" + name + ", username=" + username + ", phone_number=" + phone_number + ", email=" + email + '}';
    }

    

    

    
}
