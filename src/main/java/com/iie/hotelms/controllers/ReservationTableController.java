package com.iie.hotelms.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationTableController implements Initializable {

    @FXML
    private ComboBox startTime;

    @FXML
    private ComboBox endTime;

    @FXML
    private ComboBox price;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> list = FXCollections.observableArrayList("7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00",
                "15:00","16:00","17:00","18:00","19:00","20:00","21:00");
        startTime.setItems(list);

        ObservableList<String> list2 = FXCollections.observableArrayList("8:00","9:00","10:00","11:00","12:00","13:00","14:00",
                "15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00");
        endTime.setItems(list2);

        ObservableList<String> list3 = FXCollections.observableArrayList("10","20","30","40",
                "50","60","70","80", "90","100");
        price.setItems(list3);
    }



    public void Add(ActionEvent event) {
    }

    public void Update(ActionEvent event) {
    }

    public void Delete(ActionEvent event) {
    }

    public void search(ActionEvent event) {
    }
}
