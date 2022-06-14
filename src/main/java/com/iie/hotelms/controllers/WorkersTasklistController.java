package com.iie.hotelms.controllers;


import com.iie.hotelms.services.TaskList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    int myIndex;
    PreparedStatement pst;

    @FXML
    void taskdone(ActionEvent event) {

        Integer id =(Integer.parseInt(txtId.getText()));

        try{
            pst = dbLink.prepareStatement("update room_service set status = ? where id_room_service = ?");
            pst.setInt(1, 3);
            pst.setInt(2, id);


            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);


            alert.setHeaderText("Zadanie wykonane");

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getConnection();
        table();


    }


}