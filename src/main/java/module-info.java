module com.iie.hotelms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires PDFGenerate;
    requires java.desktop;
    requires org.testng;


    opens com.iie.hotelms to javafx.fxml;
    exports com.iie.hotelms;
    exports com.iie.hotelms.controllers;
    opens com.iie.hotelms.controllers to javafx.fxml;
    exports com.iie.hotelms.database;
    opens com.iie.hotelms.database to javafx.fxml;
}