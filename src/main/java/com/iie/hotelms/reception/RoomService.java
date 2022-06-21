package com.iie.hotelms.reception;

import javafx.beans.property.*;

public class RoomService {

    private final IntegerProperty id_room_service;
    private final StringProperty name;
    private final StringProperty description;
    private final StringProperty status;
    private final IntegerProperty idRoom;
    private final StringProperty roomNumber;
    private final IntegerProperty idType;
    private final StringProperty type;
    private final IntegerProperty id_worker;
    private final IntegerProperty id_department;



    public RoomService(){
        id_room_service = new SimpleIntegerProperty(this, "id_room_service");
        name = new SimpleStringProperty(this, "name");
        status = new SimpleStringProperty(this, "status");
        description = new SimpleStringProperty(this, "description");
        idType = new SimpleIntegerProperty(this, "id_room_type");
        type = new SimpleStringProperty(this, "type");
        idRoom = new SimpleIntegerProperty(this, "id_room");
        roomNumber = new SimpleStringProperty(this, "room_number");
        id_department = new SimpleIntegerProperty(this, "id_department");
        id_worker = new SimpleIntegerProperty(this, "id_worker");


    }


    public IntegerProperty idRoomServiceProperty() {return id_room_service;}
    public Integer getidRoomService() {return id_room_service.get();}
    public void setidRoomService(Integer newId) {id_room_service.set(newId);}

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

    public IntegerProperty idRoomProperty() {return idRoom;}
    public Integer getidRoom() {return idRoom.get();}
    public void setidRoom(Integer newId) {idRoom.set(newId);}

    public StringProperty roomNumberProperty() {return roomNumber;}
    public String getroomNumber() {return roomNumber.get();}
    public void setroomNumber(String newroomNumber) {roomNumber.set(newroomNumber);}

    public IntegerProperty idTypeProperty() {return idType;}
    public Integer getidType() {return idType.get();}
    public void setidType(Integer newidType) {idType.set(newidType);}

    public StringProperty typeProperty() {return type;}
    public String gettype() {return type.get();}
    public void settype(String newtype) {type.set(newtype);}

    public StringProperty statusProperty() {return status;}
    public String getstatus() {return status.get();}
    public void setstatus(String newstatus) {status.set(newstatus);}

    public IntegerProperty idWorkerProperty() {return id_worker;}
    public Integer getIdWorker() {return id_worker.get();}
    public void setIdWorker(Integer newId) {id_worker.set(newId);}




    public IntegerProperty id_departmentProperty() {return id_department;}
    public Integer getIdDepartment() {return id_department.get();}
    public void setIdDepartment(Integer newIdDepartment) {id_department.set(newIdDepartment);}


}
