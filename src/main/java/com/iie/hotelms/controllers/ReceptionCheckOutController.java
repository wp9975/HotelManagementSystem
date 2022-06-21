package com.iie.hotelms.controllers;

import com.iie.hotelms.database.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import com.iie.hotelms.reception.CheckOutTable;
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
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.iie.PDFGenerator.PDF.savePdF;
import static com.iie.hotelms.database.DatabaseConnection.dbLink;


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
    private ChoiceBox txtpaymentmethod;

    @FXML
    private TextField txtreservationid;

    @FXML
    private TextField txtroomnumber;

    @FXML
    private TextField txtroomprice;

    @FXML
    private TextField txtservices;

    @FXML
    private TextField txtPDFDest;

    @FXML
    private TextField txtlastname;

    int myIndex;
    PreparedStatement pst;

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public void invoice() throws FileNotFoundException {

        Integer idReservation = Integer.valueOf(txtreservationid.getText());
        String name = txtname.getText() + " " + txtlastname.getText();
        String address = txtadress.getText();
        String nip = txtnip.getText();
        String invoiceNumber = getSaltString();
        String payMethod = "Gotówka";
        Integer bill = Integer.valueOf(txtbill.getText());
        String roomNumber = txtroomnumber.getText();
        String addons = " ";
        Integer daysInHotel = 2;
        Integer paid= Integer.valueOf(txtpaid.getText());

        Integer leftToPay = bill - paid;
        Integer roomPrice = Integer.valueOf(txtroomprice.getText());

        String destination2 = txtPDFDest.getText();

        String destination = "C:/Users/DeskAme/Desktop/pdfs/sample.pdf";

        if(destination2 != null){
            destination = destination2;
        }



        savePdF(destination,idReservation, name, address, nip, invoiceNumber
                , payMethod, bill, roomNumber, roomPrice, addons, daysInHotel, paid, leftToPay );


    }


    @FXML
    void checkout(ActionEvent event) throws SQLException {
        Integer id_reservation = Integer.valueOf(txtreservationid.getText());
        Integer id_guest = 1;
        Integer id_room = 1;

        try {
            pst = dbLink.prepareStatement("select id_guest, id_room from reservation where id_reservation= ?;");
            pst.setInt(1, id_reservation);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    id_guest = rs.getInt("id_guest");
                    id_room = rs.getInt("id_room");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            pst = dbLink.prepareStatement("delete from guest where id_guest=?;");
            pst.setInt(1, id_guest);
            pst.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            pst = dbLink.prepareStatement("delete from reservation where id_reservation=?;");
            pst.setInt(1, id_reservation);
            pst.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            pst = dbLink.prepareStatement("update room set status = 1 where id_room = ? ;");
            pst.setInt(1, id_room);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Poprawnie wymeldowano klienta!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }




    public void table(){

        ObservableList<CheckOutTable> checkouttab = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select hotelms.guest.id_guest, hotelms.guest.first_name, hotelms.guest.last_name, hotelms.guest.address ,hotelms.room.room_number, hotelms.room.price, hotelms.reservation.id_reservation, hotelms.reservation.check_in, hotelms.reservation.bill  from hotelms.reservation join hotelms.guest on hotelms.reservation.id_guest=hotelms.guest.id_guest join hotelms.room on hotelms.reservation.id_room=hotelms.room.id_room;");
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
                    txtbill.setText(String.valueOf(Math.round(table.getItems().get(myIndex).getBill())));
                    txtreservationid.setText(String.valueOf(table.getItems().get(myIndex).getReservationId()));
                    txtroomprice.setText(String.valueOf(Math.round(table.getItems().get(myIndex).getPriceNumber())));
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
