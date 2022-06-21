package com.iie.hotelms.admin;

import javafx.beans.property.*;

public class MRoomService {

    private final IntegerProperty id_room_service;
    private final StringProperty name;
    private final FloatProperty price;

    public MRoomService(){
        id_room_service = new SimpleIntegerProperty(this, "id_room_service");
        name = new SimpleStringProperty(this, "name");
        price = new SimpleFloatProperty(this, "price");
    }


    public IntegerProperty idRoomServiceProperty() {return id_room_service;}
    public Integer getidRoomService() {return id_room_service.get();}
    public void setidRoomService(Integer newId) {id_room_service.set(newId);}

    public StringProperty nameProperty() {return name;}
    public String getName() {return name.get();}
    public void setName(String newName) {
        name.set(newName);}

    public FloatProperty priceProperty() {return price;}
    public Float getprice() {return price.get();}
    public void setprice(Float newprice) {price.set(newprice);}


}
