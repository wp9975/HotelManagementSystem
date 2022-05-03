package com.iie.hotelms.admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Worker {

    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty name;
    private final StringProperty lastname;
    private final StringProperty phone;
    private final IntegerProperty id_worker;
    private final IntegerProperty id_department;
    private final StringProperty dept_name;

    public Worker(){
        id_worker = new SimpleIntegerProperty(this, "id_worker");
        email = new SimpleStringProperty(this, "email");
        password = new SimpleStringProperty(this, "password");
        name = new SimpleStringProperty(this, "first_name");
        lastname = new SimpleStringProperty(this, "last_name");
        phone = new SimpleStringProperty(this, "phone");
        id_department = new SimpleIntegerProperty(this, "id_department");
        dept_name = new SimpleStringProperty(this, "dept_name");

    }

    public IntegerProperty idProperty() {return id_worker;}
    public Integer getId() {return id_worker.get();}
    public void setId(Integer newId) {id_worker.set(newId);}

    public StringProperty emailProperty() {return email;}
    public String getEmail() {return email.get();}
    public void setEmail(String newEmail) {email.set(newEmail);}

    public StringProperty passwordProperty() {return password;}
    public String getPassword() {return password.get();}
    public void setPassword(String newPassword) {
        password.set(newPassword);}

    public StringProperty nameProperty() {return name;}
    public String getName() {return name.get();}
    public void setName(String newImie) {
        name.set(newImie);}

    public StringProperty lastnameProperty() {return lastname;}
    public String getLastname() {return lastname.get();}
    public void setLastname(String newNazwisko) {
        lastname.set(newNazwisko);}


    public StringProperty phoneProperty() {return phone;}
    public String getPhone() {return phone.get();}
    public void setPhone(String newTelefon) {
        phone.set(newTelefon);}

    public IntegerProperty id_departmentProperty() {return id_department;}
    public Integer getIdDepartment() {return id_department.get();}
    public void setIdDepartment(Integer newIdDepartment) {id_department.set(newIdDepartment);}

    public StringProperty deptNameProperty() {return dept_name;}
    public String getDeptName() {return dept_name.get();}
    public void setDeptName(String newDeptName) {
        dept_name.set(newDeptName);}



}
