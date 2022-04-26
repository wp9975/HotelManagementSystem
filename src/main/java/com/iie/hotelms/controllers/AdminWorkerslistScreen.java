package com.iie.hotelms.controllers;

import com.iie.hotelms.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Pracownik;
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

public class AdminWorkerslistScreen implements Initializable {

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();


    @FXML
    private TableColumn<Pracownik, String> IdColumn;

    @FXML
    private TableColumn<Pracownik, String> EmailColumn;

    @FXML
    private TableColumn<Pracownik, String> LastNameColumn;

    @FXML
    private TableColumn<Pracownik, String> NameColumn;

    @FXML
    private TableColumn<Pracownik, String> PhoneColumn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Pane paneb;

    @FXML
    private TableView<Pracownik> table;

    @FXML
    private ChoiceBox txtDepartment;


    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLastName;


    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    void Add(ActionEvent event) {
        String email = txtEmail.getText();
        String haslo = txtPassword.getText();
        String imie = txtName.getText();
        String nazwisko = txtLastName.getText();
        String telefon = txtPhone.getText();


        try{
            pst = con.prepareStatement("insert into workers(email,password,first_name,last_name,phone,id_department) values(?,?,?,?,?,1)");
            pst.setString(1, email);
            pst.setString(2, haslo);
            pst.setString(3, imie);
            pst.setString(4, nazwisko);
            pst.setString(5, telefon);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registation");

            alert.setHeaderText("Student Registation");
            alert.setContentText("Record Addedddd!");

            alert.showAndWait();

            table();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void Delete(ActionEvent event) {

        String phone = String.valueOf(table.getItems().get(myIndex).getTelefon());


        try
        {
            pst = con.prepareStatement("delete from pracownicy where telefon = ? ");
            pst.setString(1, phone);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registationn");

            alert.setHeaderText("Student Registation");
            alert.setContentText("Deletedd!");

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




        String phone = String.valueOf(table.getItems().get(myIndex).getTelefon());

        String email = txtEmail.getText();
        String haslo = txtPassword.getText();
        String imie = txtName.getText();
        String nazwisko = txtLastName.getText();
        String id_worker = String.valueOf(table.getItems().get(myIndex).getId());

        try
        {
            pst = con.prepareStatement("update workers set email = ?,password = ? ,first_name = ?, last_name = ?, phone = ? where id_worker = ? ");
            pst.setString(1, email);
            pst.setString(2, haslo);
            pst.setString(3, imie);
            pst.setString(4, nazwisko);
            pst.setString(5, phone);
            pst.setString(6, id_worker);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registationn");

            alert.setHeaderText("Student Registation");
            alert.setContentText("Updateddd!");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
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

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    public void table()
    {
        Connect();
        ObservableList<Pracownik> pracownicy = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select id_worker, email, password, first_name, last_name, phone, id_department from workers");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Pracownik st = new Pracownik();
                    st.setId(rs.getInt("id_worker"));
                    st.setEmail(rs.getString("email"));
                    st.setPassword(rs.getString("password"));
                    st.setImie(rs.getString("first_name"));
                    st.setNazwisko(rs.getString("last_name"));
                    st.setTelefon(rs.getString("phone"));


                    pracownicy.add(st);
                }
            }
            table.setItems(pracownicy);
            EmailColumn.setCellValueFactory(f -> f.getValue().emailProperty());
            NameColumn.setCellValueFactory(f -> f.getValue().imieProperty());
            LastNameColumn.setCellValueFactory(f -> f.getValue().nazwiskoProperty());
            PhoneColumn.setCellValueFactory(f -> f.getValue().telefonProperty());
            IdColumn.setCellValueFactory(f -> f.getValue().idProperty().asString());


        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Pracownik> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    txtEmail.setText(table.getItems().get(myIndex).getEmail());
                    txtPassword.setText(table.getItems().get(myIndex).getPassword());
                    txtName.setText(table.getItems().get(myIndex).getImie());
                    txtLastName.setText(table.getItems().get(myIndex).getNazwisko());
                    txtPhone.setText(table.getItems().get(myIndex).getTelefon());


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
        table();
    }


}
