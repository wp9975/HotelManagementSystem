package com.iie.hotelms.reception;

import javafx.beans.property.*;

public class RoomGuest {

    private final IntegerProperty id_room;
    private final StringProperty room_number;
    private final IntegerProperty id_guest;
    private final StringProperty name;


    public RoomGuest() {
        id_room = new SimpleIntegerProperty(this, "id_room");
        room_number = new SimpleStringProperty(this, "room_number");
        id_guest = new SimpleIntegerProperty(this, "id_guest");
        name = new SimpleStringProperty(this,"name");
    }

    public IntegerProperty idRoomProperty() {return id_room;}
    public Integer getIdRoom() {return id_room.get();}
    public void setIdRoom(Integer newIdRoom) {id_room.set(newIdRoom);}


    public StringProperty roomNumberProperty() {return room_number;}
    public String getRoomNumber() {return room_number.get();}
    public void setRoomNumber(String newRoomNumber) {room_number.set(newRoomNumber);}

    public IntegerProperty guestIdProperty() {return id_guest;}
    public Integer getGuestId() {return id_guest.get();}
    public void setGuestId(Integer newId) {id_guest.set(newId);}


    public StringProperty nameProperty() {return name;}
    public String getName() {return name.get();}
    public void setName(String newImie) {
        name.set(newImie);}



}
