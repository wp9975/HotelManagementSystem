package com.iie.hotelms.admin;

import javafx.beans.property.*;

public class Service {

    private final IntegerProperty id_service;
    private final StringProperty name;
    private final StringProperty description;
    private final FloatProperty price;
    private final IntegerProperty id_department;
    private final StringProperty dept_name;

    public Service(){
        id_service = new SimpleIntegerProperty(this, "id_room_service");
        name = new SimpleStringProperty(this, "name");
        description = new SimpleStringProperty(this, "description");
        price = new SimpleFloatProperty(this, "price");
        id_department = new SimpleIntegerProperty(this, "id_department");
        dept_name = new SimpleStringProperty(this, "dept_name");
    }


    public IntegerProperty idServiceProperty() {return id_service;}
    public Integer getidService() {return id_service.get();}
    public void setidService(Integer newId) {id_service.set(newId);}

    public StringProperty nameProperty() {return name;}
    public String getName() {return name.get();}
    public void setName(String newName) {
        name.set(newName);}

    public String getDescription() {
        return description.get();
    }
    public StringProperty descriptionProperty() {
        return description;
    }
    public void setDescription(String description) {
        this.description.set(description);
    }

    public FloatProperty priceProperty() {return price;}
    public Float getprice() {return price.get();}
    public void setprice(Float newprice) {price.set(newprice);}

    public IntegerProperty id_departmentProperty() {return id_department;}
    public Integer getIdDepartment() {return id_department.get();}
    public void setIdDepartment(Integer newIdDepartment) {id_department.set(newIdDepartment);}

    public StringProperty deptNameProperty() {return dept_name;}
    public String getDeptName() {return dept_name.get();}
    public void setDeptName(String newDeptName) {
        dept_name.set(newDeptName);}

}
