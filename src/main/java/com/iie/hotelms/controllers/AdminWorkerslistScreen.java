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
    private TableColumn<Pracownik, String> AddressColumn;

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
    private TextField txtAddress;

    @FXML
    private DatePicker txtBirthday;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    void Add(ActionEvent event) {
        String login = txtLogin.getText();
        String haslo = txtPassword.getText();
        String imie = txtName.getText();
        String nazwisko = txtLastName.getText();
        String adres = txtAddress.getText();
        String telefon = txtPhone.getText();
        String email = txtEmail.getText();
        String data_urodzenia = "1992-02-22";

        try{
            pst = con.prepareStatement("insert into pracownicy(login,haslo,imie,nazwisko,adres_zamieszkania,telefon,data_urodzenia,email) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, login);
            pst.setString(2, haslo);
            pst.setString(3, imie);
            pst.setString(4, nazwisko);
            pst.setString(5, adres);
            pst.setString(6, telefon);
            pst.setString(7, data_urodzenia);
            pst.setString(8, email);
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

        String login = txtLogin.getText();
        String haslo = txtPassword.getText();
        String imie = txtName.getText();
        String nazwisko = txtLastName.getText();
        String adres = txtAddress.getText();

        String email = txtEmail.getText();
        String data_urodzenia = "1993-02-06";

        try
        {
            pst = con.prepareStatement("update pracownicy set login = ?,haslo = ? ,imie = ?, nazwisko = ?, adres_zamieszkania = ?, email = ?, data_urodzenia = ? where telefon = ? ");
            pst.setString(1, login);
            pst.setString(2, haslo);
            pst.setString(3, imie);
            pst.setString(4, nazwisko);
            pst.setString(5, adres);
            pst.setString(6, email);
            pst.setString(7, data_urodzenia);
            pst.setString(8, phone);
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
            pst = con.prepareStatement("select id_pracownika, login, haslo, imie, nazwisko, adres_zamieszkania, telefon, email from pracownicy");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Pracownik st = new Pracownik();
                    st.setLogin(rs.getString("login"));
                    st.setHaslo(rs.getString("haslo"));
                    st.setImie(rs.getString("imie"));
                    st.setNazwisko(rs.getString("nazwisko"));
                    st.setAdres(rs.getString("adres_zamieszkania"));
                    st.setTelefon(rs.getString("telefon"));
                    st.setEmail(rs.getString("email"));
                    pracownicy.add(st);
                }
            }
            table.setItems(pracownicy);
            NameColumn.setCellValueFactory(f -> f.getValue().imieProperty());
            LastNameColumn.setCellValueFactory(f -> f.getValue().nazwiskoProperty());
            AddressColumn.setCellValueFactory(f -> f.getValue().adresProperty());
            PhoneColumn.setCellValueFactory(f -> f.getValue().telefonProperty());
            EmailColumn.setCellValueFactory(f -> f.getValue().emailProperty());

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
                    txtLogin.setText(table.getItems().get(myIndex).getLogin());
                    txtPassword.setText(table.getItems().get(myIndex).getHaslo());
                    txtName.setText(table.getItems().get(myIndex).getImie());
                    txtLastName.setText(table.getItems().get(myIndex).getNazwisko());
                    txtAddress.setText(table.getItems().get(myIndex).getAdres());
                    txtPhone.setText(table.getItems().get(myIndex).getTelefon());
                    txtEmail.setText(table.getItems().get(myIndex).getEmail());

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
