package com.iie.hotelms.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AddResMassageController implements Initializable {

    @FXML
    private ComboBox startTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00",
                "15:00", "16:00");
        startTime.setItems(list);
    }

    public void Add(ActionEvent event) {
    }

    public void Search(ActionEvent event) {
    }

    public void Update(ActionEvent event) {
    }

    public void Delete(ActionEvent event) {
    }
}
