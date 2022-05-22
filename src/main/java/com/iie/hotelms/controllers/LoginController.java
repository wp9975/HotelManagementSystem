package com.iie.hotelms.controllers;

import com.iie.hotelms.DatabaseConnection;
import com.iie.hotelms.HotelMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.iie.hotelms.DatabaseConnection.dbLink;

public class LoginController implements Initializable {

    public LoginController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrong;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label showname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection.getConnection();

    }

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        HotelMS log = new HotelMS();
        String email;
        PreparedStatement statement;
        ResultSet rs;

        try {
                email = username.getText();
                statement = dbLink.prepareStatement("select password, id_department from workers where email=?");
                statement.setString(1,email);
                rs = statement.executeQuery();

                if (!rs.isBeforeFirst()){
                    System.out.println("Bark maila w bazie");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Niepoprawne dane");
                    alert.show();
                }
                else {
                    while (rs.next()){
                        String retrivedPassword = rs.getString("password");
                        Integer id_department = rs.getInt("id_department");
                        if(retrivedPassword.equals(password.getText())){
                            if(id_department == 1){
                                log.changeScene("/admin/adminscreen.fxml");
                            }
                            else if(id_department == 2){
                                log.changeScene("/reception/receptionscreen.fxml");
                            }
                            else{
                                log.changeScene("/workers/workersscreen.fxml");
                            }
                        }
                        else{
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Niepoprawne dane");
                            alert.show();
                        }
                    }
                }
            }
        catch (SQLException e){
            e.printStackTrace();
        }



    }




}
