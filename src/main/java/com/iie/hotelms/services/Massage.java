package com.iie.hotelms.services;

import javafx.beans.property.*;

public class Massage {



    private IntegerProperty id_massage;
    private StringProperty name;
    private StringProperty description;
    private FloatProperty price;


    public Massage() {
        this.id_massage = new SimpleIntegerProperty(this, "id_massage");
        this.name = new SimpleStringProperty(this, "name");
        this.description = new SimpleStringProperty(this, "description");
        this.price = new SimpleFloatProperty(this, "price");
    }


    public int getId_massage() {
        return id_massage.get();
    }

    public IntegerProperty id_massageProperty() {
        return id_massage;
    }

    public void setId_massage(int id_massage) {
        this.id_massage.set(id_massage);
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

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
}
