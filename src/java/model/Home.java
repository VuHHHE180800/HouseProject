/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84983
 */
public class Home {
    int Home_id;
    String name, address, description;
    int elec_price, service_price;
    int owner_id;
    float reveiw_score;
    String image;
    
    
    int room_price;
    float dt;
    public Home() {
    }

    public Home(int Home_id, String name, String address, String description, int elec_price, int service_price, int owner_id, float reveiw_score, String image) {
        this.Home_id = Home_id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.elec_price = elec_price;
        this.service_price = service_price;
        this.owner_id = owner_id;
        this.reveiw_score = reveiw_score;
        this.image = image;
    }

    public Home(int Home_id, String name, String address, String description, int elec_price, int service_price, int owner_id, float reveiw_score, String image, int room_price, float dt) {
        this.Home_id = Home_id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.elec_price = elec_price;
        this.service_price = service_price;
        this.owner_id = owner_id;
        this.reveiw_score = reveiw_score;
        this.image = image;
        this.room_price = room_price;
        this.dt = dt;
    }

    

    public int getHome_id() {
        return Home_id;
    }

    public void setHome_id(int Home_id) {
        this.Home_id = Home_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    

    public float getReview_score() {
        return reveiw_score;
    }

    public void setReview_score(float reveiw_score) {
        this.reveiw_score = reveiw_score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getReveiw_score() {
        return reveiw_score;
    }

    public void setReveiw_score(float reveiw_score) {
        this.reveiw_score = reveiw_score;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Home{" + "Home_id=" + Home_id + ", name=" + name + ", address=" + address + ", description=" + description + ", elec_price=" + elec_price + ", service_price=" + service_price + ", owner_id=" + owner_id + ", reveiw_score=" + reveiw_score + ", image=" + image + ", room_price=" + room_price + ", dt=" + dt + '}';
    }

    

    

    

    
    
}
