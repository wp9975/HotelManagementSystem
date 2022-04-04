package com.iie.hotelms.controllers;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.iie.hotelms.HotelMS;


public class SplashController implements Initializable {
    private BorderPane pane;

    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HotelMS log = new HotelMS();
                try {
                    log.changeScene("/loginscreen.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        fadeTransition.play();
    }


}

