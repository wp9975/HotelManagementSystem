package com.iie.hotelms.admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Department {

    private final IntegerProperty id_department;
    private final StringProperty dept_name;

    public Department(){
        id_department = new SimpleIntegerProperty(this, "id_department");
        dept_name = new SimpleStringProperty(this, "dept_name");
    }

    public IntegerProperty id_department2Property() {return id_department;}
    public Integer getIdDepartment2() {return id_department.get();}
    public void setIdDepartment2(Integer newIdDepartment) {id_department.set(newIdDepartment);}

    public StringProperty deptNameProperty2() {return dept_name;}
    public String getDeptName2() {return dept_name.get();}
    public void setDeptName2(String newDeptName) {
        dept_name.set(newDeptName);}



}
