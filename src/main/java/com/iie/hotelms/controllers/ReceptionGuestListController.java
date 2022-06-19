package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import com.iie.hotelms.database.DatabaseConnection;
import com.iie.hotelms.reception.CheckOutTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.iie.hotelms.database.DatabaseConnection.dbLink;

public class ReceptionGuestListController implements Initializable {

    @FXML
    private TableColumn<CheckOutTable, String> columnAddress;

    @FXML
    private TableColumn<CheckOutTable, Float> columnBill;

    @FXML
    private TableColumn<CheckOutTable, String> columnCheckInDate;

    @FXML
    private TableColumn<CheckOutTable, Integer> columnId;

    @FXML
    private TableColumn<CheckOutTable, String> columnLastName;

    @FXML
    private TableColumn<CheckOutTable, String> columnName;

    @FXML
    private TableColumn<CheckOutTable, String> columnPhone;

    @FXML
    private TableColumn<CheckOutTable, String> columnRoomNumber;

    @FXML
    private TableView<CheckOutTable> table;

    PreparedStatement pst;

    public void table() {

        ObservableList<CheckOutTable> checkouttab = FXCollections.observableArrayList();
        try {
            pst = dbLink.prepareStatement("select guest.id_guest, guest.first_name, guest.last_name, guest.address ,guest.phone, room.room_number, room.price, reservation.id_reservation, reservation.check_in, reservation.bill  from reservation join guest on reservation.id_guest=guest.id_guest join room on reservation.id_room=room.id_room;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    CheckOutTable st = new CheckOutTable();
                    st.setGuestId(rs.getInt("id_guest"));
                    st.setName(rs.getString("first_name"));
                    st.setLastname(rs.getString("last_name"));
                    st.setRoomNumber(rs.getString("room_number"));
                    st.setCheckInDate(String.valueOf(rs.getDate("check_in")));
                    st.setBill(rs.getFloat("bill"));
                    st.setReservationId(rs.getInt("id_reservation"));
                    st.setPriceNumber(rs.getFloat("price"));
                    st.setAddress(rs.getString("address"));
                    st.setPhone(rs.getString("phone"));
                    checkouttab.add(st);
                }
            }
            table.setItems(checkouttab);
            columnId.setCellValueFactory(f -> f.getValue().guestIdProperty().asObject());
            columnRoomNumber.setCellValueFactory(f -> f.getValue().roomNumberProperty());
            columnName.setCellValueFactory(f -> f.getValue().nameProperty());
            columnLastName.setCellValueFactory(f -> f.getValue().lastnameProperty());
            columnAddress.setCellValueFactory(f -> f.getValue().addressProperty());
            columnPhone.setCellValueFactory(f -> f.getValue().phoneProperty());
            columnCheckInDate.setCellValueFactory(f -> f.getValue().checkInDateProperty());
            columnBill.setCellValueFactory(f -> f.getValue().billProperty().asObject());

        } catch (SQLException ex) {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection.getConnection();
        table();
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
