package com.iie.hotelms.admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pracownik {

    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty imie;
    private final StringProperty nazwisko;

    private final StringProperty telefon;
    private final IntegerProperty id_worker;


    public Pracownik(){
        id_worker = new SimpleIntegerProperty(this, "id_worker");
        email = new SimpleStringProperty(this, "email");
        password = new SimpleStringProperty(this, "password");
        imie = new SimpleStringProperty(this, "first_name");
        nazwisko = new SimpleStringProperty(this, "last_name");
        telefon = new SimpleStringProperty(this, "phone");

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

    public StringProperty imieProperty() {return imie;}
    public String getImie() {return imie.get();}
    public void setImie(String newImie) {imie.set(newImie);}

    public StringProperty nazwiskoProperty() {return nazwisko;}
    public String getNazwisko() {return nazwisko.get();}
    public void setNazwisko(String newNazwisko) {nazwisko.set(newNazwisko);}


    public StringProperty telefonProperty() {return telefon;}
    public String getTelefon() {return telefon.get();}
    public void setTelefon(String newTelefon) {telefon.set(newTelefon);}






}
