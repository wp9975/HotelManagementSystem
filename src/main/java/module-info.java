module com.iie.hotelms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.iie.hotelms to javafx.fxml;
    exports com.iie.hotelms;
    exports com.iie.hotelms.controllers;
    opens com.iie.hotelms.controllers to javafx.fxml;
}