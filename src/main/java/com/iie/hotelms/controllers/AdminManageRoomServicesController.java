package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Room;
import com.iie.hotelms.admin.RoomService;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.iie.hotelms.database.DatabaseConnection.dbLink;

public class AdminManageRoomServicesController implements Initializable {

    @FXML
    private TableColumn<RoomService, Integer> columnId;

    @FXML
    private TableColumn<RoomService, String> columnName;

    @FXML
    private TableColumn<RoomService, String> columnPrice;


    @FXML
    private Pane paneb;

    @FXML
    private TableView<RoomService> table;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    PreparedStatement pst;
    int myIndex;
  //________________________________________________________________________

    @FXML
    void add(ActionEvent event) {

        String name = txtName.getText();
        Float price = Float.valueOf(txtPrice.getText());

        try{
            pst = dbLink.prepareStatement("insert into room_service_types(name , price) values(?,?);");

            pst.setString(1, name);
            pst.setFloat(2, price);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Poprawnie dodano!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void delete(ActionEvent event) {

        Integer id = Integer.valueOf(txtId.getText());

        try{
            pst = dbLink.prepareStatement("delete from room_service_types where id_room_service_type=?;");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Poprawnie usunięto!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void edit(ActionEvent event) {

        Integer id = Integer.valueOf(txtId.getText());
        String name = txtName.getText();
        Float price = Float.valueOf(txtPrice.getText());

        try{
            pst = dbLink.prepareStatement("update room_service_types set name = ? , price = ? where id_room_service_type = ? ;");
            pst.setString(1, name);
            pst.setFloat(2, price);
            pst.setInt(3, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Poprawnie edytowano!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void table()
    {


        ObservableList<RoomService> roomservices = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select id_room_service_type ,name , price from room_service_types;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    RoomService st = new RoomService();
                    st.setidRoomService(rs.getInt("id_room_service_type"));
                    st.setName(rs.getString("name"));
                    st.setprice(rs.getFloat("price"));
                    roomservices.add(st);
                }
            }
            table.setItems(roomservices);
            columnId.setCellValueFactory(f -> f.getValue().idRoomServiceProperty().asObject());
            columnName.setCellValueFactory(f -> f.getValue().nameProperty());
            columnPrice.setCellValueFactory(f -> f.getValue().priceProperty().asString());
        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<RoomService> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex = table.getSelectionModel().getSelectedIndex();
                    txtId.setText(String.valueOf(table.getItems().get(myIndex).getidRoomService()));
                    txtName.setText(table.getItems().get(myIndex).getName());
                    txtPrice.setText(String.valueOf(table.getItems().get(myIndex).getprice()));
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



// _________________________________________________________________________________________
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
