package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Room;
import com.iie.hotelms.admin.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminRoomsController implements Initializable {

    @FXML
    private TableColumn<Room, Integer> GuestColumn;

    @FXML
    private TableColumn<Room, Integer> IdColumn;

    @FXML
    private TableColumn<Room, Float> PriceColumn;

    @FXML
    private TableColumn<Room, String> RoomNumberColumn;

    @FXML
    private TableColumn<Room, String> RoomTypeColumn;

    @FXML
    private TableColumn<Room, String> StatusColumn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Pane paneb;

    @FXML
    private TextField txtCapacity;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRoomNumber;

    @FXML
    private ChoiceBox<?> txtRoomType;

    @FXML
    private TableView<Room> table;

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    @FXML
    void Add(ActionEvent event) {

    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }

    public void table()
    {
        Connect();

        ObservableList<Room> pokoje = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select room.id_room, room.room_number, room.id_room_type, roomtype.type, room.status, room.price, room.capacity from room join roomtype on room.id_room_type=roomtype.id_room_type;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Room st = new Room();
                    st.setidRoom(rs.getInt("id_room"));
                    st.setroomNumber(rs.getString("room_number"));
                    st.setidType(rs.getInt("id_room_type"));
                    st.settype(rs.getString("type"));
                    st.setstatus(rs.getString("status"));
                    st.setprice(rs.getFloat("price"));
                    st.setcapacity(rs.getInt("capacity"));
                    pokoje.add(st);
                }
            }
            table.setItems(pokoje);
            IdColumn.setCellValueFactory(f -> f.getValue().idRoomProperty().asObject());
            RoomNumberColumn.setCellValueFactory(f -> f.getValue().roomNumberProperty());
            RoomTypeColumn.setCellValueFactory(f -> f.getValue().typeProperty());
            StatusColumn.setCellValueFactory(f -> f.getValue().statusProperty());
            PriceColumn.setCellValueFactory(f -> f.getValue().priceProperty().asObject());
            GuestColumn.setCellValueFactory(f -> f.getValue().capacityProperty().asObject());

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
                    txtRoomNumber.setText(table.getItems().get(myIndex).getroomNumber());
                    txtPrice.setText(String.valueOf(table.getItems().get(myIndex).getprice()));
                    txtCapacity.setText(String.valueOf(table.getItems().get(myIndex).getcapacity()));

                }
            });
            return myRow;
        });



    }

    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelms","root","root");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table();
        Connect();

    }


}
