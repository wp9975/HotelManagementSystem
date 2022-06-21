package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionController implements Initializable {

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    @FXML
    private void pane4_mexit(MouseEvent event) {
        pane4.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane4_hover(MouseEvent event) {
        pane4.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane5_mexit(MouseEvent event) {
        pane5.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane5_hover(MouseEvent event) {
        pane5.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane6_mexit(MouseEvent event) {
        pane6.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane6_hover(MouseEvent event) {
        pane6.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane7_mexit(MouseEvent event) {
        pane7.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane7_hover(MouseEvent event) {
        pane7.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }
// ____________________________________________________________________________________________

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
    private void checkinchange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reception/checkinscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void checkoutchange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reception/checkoutscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void guestlistchange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reception/guestlistscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void serviceschange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reception/servicesscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void reservationchange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reservations/reservations.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void roomserviceschange(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reception/roomservicesscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// ______________________________________________________________________________________

}
