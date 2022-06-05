package com.iie.hotelms.admin;

import javafx.beans.property.*;

public class Room {

    private final IntegerProperty idRoom;
    private final StringProperty roomNumber;
    private final IntegerProperty idType;
    private final StringProperty type;
    private final StringProperty status;
    private final FloatProperty price;
    private final IntegerProperty capacity;

    public Room(){
        idRoom = new SimpleIntegerProperty(this, "id_room");;
        roomNumber = new SimpleStringProperty(this, "room_number");;
        idType = new SimpleIntegerProperty(this, "id_room_type");;
        type = new SimpleStringProperty(this, "type");;
        status = new SimpleStringProperty(this, "status");;
        price = new SimpleFloatProperty(this, "price");;
        capacity = new SimpleIntegerProperty(this, "capacity");;
    }

    public IntegerProperty idRoomProperty() {return idRoom;}
    public Integer getidRoom() {return idRoom.get();}
    public void setidRoom(Integer newId) {idRoom.set(newId);}

    public StringProperty roomNumberProperty() {return roomNumber;}
    public String getroomNumber() {return roomNumber.get();}
    public void setroomNumber(String newroomNumber) {roomNumber.set(newroomNumber);}

    public IntegerProperty idTypeProperty() {return idType;}
    public Integer getidType() {return idType.get();}
    public void setidType(Integer newidType) {idType.set(newidType);}

    public StringProperty typeProperty() {return type;}
    public String gettype() {return type.get();}
    public void settype(String newtype) {type.set(newtype);}

    public StringProperty statusProperty() {return status;}
    public String getstatus() {return status.get();}
    public void setstatus(String newstatus) {status.set(newstatus);}


    public FloatProperty priceProperty() {return price;}
    public Float getprice() {return price.get();}
    public void setprice(Float newprice) {price.set(newprice);}

    public IntegerProperty capacityProperty() {return capacity;}
    public Integer getcapacity() {return capacity.get();}
    public void setcapacity(Integer newcapacity) {capacity.set(newcapacity);}





}
