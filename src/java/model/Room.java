/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84983
 */
public class Room {
    int room_id;
    int room_price;
    String room_name;
    float dt;
    String photo;
    boolean avaliable;
    int House_id;
    int numberHuman;
    
    String Name;
    public Room() {
    }

    public Room(int room_id, int room_price, String room_name, float dt, String photo, boolean avaliable, int House_id, int numberHuman) {
        this.room_id = room_id;
        this.room_price = room_price;
        this.room_name = room_name;
        this.dt = dt;
        this.photo = photo;
        this.avaliable = avaliable;
        this.House_id = House_id;
        this.numberHuman = numberHuman;
    }

    public Room(int room_id, int room_price, String room_name, float dt, String photo, boolean avaliable, int House_id, int numberHuman, String Name) {
        this.room_id = room_id;
        this.room_price = room_price;
        this.room_name = room_name;
        this.dt = dt;
        this.photo = photo;
        this.avaliable = avaliable;
        this.House_id = House_id;
        this.numberHuman = numberHuman;
        this.Name = Name;
    }
    
    public int getNumberHuman() {
        return numberHuman;
    }

    public void setNumberHuman(int numberHuman) {
        this.numberHuman = numberHuman;
    }

    

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
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

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public int getHouse_id() {
        return House_id;
    }

    public void setHouse_id(int House_id) {
        this.House_id = House_id;
    }

    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Room{" + "room_id=" + room_id + ", room_price=" + room_price + ", room_name=" + room_name + ", dt=" + dt + ", photo=" + photo + ", avaliable=" + avaliable + ", House_id=" + House_id + ", numberHuman=" + numberHuman + ", Name=" + Name + '}';
    }

   
    
    
    
            
}
