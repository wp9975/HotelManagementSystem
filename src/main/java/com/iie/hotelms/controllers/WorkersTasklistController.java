package com.iie.hotelms.controllers;


import com.iie.hotelms.HotelMS;
import com.iie.hotelms.reception.RoomGuest;
import com.iie.hotelms.services.TaskList;
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
import static com.iie.hotelms.database.DatabaseConnection.getConnection;

public class WorkersTasklistController implements Initializable {

    @FXML
    private Pane pane6;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnInProgress;

    @FXML
    private Button btnToDo;

    @FXML
    private TableColumn<TaskList, String> columnDescription;

    @FXML
    private TableColumn<TaskList, Integer> columnId;

    @FXML
    private TableColumn<TaskList, String> columnRoomNumber;

    @FXML
    private TableColumn<TaskList, String> columnStatus;

    @FXML
    private TableColumn<TaskList, String> columnTask;

    @FXML
    private TableView<TaskList> table;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPrice;

    int myIndex;
    PreparedStatement pst;

    @FXML
    void taskdone(ActionEvent event) {
        Integer id_reservation = 1;
        Float price = Float.valueOf(txtPrice.getText());
        Integer id_room = 1;
        Integer id =(Integer.parseInt(txtId.getText()));

        try{
            pst = dbLink.prepareStatement("update room_service set status = ? where id_room_service = ?");
            pst.setInt(1, 3);
            pst.setInt(2, id);


            pst.executeUpdate();



            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try
        {
            pst = dbLink.prepareStatement("select id_room from room_service where id_room_service=?");
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {

                    id_room = rs.getInt("id_room");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try
        {
            pst = dbLink.prepareStatement("select reservation.id_reservation from reservation join room on reservation.id_room=room.id_room where reservation.id_room=?;");
            pst.setInt(1,id_room);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {

                   id_reservation = rs.getInt("id_reservation");

                }
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

        try{
            pst = dbLink.prepareStatement("update reservation set bill = bill + ? where id_reservation = ?");
            pst.setFloat(1, price);
            pst.setInt(2, id_reservation);


            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);


            alert.setHeaderText("Zadanie wykonane. Naliczono opłatę.");

            alert.showAndWait();


            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    @FXML
    void taskinprogress(ActionEvent event) {

        Integer id =(Integer.parseInt(txtId.getText()));

        try{
            pst = dbLink.prepareStatement("update room_service set status = ? where id_room_service = ?");
            pst.setInt(1, 2);
            pst.setInt(2, id);


            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);


            alert.setHeaderText("Zadanie w trakcie realizacji");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void tasktodo(ActionEvent event) {

        Integer id =(Integer.parseInt(txtId.getText()));

        try{
            pst = dbLink.prepareStatement("update room_service set status = ? where id_room_service = ?");
            pst.setInt(1, 1);
            pst.setInt(2, id);


            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);


            alert.setHeaderText("Zadanie do zrobienia");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void table(){
        ObservableList<TaskList> tasklistt = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement(" select room.room_number, id_room_service, name, description, room_service.status from room_service join room on room_service.id_room= room.id_room;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    TaskList st = new TaskList();
                    st.setId_room_service(rs.getInt("id_room_service"));
                    st.setRoom_number(rs.getString("room_number"));
                    st.setName(rs.getString("name"));
                    st.setDescription(rs.getString("description"));
                    st.setStatus(rs.getString("status"));

                    tasklistt.add(st);
                }
            }
            table.setItems(tasklistt);
            columnRoomNumber.setCellValueFactory(f -> f.getValue().room_numberProperty());
            columnId.setCellValueFactory(f -> f.getValue().id_room_serviceProperty().asObject());
            columnTask.setCellValueFactory(f -> f.getValue().nameProperty());
            columnDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
            columnStatus.setCellValueFactory(f -> f.getValue().statusProperty());

        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }





        table.setRowFactory( tv -> {
            TableRow<TaskList> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    txtId.setText(String.valueOf(table.getItems().get(myIndex).getId_room_service()));


                }
            });
            return myRow;
        });
    }


    @FXML
    private void pane6_mexit(MouseEvent event) {
        pane6.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void pane6_hover(MouseEvent event) {
        pane6.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void exit(MouseEvent event) {

        HotelMS log = new HotelMS();
        try {
            log.changeScene("/loginscreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getConnection();
        table();


    }


}