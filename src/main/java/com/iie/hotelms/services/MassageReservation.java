package com.iie.hotelms.services;

import javafx.beans.property.*;

public class MassageReservation {

    private IntegerProperty id_massages_reservation;
    private StringProperty type;
    private StringProperty date;
    private StringProperty start;
    private StringProperty end;
    private FloatProperty price;
    private StringProperty name;
    private StringProperty lastName;
    private IntegerProperty id_guest;

    public MassageReservation() {
        this.id_massages_reservation = new SimpleIntegerProperty(this, "id_massages_reservation");
        this.date = new SimpleStringProperty(this, "date");
        this.type = new SimpleStringProperty(this, "type");
        this.start = new SimpleStringProperty(this, "start");
        this.end = new SimpleStringProperty(this, "end");
        this.price = new SimpleFloatProperty(this, "price");
        this.name = new SimpleStringProperty(this, "name");
        this.lastName = new SimpleStringProperty(this, "lastName");
        this.id_guest = new SimpleIntegerProperty(this, "id_guest");
    }

    public int getId_massages_reservation() {
        return id_massages_reservation.get();
    }

    public IntegerProperty id_massages_reservationProperty() {
        return id_massages_reservation;
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setId_massages_reservation(int id_massages_reservation) {
        this.id_massages_reservation.set(id_massages_reservation);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getStart() {
        return start.get();
    }

    public StringProperty startProperty() {
        return start;
    }

    public void setStart(String start) {
        this.start.set(start);
    }

    public String getEnd() {
        return end.get();
    }

    public StringProperty endProperty() {
        return end;
    }

    public void setEnd(String end) {
        this.end.set(end);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getId_guest() {
        return id_guest.get();
    }

    public IntegerProperty id_guestProperty() {
        return id_guest;
    }

    public void setId_guest(int id_guest) {
        this.id_guest.set(id_guest);
    }
}
