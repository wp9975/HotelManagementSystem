package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    public LoginController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrong;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        HotelMS log = new HotelMS();
        if (username.getText().toString().equals("administracja") && password.getText().toString().equals("administracja")) {
            wrong.setText("Pomyślnie");
            log.changeScene("/admin/adminscreen.fxml");
        } else if (username.getText().toString().equals("pracownik") && password.getText().toString().equals("pracownik")) {
            wrong.setText("Pomyślnie");

            log.changeScene("/workers/workersscreen.fxml");
        } else if (username.getText().toString().equals("recepcja") && password.getText().toString().equals("recepcja")) {
            wrong.setText("Pomyślnie!");

            log.changeScene("/reception/receptionscreen.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrong.setText("Wpisz odpowiednie dane!");
        } else {
            wrong.setText("Błędne login lub hasło");
       }
    }
}
