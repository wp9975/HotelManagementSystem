package com.iie.hotelms.controllers;

import com.iie.hotelms.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Worker;
import com.iie.hotelms.reception.CheckOutTable;
import com.iie.hotelms.reception.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.iie.PDFGenerator.PDF.savePdF;
import static com.iie.hotelms.DatabaseConnection.dbLink;


public class ReceptionCheckOutController implements Initializable {

    @FXML
    private TableColumn<CheckOutTable, String> colBill;

    @FXML
    private TableColumn<CheckOutTable, String> colCheckInDate;

    @FXML
    private TableColumn<CheckOutTable, String> colLastName;

    @FXML
    private TableColumn<CheckOutTable, String> colName;

    @FXML
    private TableColumn<CheckOutTable, String> colRoomNumber;

    @FXML
    private TableView<CheckOutTable> table;

    @FXML
    private TextField txtadress;

    @FXML
    private TextField txtbill;

    @FXML
    private TextField txtdaysinhotel;

    @FXML
    private TextField txtleft;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnip;

    @FXML
    private TextField txtpaid;

    @FXML
    private ChoiceBox<?> txtpaymentmethod;

    @FXML
    private TextField txtreservationid;

    @FXML
    private TextField txtroomnumber;

    @FXML
    private TextField txtroomprice;

    @FXML
    private TextField txtservices;

    @FXML
    private TextField txtlastname;

    int myIndex;
    PreparedStatement pst;

    public void invoice() throws FileNotFoundException {



        savePdF("C:/Users/DeskAme/Desktop/pdfs/sample.pdf",23, "Marian Kowalski", "Rzeszow, Downigd", "12312332", "zaq213sd"
                , "Gotówka", 345, "145", 70, "Basen", 3, 345, 0 );

    }


    @FXML
    void checkout(ActionEvent event) {

    }




    public void table(){

        ObservableList<CheckOutTable> checkouttab = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select guest.id_guest, guest.first_name, guest.last_name, guest.address ,room.room_number, room.price, reservation.id_reservation, reservation.check_in, reservation.bill  from reservation join guest on reservation.id_guest=guest.id_guest join room on reservation.id_room=room.id_room;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
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
                    checkouttab.add(st);
                }
            }
            table.setItems(checkouttab);
            colRoomNumber.setCellValueFactory(f -> f.getValue().roomNumberProperty());
            colName.setCellValueFactory(f -> f.getValue().nameProperty());
            colLastName.setCellValueFactory(f -> f.getValue().lastnameProperty());
            colCheckInDate.setCellValueFactory(f -> f.getValue().checkInDateProperty());
            colBill.setCellValueFactory(f -> f.getValue().billProperty().asString());

        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }



        String dute = table.getItems().get(myIndex).getCheckInDate();
        System.out.println(dute);



        table.setRowFactory( tv -> {
            TableRow<CheckOutTable> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    txtname.setText(table.getItems().get(myIndex).getName());
                    txtlastname.setText(table.getItems().get(myIndex).getLastname());
                    txtroomnumber.setText(table.getItems().get(myIndex).getRoomNumber());
                    txtbill.setText(String.valueOf(table.getItems().get(myIndex).getBill()));
                    txtreservationid.setText(String.valueOf(table.getItems().get(myIndex).getReservationId()));
                    txtroomprice.setText(String.valueOf(table.getItems().get(myIndex).getPriceNumber()));
                    txtadress.setText(table.getItems().get(myIndex).getAddress());

                }
            });
            return myRow;
        });

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
