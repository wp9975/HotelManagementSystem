package com.iie.hotelms.controllers;

import com.iie.hotelms.database.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import com.iie.hotelms.admin.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import static javax.swing.JOptionPane.showMessageDialog;
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
    private TableColumn<Worker, String> IdColumn;

    @FXML
    private TableColumn<Worker, String> EmailColumn;

    @FXML
    private TableColumn<Worker, String> DeptColumn;

    @FXML
    private TableColumn<Worker, String> LastNameColumn;

    @FXML
    private TableColumn<Worker, String> NameColumn;

    @FXML
    private TableColumn<Worker, String> PhoneColumn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Pane paneb;

    @FXML
    private TableView<Worker> table;

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
        String department = String.valueOf(txtDepartment.getValue());
        int idDept = 1;

        try {

            pst = con.prepareStatement("select id_department from departments where dept_name= ?;");
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

        if(email.isEmpty() || haslo.isEmpty() || imie.isEmpty() || nazwisko.isEmpty() || telefon.isEmpty())
        {
            if(email.isEmpty()){ txtEmail.setStyle("-fx-border-color: red;"); }
            if(haslo.isEmpty()){ txtPassword.setStyle("-fx-border-color: red;"); }
            if(imie.isEmpty()){ txtName.setStyle("-fx-border-color: red;"); }
            if(nazwisko.isEmpty()){ txtLastName.setStyle("-fx-border-color: red;"); }
            if(telefon.isEmpty()){ txtPhone.setStyle("-fx-border-color: red;"); }

        }else if(telefon.length() !=9)
        {
            txtPhone.setStyle("-fx-border-color: red;");
            showMessageDialog(null, "Niepoprawny numer telefonu");
        }else if(email.matches("^(.+)@(.+)$") == false)
        {
            txtPhone.setStyle("-fx-border-color: red;");
            showMessageDialog(null, "Niepoprawny adres email @");
        }else
        {
            try {
                pst = con.prepareStatement("insert into workers(email,password,first_name,last_name,phone,id_department) values(?,?,?,?,?,?)");
                pst.setString(1, email);
                pst.setString(2, haslo);
                pst.setString(3, imie);
                pst.setString(4, nazwisko);
                pst.setString(5, telefon);
                pst.setInt(6, idDept);

                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setHeaderText("Dodano nowego pracownika");
                txtEmail.setStyle("-fx-border-color: green;");
                txtPassword.setStyle("-fx-border-color: green;");
                txtName.setStyle("-fx-border-color: green;");
                txtLastName.setStyle("-fx-border-color: green;");
                txtPhone.setStyle("-fx-border-color: green;");
                alert.showAndWait();

                table();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        }


    @FXML
    void Delete(ActionEvent event) {

        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));


        try
        {
            pst = con.prepareStatement("delete from workers where id_worker = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Usunięto pracownika");

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

        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String haslo = txtPassword.getText();
        String imie = txtName.getText();
        String nazwisko = txtLastName.getText();
        Integer id_worker = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        String department = String.valueOf(txtDepartment.getValue());
        int idDept = 1;

        try {
            pst = con.prepareStatement("select id_department from departments where dept_name= ?;");
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


        try
        {
            pst = con.prepareStatement("update workers set email = ?,password = ? ,first_name = ?, last_name = ?, phone = ?, id_department = ? where id_worker = ? ");
            pst.setString(1, email);
            pst.setString(2, haslo);
            pst.setString(3, imie);
            pst.setString(4, nazwisko);
            pst.setString(5, phone);
            pst.setInt(6, idDept);
            pst.setInt(7, id_worker);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Zmiany zostały wprowadzone");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    int id_dept;

    public void table()
    {
        Connect();
        ObservableList<Worker> pracownicy = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select id_worker, email, password, first_name, last_name, phone, workers.id_department , departments.dept_name from workers join departments on workers.id_department=departments.id_department");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Worker st = new Worker();
                    st.setId(rs.getInt("id_worker"));
                    st.setEmail(rs.getString("email"));
                    st.setPassword(rs.getString("password"));
                    st.setName(rs.getString("first_name"));
                    st.setLastname(rs.getString("last_name"));
                    st.setPhone(rs.getString("phone"));
                    st.setIdDepartment(rs.getInt("id_department"));
                    st.setDeptName(rs.getString("dept_name"));
                    pracownicy.add(st);
                }
            }
            table.setItems(pracownicy);
            EmailColumn.setCellValueFactory(f -> f.getValue().emailProperty());
            NameColumn.setCellValueFactory(f -> f.getValue().nameProperty());
            LastNameColumn.setCellValueFactory(f -> f.getValue().lastnameProperty());
            PhoneColumn.setCellValueFactory(f -> f.getValue().phoneProperty());
            IdColumn.setCellValueFactory(f -> f.getValue().idProperty().asString());
            DeptColumn.setCellValueFactory(f -> f.getValue().deptNameProperty());

        }

        catch (SQLException ex)
        {
            Logger.getLogger(AdminWorkerslistScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Worker> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    txtEmail.setText(table.getItems().get(myIndex).getEmail());
                    txtPassword.setText(table.getItems().get(myIndex).getPassword());
                    txtName.setText(table.getItems().get(myIndex).getName());
                    txtLastName.setText(table.getItems().get(myIndex).getLastname());
                    txtPhone.setText(table.getItems().get(myIndex).getPhone());
                    txtDepartment.setValue(table.getItems().get(myIndex).getDeptName());

                }
            });
            return myRow;
        });



    }


    public void setChoiceBox(){

        Connect();

        try {
            pst = con.prepareStatement("select id_department, dept_name from departments;");
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



    public Connection Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://hotel.mysql.database.azure.com:3306/hotelms", "root1", "ZAQ!2wsx");


        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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


        Connect();
        table();
        setChoiceBox();
    }


}
