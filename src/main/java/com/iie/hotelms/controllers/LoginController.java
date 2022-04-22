package com.iie.hotelms.controllers;

import com.iie.hotelms.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    @FXML
    private Label showname;

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        HotelMS log = new HotelMS();
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
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

    public void connectButton(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "SELECT imie FROM pracownicy";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(query);
            while (queryOutput.next()){
                showname.setText(queryOutput.getString("imie"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
