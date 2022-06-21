package com.iie.hotelms.services;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

    private  IntegerProperty id_guest;

    public int getId_guest() {
        return id_guest.get();
    }

    public IntegerProperty id_guestProperty() {
        return id_guest;
    }

    public void setId_guest(int id_guest) {
        this.id_guest.set(id_guest);
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

    private  StringProperty name;
    private  StringProperty lastName;

    public Client() {
        this.id_guest = new SimpleIntegerProperty(this, "id_guest");
        this.name = new SimpleStringProperty(this,"name");
        this.lastName = new SimpleStringProperty(this,"lastName");
    }


}
