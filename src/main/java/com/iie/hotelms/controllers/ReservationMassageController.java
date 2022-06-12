package com.iie.hotelms.controllers;

import com.iie.hotelms.reception.CheckOutTable;
import com.iie.hotelms.services.Client;
import com.iie.hotelms.services.MassageReservation;
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

public class ReservationMassageController implements Initializable {



    @FXML
    private TableColumn<MassageReservation, Integer> columnClientID;

    @FXML
    private TableColumn<MassageReservation, String> columnDate;

    @FXML
    private TableColumn<MassageReservation, Integer> columnID;

    @FXML
    private TableColumn<MassageReservation, String> columnLastName;

    @FXML
    private TableColumn<MassageReservation, String> columnName;

    @FXML
    private TableColumn<MassageReservation, String> columnStart;

    @FXML
    private TableColumn<MassageReservation, String> columnType;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Client, Integer> guestIdColumn;

    @FXML
    private TableColumn<Client, String> guestLastNameColumn;

    @FXML
    private TableColumn<Client, String> guestNameColumn;

    @FXML
    private Label kind;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableView<MassageReservation> table;

    @FXML
    private TextField txtClient;

    @FXML
    private DatePicker txtDate;

    @FXML
    private ComboBox<?> txtStartHour;

    @FXML
    private ChoiceBox<?> txtType;


    int myIndex;
    int myIndex2;
    PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getConnection();
        clientTable();
        table();

    }

    public void clientTable(){
        getConnection();
        ObservableList<Client> klienci = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select id_guest, first_name, last_name from guest;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Client st = new Client();
                    st.setId_guest(rs.getInt("id_guest"));
                    st.setName(rs.getString("first_name"));
                    st.setLastName(rs.getString("last_name"));

                    klienci.add(st);
                }
            }
            clientTable.setItems(klienci);
            guestIdColumn.setCellValueFactory(f -> f.getValue().id_guestProperty().asObject());
            guestNameColumn.setCellValueFactory(f -> f.getValue().nameProperty());
            guestLastNameColumn.setCellValueFactory(f -> f.getValue().lastNameProperty());


        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }





        clientTable.setRowFactory( tv -> {
            TableRow<Client> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  clientTable.getSelectionModel().getSelectedIndex();
                    txtClient.setText(String.valueOf(clientTable.getItems().get(myIndex).getId_guest()));
                }
            });
            return myRow;
        });
    }

    public void table()
    {
        getConnection();
        ObservableList<MassageReservation> rezerwacje = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("SELECT \n" +
                    "    `r_massages_reservation`.`id_massages_reservation`,\n" +
                    "    `r_massages_reservation`.`date`,\n" +
                    "    `r_massages_reservation`.`start_hour`,\n" +
                    "    `r_massages_reservation`.`end_hour`,\n" +
                    "    `r_massages_reservation`.`price`,\n" +
                    "    `r_massages_reservation`.`id_worker`,\n" +
                    "    `r_massages_reservation`.`id_massage`,\n" +
                    "    `r_massages_reservation`.`id_guest`,\n" +
                    "    guest.first_name,\n" +
                    "    guest.last_name,\n" +
                    "    r_massages.id_masage,\n" +
                    "    r_massages.name\n" +
                    "FROM\n" +
                    "    `hotelms`.`r_massages_reservation`\n" +
                    "        JOIN\n" +
                    "    guest ON r_massages_reservation.id_guest = guest.id_guest\n" +
                    "        JOIN\n" +
                    "    r_massages ON r_massages_reservation.id_massage = r_massages.id_masage\n" +
                    ";");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    MassageReservation st = new MassageReservation();
                    st.setId_massages_reservation(rs.getInt("id_massages_reservation"));
                    st.setType(rs.getString("name"));
                    st.setDate(String.valueOf(rs.getDate("date")));
                    st.setStart(String.valueOf(rs.getTime("start_hour")));
                    st.setName(rs.getString("first_name"));
                    st.setLastName(rs.getString("last_name"));
                    st.setId_guest(rs.getInt("id_guest"));
                    rezerwacje.add(st);
                }
            }
            table.setItems(rezerwacje);
            columnID.setCellValueFactory(f -> f.getValue().id_massages_reservationProperty().asObject());
            columnType.setCellValueFactory(f -> f.getValue().typeProperty());
            columnDate.setCellValueFactory(f -> f.getValue().dateProperty());
            columnStart.setCellValueFactory(f -> f.getValue().startProperty());
            columnName.setCellValueFactory(f -> f.getValue().nameProperty());
            columnLastName.setCellValueFactory(f -> f.getValue().lastNameProperty());
            columnClientID.setCellValueFactory(f -> f.getValue().id_guestProperty().asObject());


        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<MassageReservation> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex2 =  table.getSelectionModel().getSelectedIndex();
                    txtClient.setText(String.valueOf(table.getItems().get(myIndex2).getId_guest()));
                }
            });
            return myRow;
        });
    }



    public void Add(ActionEvent event) {
    }

    public void Search(ActionEvent event) {
    }

    public void Update(ActionEvent event) {
    }

    public void Delete(ActionEvent event) {
    }
}
