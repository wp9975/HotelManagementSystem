package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.MRoomService;
import com.iie.hotelms.reception.RoomGuest;
import com.iie.hotelms.reception.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

public class ReservationRoomServicesController implements Initializable {

    @FXML
    private TableColumn<RoomGuest, String> col2Guest;

    @FXML
    private TableColumn<RoomGuest, Integer> col2roomid;

    @FXML
    private TableColumn<RoomGuest, String> col2roomnumber;

    @FXML
    private TableColumn<RoomService, String> colDescription;

    @FXML
    private TableColumn<RoomService, Integer> colIdTask;

    @FXML
    private TableColumn<RoomService, String> colName;

    @FXML
    private TableColumn<RoomService, String> colRoomNumber;

    @FXML
    private TableColumn<RoomService, String> colStatus;

    @FXML
    private TableColumn<RoomService, String> colType;

    @FXML
    private TableColumn<RoomService, Integer> colWorker;

    @FXML
    private TableView<RoomService> table;

    @FXML
    private TableView<RoomGuest> table2;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtIdTask;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtIdRoom;


    @FXML
    private ChoiceBox txtType;


    PreparedStatement pst;

    int myIndex;

    public void table()
    {

        ObservableList<RoomService> rroomservices = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select room_service.id_room_service, room_service.name, room_service.description, room_service.status, room_service.id_department, room_service.id_room, room_service.id_room_service_type, room_service_types.name as typename, room.room_number from room_service join room on room_service.id_room=room.id_room join room_service_types on room_service.id_room_service_type=room_service_types.id_room_service_type;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    RoomService st = new RoomService();
                    st.setidRoomService(rs.getInt("id_room_service"));
                    st.setName(rs.getString("name"));
                    st.setDescription(rs.getString("description"));
                    st.setstatus(rs.getString("status"));
                    st.setIdDepartment(rs.getInt("id_department"));
                    st.setidRoom(rs.getInt("id_room"));
                    st.setidType(rs.getInt("id_room_service_type"));
                    st.settype(rs.getString("typename"));
                    st.setroomNumber(rs.getString("room_number"));
                    rroomservices.add(st);
                }
            }
            table.setItems(rroomservices);
            colIdTask.setCellValueFactory(f -> f.getValue().idRoomServiceProperty().asObject());
            colName.setCellValueFactory(f -> f.getValue().nameProperty());
            colDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
            colRoomNumber.setCellValueFactory(f -> f.getValue().roomNumberProperty());
            colType.setCellValueFactory(f -> f.getValue().typeProperty());
            colWorker.setCellValueFactory(f -> f.getValue().idWorkerProperty().asObject());
            colStatus.setCellValueFactory(f -> f.getValue().statusProperty());
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
                    txtIdTask.setText(String.valueOf(table.getItems().get(myIndex).getidRoomService()));
                    txtName.setText(table.getItems().get(myIndex).getName());
                    txtDescription.setText(table.getItems().get(myIndex).getDescription());
                    txtIdRoom.setText(String.valueOf(table.getItems().get(myIndex).getidRoom()));

                }
            });
            return myRow;
        });
    }

    public void table2()
    {

        ObservableList<RoomGuest> roomguest = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select reservation.id_guest, reservation.id_room, CONCAT(guest.first_name,\" \", guest.last_name) as name, room.room_number from reservation join guest on reservation.id_guest=guest.id_guest join room on reservation.id_room=room.id_room;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    RoomGuest st = new RoomGuest();
                    st.setIdRoom(rs.getInt("id_room"));
                    st.setRoomNumber(rs.getString("room_number"));
                    st.setName(rs.getString("name"));
                    st.setGuestId(rs.getInt("id_guest"));
                    roomguest.add(st);
                }
            }
            table2.setItems(roomguest);
            col2roomid.setCellValueFactory(f -> f.getValue().idRoomProperty().asObject());
            col2Guest.setCellValueFactory(f -> f.getValue().nameProperty());
            col2roomnumber.setCellValueFactory(f -> f.getValue().roomNumberProperty());

        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


        table2.setRowFactory( tv -> {
            TableRow<RoomGuest> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex = table2.getSelectionModel().getSelectedIndex();
                    txtIdRoom.setText(String.valueOf(table2.getItems().get(myIndex).getIdRoom()));

                }
            });
            return myRow;
        });
    }


    public void setServiceTypesChoiceBox(){

        try {
            pst = dbLink.prepareStatement("select name from room_service_types;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    txtType.getItems().add(rs.getString("name"));
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void add(ActionEvent event) {

        String name = txtName.getText();
        String description = txtDescription.getText();
        Integer id_room = Integer.valueOf(txtIdRoom.getText());
        Integer idDept = 3;

        String type = String.valueOf(txtType.getValue());
        int id_type = 1;

            try {
                pst = dbLink.prepareStatement("select id_room_service_type from room_service_types where name= ?;");
                pst.setString(1, type);
                ResultSet rs = pst.executeQuery();
                {
                    while (rs.next()) {
                        id_type = rs.getInt("id_room_service_type");

                    }
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
            }


        try{
            pst = dbLink.prepareStatement("insert into room_service(name,description,id_room,id_department,id_room_service_type) values(?,?,?,?,?)");

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setFloat(3, id_room);
            pst.setInt(4, idDept);
            pst.setInt(5, id_type);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Pomyślnie dodano!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void edit(ActionEvent event){

        Integer id_task = Integer.valueOf(txtIdTask.getText());
        String name = txtName.getText();
        String description = txtDescription.getText();
        Integer id_room = Integer.valueOf(txtIdRoom.getText());
        Integer idDept = 3;

        String type = String.valueOf(txtType.getValue());
        int id_type = 1;

        try {
            pst = dbLink.prepareStatement("select id_room_service_type from room_service_types where name= ?;");
            pst.setString(1, type);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    id_type = rs.getInt("id_room_service_type");

                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


        try{
            pst = dbLink.prepareStatement("update room_service set name = ?,description = ?,id_room = ? ,id_room_service_type=? where id_room_service = ?");

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setFloat(3, id_room);
            pst.setInt(4, id_type);
            pst.setInt(4, id_task);


            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Pomyślnie dodano!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void delete(ActionEvent event) {

        Integer id_task = Integer.valueOf(txtIdTask.getText());

        try
        {
            pst = dbLink.prepareStatement("delete from room_service where id_room_service = ? ");
            pst.setInt(1, id_task);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Pomyślnie usunięto");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setServiceTypesChoiceBox();
        table();
        table2();
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
