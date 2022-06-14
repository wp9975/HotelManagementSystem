package com.iie.hotelms.services;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaskList {

    private IntegerProperty id_room_service;
    private StringProperty room_number;
    private StringProperty name;
    private StringProperty description;
    private StringProperty status;

    public int getId_room_service() {
        return id_room_service.get();
    }

    public IntegerProperty id_room_serviceProperty() {
        return id_room_service;
    }

    public void setId_room_service(int id_room_service) {
        this.id_room_service.set(id_room_service);
    }

    public String getRoom_number() {
        return room_number.get();
    }

    public StringProperty room_numberProperty() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number.set(room_number);
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

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public TaskList() {
        this.id_room_service = new SimpleIntegerProperty(this,"id_room_service");
        this.room_number = new SimpleStringProperty(this,"room_number");
        this.name = new SimpleStringProperty(this,"name");;
        this.description = new SimpleStringProperty(this,"description");
        this.status = new SimpleStringProperty(this,"status");
    }
}
