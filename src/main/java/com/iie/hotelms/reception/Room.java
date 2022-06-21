package com.iie.hotelms.reception;

import javafx.beans.property.*;

public class Room {

    private final IntegerProperty id_room;
    private final StringProperty room_number;
    private final IntegerProperty capacity;
    private final FloatProperty price;


    public Room() {
        id_room = new SimpleIntegerProperty(this, "id_room");
        room_number = new SimpleStringProperty(this, "room_number");
        capacity = new SimpleIntegerProperty(this, "capcity");
        price = new SimpleFloatProperty(this, "price");
    }

    public IntegerProperty idRoomProperty() {return id_room;}
    public Integer getIdRoom() {return id_room.get();}
    public void setIdRoom(Integer newIdRoom) {id_room.set(newIdRoom);}

    public StringProperty roomNumberProperty() {return room_number;}
    public String getRoomNumber() {return room_number.get();}
    public void setRoomNumber(String newRoomNumber) {room_number.set(newRoomNumber);}

    public IntegerProperty capacityProperty() {return capacity;}
    public Integer getCapacity() {return capacity.get();}
    public void setCapacity(Integer newCapacity) {capacity.set(newCapacity);}

    public FloatProperty priceProperty() {return price;}
    public Float getPrice() {return price.get();}
    public void setPrice(Float newPrice) {price.set(newPrice);}


}
