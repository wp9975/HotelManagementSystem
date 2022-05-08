package com.iie.hotelms.controllers;

import com.iie.hotelms.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.iie.hotelms.DatabaseConnection.dbLink;

public class AdminStatsController implements Initializable {


    @FXML
    private Pane paneb;

    @FXML
    private TextField printFreeRooms;

    @FXML
    private TextField printGuestLastDays;

    @FXML
    private TextField printGuestNumber;

    @FXML
    private TextField printLastMonthIncome;

    @FXML
    private TextField printNumberOfWorkers;

    @FXML
    private TextField printOccupiedRoom;


    PreparedStatement pst;



    public void setGuestNumber(){

            try {
                pst = dbLink.prepareStatement("select count(*) as count from workers;");
                ResultSet rs = pst.executeQuery();
                {
                    while (rs.next()) {

                        printNumberOfWorkers.setText(String.valueOf(rs.getInt("count")));

                    }
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    public void setRooms(){

        try {
            pst = dbLink.prepareStatement("select count(*) as count from room where status = 1;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    printFreeRooms.setText(String.valueOf(rs.getInt("count")));

                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pst = dbLink.prepareStatement("select count(*) as count from room where status = 2;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    printOccupiedRoom.setText(String.valueOf(rs.getInt("count")));

                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection.getConnection();
        setGuestNumber();
        setRooms();
    }




    @FXML
    private void paneb_mexit(MouseEvent event) {
        paneb.setStyle("-fx-background-color: bisque; -fx-background-radius: 6px;");
    }

    @FXML
    private void paneb_hover(MouseEvent event) {
        paneb.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }



    @FXML
    private void back(MouseEvent event) {

        HotelMS log = new HotelMS();
        try {
            log.changeScene("/admin/adminscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
