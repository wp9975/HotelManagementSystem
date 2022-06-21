package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Room;
import com.iie.hotelms.database.DatabaseConnection;
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

import static com.iie.hotelms.database.DatabaseConnection.dbLink;

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
    private ChoiceBox txtRoomType;

    @FXML
    private TableView<Room> table;


    PreparedStatement pst;
    int myIndex;
    int id;

    @FXML
    void Add(ActionEvent event) {
        Integer status = 1;
        String roomNumber = txtRoomNumber.getText();
        Integer capacity = Integer.valueOf(txtCapacity.getText());
        Float price = Float.valueOf(txtPrice.getText());

        String type = String.valueOf(txtRoomType.getValue());
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

        try{
            pst = dbLink.prepareStatement("insert into room(status,room_number,price,id_room_type,capacity) values(?,?,?,?,?)");
            pst.setInt(1, status);
            pst.setString(2, roomNumber);
            pst.setFloat(3, price);
            pst.setInt(4, id_room_type);
            pst.setInt(5, capacity);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);


            alert.setHeaderText("Nowy pokój został dodany");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void Delete(ActionEvent event) {

        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getidRoom()));


        try
        {
            pst = dbLink.prepareStatement("delete from room where id_room = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Usunięto pokój");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Update(ActionEvent event) {

        Integer status = 1;
        String roomNumber = txtRoomNumber.getText();
        Integer capacity = Integer.valueOf(txtCapacity.getText());
        Float price = Float.valueOf(txtPrice.getText());

        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getidRoom()));

        String type = String.valueOf(txtRoomType.getValue());
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

        try{
            pst = dbLink.prepareStatement("update room set room_number = ?, price = ?, id_room_type = ?, capacity = ? where id_room = ?");
            pst.setString(1, roomNumber);
            pst.setFloat(2, price);
            pst.setInt(3, id_room_type);
            pst.setInt(4, capacity);
            pst.setInt(5, id);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);


            alert.setHeaderText("Zmiany zostały wprowadzone");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setChoiceBox(){


        try {
            pst = dbLink.prepareStatement("select id_room_type, type from roomtype;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    txtRoomType.getItems().add(rs.getString("type"));
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void table()
    {


        ObservableList<Room> pokoje = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select room.id_room, room.room_number, room.id_room_type, roomtype.type, room.status, room.price, room.capacity from room join roomtype on room.id_room_type=roomtype.id_room_type;");
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
                    txtRoomType.setValue(table.getItems().get(myIndex).gettype());
                }
            });
            return myRow;
        });



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

        setChoiceBox();
        table();
       DatabaseConnection.getConnection();

    }


}
