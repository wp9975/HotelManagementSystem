package com.iie.hotelms.reception;

import javafx.beans.property.*;

public class CheckOutTable {

    private final StringProperty name;
    private final StringProperty lastName;
    private final StringProperty address;
    private final StringProperty roomNumber;
    private final FloatProperty roomPrice;
    private final StringProperty checkInDate;
    private final IntegerProperty id_guest;
    private final IntegerProperty id_reservation;
    private final FloatProperty bill;


// tab
    public CheckOutTable() {
        this.name = new SimpleStringProperty(this,"name");
        this.lastName = new SimpleStringProperty(this,"lastName");
        this.roomNumber = new SimpleStringProperty(this,"roomNumber");
        this.checkInDate = new SimpleStringProperty(this,"checkInDate");
        this.id_guest = new SimpleIntegerProperty(this, "id_guest");
        this.id_reservation = new SimpleIntegerProperty(this, "id_reservation");
        this.bill = new SimpleFloatProperty(this, "bill");
        this.roomPrice = new SimpleFloatProperty(this, "roomPrice");
        this.address = new SimpleStringProperty(this, "address");
    }


    public StringProperty nameProperty() {return name;}
    public String getName() {return name.get();}
    public void setName(String newImie) {
        name.set(newImie);}

    public StringProperty addressProperty() {return address;}
    public String getAddress() {return address.get();}
    public void setAddress(String newImie) {
        address.set(newImie);}

    public StringProperty lastnameProperty() {return lastName;}
    public String getLastname() {return lastName.get();}
    public void setLastname(String newNazwisko) {
        lastName.set(newNazwisko);}

    public StringProperty roomNumberProperty() {return roomNumber;}
    public String getRoomNumber() {return roomNumber.get();}
    public void setRoomNumber(String newRoomNumber) {roomNumber.set(newRoomNumber);}

    public FloatProperty roomPriceProperty() {return roomPrice;}
    public Float getPriceNumber() {return roomPrice.get();}
    public void setPriceNumber(Float newRoomNumber) {roomPrice.set(newRoomNumber);}

    public StringProperty checkInDateProperty() {return checkInDate;}
    public String getCheckInDate() {return checkInDate.get();}
    public void setCheckInDate(String newdate) {
        checkInDate.set(newdate);}

    public IntegerProperty guestIdProperty() {return id_guest;}
    public Integer getGuestId() {return id_guest.get();}
    public void setGuestId(Integer newId) {id_guest.set(newId);}

    public IntegerProperty reservationIdProperty() {return id_reservation;}
    public Integer getReservationId() {return id_reservation.get();}
    public void setReservationId(Integer newId) {id_reservation.set(newId);}

    public FloatProperty billProperty() {return bill;}
    public Float getBill() {return bill.get();}
    public void setBill(Float newBill) {bill.set(newBill);}



}
