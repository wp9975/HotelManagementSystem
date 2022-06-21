package com.iie.hotelms.controllers;

import com.iie.hotelms.admin.Room;
import com.iie.hotelms.services.Massage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.iie.hotelms.database.DatabaseConnection.dbLink;
import static com.iie.hotelms.database.DatabaseConnection.getConnection;


public class ReservationKindMassageController implements Initializable {

    @FXML
    private TableColumn<Massage, String> descriptionColumn;

    @FXML
    private TableColumn<Massage, Integer> idColumn;

    @FXML
    private TableColumn<Massage, String> nameColumn;

    @FXML
    private TableColumn<Massage, Float> priceColumn;

    @FXML
    private TableView<Massage> table;


    PreparedStatement pst;
    int myIndex;
    int id;

    public void table() {
        getConnection();


        ObservableList<Massage> masaze = FXCollections.observableArrayList();
        try {
            pst = dbLink.prepareStatement("select * from r_massages");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    Massage st = new Massage();
                    st.setId_massage(rs.getInt("id_masage"));
                    st.setName(rs.getString("name"));
                    st.setDescription(rs.getString("description"));
                    st.setPrice(rs.getFloat("price"));
                    masaze.add(st);
                }
            }
            table.setItems(masaze);
            idColumn.setCellValueFactory(f -> f.getValue().id_massageProperty().asObject());
            nameColumn.setCellValueFactory(f -> f.getValue().nameProperty());
            descriptionColumn.setCellValueFactory(f -> f.getValue().descriptionProperty());
            priceColumn.setCellValueFactory(f -> f.getValue().priceProperty().asObject());

        } catch (SQLException ex) {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getConnection();
        table();

    }





}
