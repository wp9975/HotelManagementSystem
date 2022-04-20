package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable{

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    // hover mouse __________________________________________________________________________
    @FXML
    private void pane1_mexit(MouseEvent event) {
        pane1.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane1_hover(MouseEvent event) {
        pane1.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane2_mexit(MouseEvent event) {
        pane2.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane2_hover(MouseEvent event) {
        pane2.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane3_mexit(MouseEvent event) {
        pane3.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane3_hover(MouseEvent event) {
        pane3.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    // Screen change ____________________________________________________________________________________
    @FXML
    private void exit(MouseEvent event) {

        HotelMS log = new HotelMS();
        try {
            log.changeScene("/loginscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void workerslistchange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/admin/workerslistscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void statschange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/admin/statsscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
