package com.iie.hotelms.controllers;

import com.iie.hotelms.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Worker;
import com.iie.hotelms.reception.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

public class ReceptionCheckInController implements Initializable {

    @FXML
    private Pane paneb;

    @FXML
    private Button clear;

    @FXML
    private TableColumn<Room, String> colcapacity;

    @FXML
    private TableColumn<Room, String> colprice;

    @FXML
    private TableColumn<Room, String> colroomnumber;

    @FXML
    private Button submit;

    @FXML
    private TextField txtadress;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtcountry;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtlastname;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnumberofadults;

    @FXML
    private TextField txtnumberofchildren;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtroomnumber;

    @FXML
    private ChoiceBox txtroomtype;

    @FXML
    private TableView<Room> table;


    int myIndex;
    PreparedStatement pst;

    public void setChoiceBox(){

        try {
            pst = dbLink.prepareStatement("select type from roomtype;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    txtroomtype.getItems().add(rs.getString("type"));
                }
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void table(){
        String type = String.valueOf(txtroomtype.getValue());
        int id_room_type = 1 ;

        try {
            pst = dbLink.prepareStatement("select id_room_type from roomtype where type= ?;");
            pst.setString(1, type);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    id_room_type = rs.getInt("id_room_type");
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObservableList<Room> rooms = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select id_room, room_number, capacity, price from room where id_room_type = ? ");
            pst.setInt(1, id_room_type);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Room st = new Room();
                    st.setIdRoom(rs.getInt("id_room"));
                    st.setRoomNumber(rs.getString("room_number"));
                    st.setCapacity(rs.getInt("capacity"));
                    st.setPrice(rs.getFloat("price"));
                    rooms.add(st);
                }
            }
            table.setItems(rooms);
            colroomnumber.setCellValueFactory(f -> f.getValue().roomNumberProperty());
            colcapacity.setCellValueFactory(f -> f.getValue().capacityProperty().asString());
            colprice.setCellValueFactory(f -> f.getValue().priceProperty().asString());


        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Room> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    txtroomnumber.setText(table.getItems().get(myIndex).getRoomNumber());
                }
            });
            return myRow;
        });

        System.out.println(id_room_type + type);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection.getConnection();
        setChoiceBox();

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
            log.changeScene("/reception/receptionscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
