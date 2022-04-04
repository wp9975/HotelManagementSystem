module com.iie.hotelms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.iie.hotelms to javafx.fxml;
    exports com.iie.hotelms;
}