package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WorkersController {
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;

    // hover mouse __________________________________________________________________________

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
    private void TaskList(MouseEvent event){
        HotelMS log = new HotelMS();
        try {
            log.changeScene("/workers/tasklistscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
