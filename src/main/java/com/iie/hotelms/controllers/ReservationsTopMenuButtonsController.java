package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ReservationsTopMenuButtonsController {

    public static final String ADD_RESERVATIONS_FXML = "/reservations/listTable.fxml";
    public static final String ADD_TABLE_FXML = "/reservations/addResTable.fxml";
    public static final String ADD_MASSAGE_FXML = "/reservations/addResMassage.fxml";
    public static final String ADD_FIELD_FXML = "/reservations/kindMassage.fxml";
    private ReservationsController reservationsController;

    @FXML
    public void back(MouseEvent mouseEvent) {

        HotelMS log = new HotelMS();
        try {
            log.changeScene("/reception/receptionscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void openListTable( ) {
        reservationsController.setCenter(ADD_RESERVATIONS_FXML);
    }

    @FXML
    public void openRestaurant( ) {
        reservationsController.setCenter(ADD_TABLE_FXML);
    }

    @FXML
    public void openMassage( ) {
        reservationsController.setCenter(ADD_MASSAGE_FXML);
    }

    @FXML
    public void openListMassage() {reservationsController.setCenter(ADD_FIELD_FXML);    }

    public void setReservationsController(ReservationsController reservationsController) {
        this.reservationsController = reservationsController;
    }


}
