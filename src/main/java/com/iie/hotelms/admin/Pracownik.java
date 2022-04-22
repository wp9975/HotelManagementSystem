package com.iie.hotelms.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pracownik {
    private final StringProperty login;
    private final StringProperty haslo;
    private final StringProperty imie;
    private final StringProperty nazwisko;
    private final StringProperty adres_zamieszkania;
    private final StringProperty telefon;
    private final StringProperty data_urodzenia;
    private final StringProperty email;

    public Pracownik(){
        login = new SimpleStringProperty(this, "login");
        haslo = new SimpleStringProperty(this, "haslo");
        imie = new SimpleStringProperty(this, "imie");
        nazwisko = new SimpleStringProperty(this, "nazwisko");
        adres_zamieszkania = new SimpleStringProperty(this, "adres_zamieszkania");
        telefon = new SimpleStringProperty(this, "telefon");
        data_urodzenia = new SimpleStringProperty(this, "data_urodzenia");
        email = new SimpleStringProperty(this, "email");
    }


    public StringProperty loginProperty() {return login;}
    public String getLogin() {return login.get();}
    public void setLogin(String newLogin) {login.set(newLogin);}

    public StringProperty hasloProperty() {return haslo;}
    public String getHaslo() {return haslo.get();}
    public void setHaslo(String newHaslo) {haslo.set(newHaslo);}

    public StringProperty imieProperty() {return imie;}
    public String getImie() {return imie.get();}
    public void setImie(String newImie) {imie.set(newImie);}

    public StringProperty nazwiskoProperty() {return nazwisko;}
    public String getNazwisko() {return nazwisko.get();}
    public void setNazwisko(String newNazwisko) {nazwisko.set(newNazwisko);}

    public StringProperty adresProperty() {return adres_zamieszkania;}
    public String getAdres() {return adres_zamieszkania.get();}
    public void setAdres(String newAdres) {adres_zamieszkania.set(newAdres);}

    public StringProperty telefonProperty() {return telefon;}
    public String getTelefon() {return telefon.get();}
    public void setTelefon(String newTelefon) {telefon.set(newTelefon);}

    public StringProperty data_urodzeniaProperty() {return data_urodzenia;}
    public String getDataUrodzenia() {return data_urodzenia.get();}
    public void setDataUrodzenia(String newDataUrodzenia) {data_urodzenia.set(newDataUrodzenia);}

    public StringProperty emailProperty() {return email;}
    public String getEmail() {return email.get();}
    public void setEmail(String newEmail) {email.set(newEmail);}


}
