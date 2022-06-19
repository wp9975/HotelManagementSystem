package com.iie.hotelms.controllers;

import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.RoomService;
import com.iie.hotelms.admin.Service;
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

public class AdminManageServicesController implements Initializable {

    @FXML
    private TableColumn<Service, String> columnDepartment;

    @FXML
    private TableColumn<Service, String> columnDescription;

    @FXML
    private TableColumn<Service, Integer> columnId;

    @FXML
    private TableColumn<Service, String> columnName;

    @FXML
    private TableColumn<Service, Float> columnPrice;

    @FXML
    private Pane paneb;

    @FXML
    private TableView<Service> table;

    @FXML
    private ChoiceBox txtDepartment;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    PreparedStatement pst;
    int myIndex;



    @FXML
    void add(ActionEvent event) {

        String name = txtName.getText();
        String description = txtDescription.getText();
        Float price = Float.valueOf(txtPrice.getText());

        String department = String.valueOf(txtDepartment.getValue());
        int idDept = 3;

                try {
                    pst = dbLink.prepareStatement("select id_department from departments where dept_name= ?;");
                    pst.setString(1, department);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            idDept = rs.getInt("id_department");

                        }
                    }
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

        try{
            pst = dbLink.prepareStatement("insert into services(name,description,price_hourly,id_department) values(?,?,?,?)");

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setFloat(3, price);
            pst.setInt(4, idDept);

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

        Integer id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getidService()));


        try
        {
            pst = dbLink.prepareStatement("delete from services where id_service = ? ");
            pst.setInt(1, id);
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

    @FXML
    void edit(ActionEvent event) {

        Integer id_service = Integer.valueOf(txtId.getText());
        String name = txtName.getText();
        String description = txtDescription.getText();
        Float price = Float.valueOf(txtPrice.getText());

        String department = String.valueOf(txtDepartment.getValue());
        int idDept = 3;

        try {
            pst = dbLink.prepareStatement("select id_department from departments where dept_name= ?;");
            pst.setString(1, department);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    idDept = rs.getInt("id_department");

                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        try{
            pst = dbLink.prepareStatement("update services SET name=?,description=? ,price_hourly=?,id_department=? where id_service=?");

            pst.setString(1, name);
            pst.setString(2, description);
            pst.setFloat(3, price);
            pst.setInt(4, idDept);
            pst.setInt(5, id_service);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Pomyślnie edytowano!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void table()
    {

        ObservableList<Service> services = FXCollections.observableArrayList();
        try
        {
            pst = dbLink.prepareStatement("select services.id_service, services.name, services.description, services.price_hourly, services.id_department , departments.dept_name from services join departments on services.id_department=departments.id_department;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Service st = new Service();
                    st.setidService(rs.getInt("id_service"));
                    st.setName(rs.getString("name"));
                    st.setDescription(rs.getString("description"));
                    st.setprice(rs.getFloat("price_hourly"));
                    st.setIdDepartment(rs.getInt("id_department"));
                    st.setDeptName(rs.getString("dept_name"));
                    services.add(st);
                }
            }
            table.setItems(services);
            columnId.setCellValueFactory(f -> f.getValue().idServiceProperty().asObject());
            columnName.setCellValueFactory(f -> f.getValue().nameProperty());
            columnDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
            columnPrice.setCellValueFactory(f -> f.getValue().priceProperty().asObject());
            columnDepartment.setCellValueFactory(f -> f.getValue().deptNameProperty());
        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Service> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex = table.getSelectionModel().getSelectedIndex();
                    txtId.setText(String.valueOf(table.getItems().get(myIndex).getidService()));
                    txtName.setText(table.getItems().get(myIndex).getName());
                    txtDescription.setText(table.getItems().get(myIndex).getDescription());
                    txtPrice.setText(String.valueOf(table.getItems().get(myIndex).getprice()));
                }
            });
            return myRow;
        });



    }


    public void setDepartmentChoiceBox(){

        try {
            pst = dbLink.prepareStatement("select id_department, dept_name from departments;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    txtDepartment.getItems().add(rs.getString("dept_name"));
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection.getConnection();
        table();
        setDepartmentChoiceBox();
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
}
