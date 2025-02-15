package com.hamzi.hnia.dz.Controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {
    @FXML
    private ImageView closeIcon;
    @FXML
    private Label Menu;
    @FXML
    private AnchorPane slider;
    boolean isMenu = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        closeIcon.setOnMouseClicked(event->{

            System.exit(0);
        });

        Menu.setOnMouseClicked(e->{

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.7));
            slide.setNode(slider);
            if (isMenu){
                slide.setToX(-300);
                slide.play();
                slider.setTranslateX(0);
            } else {
                slide.setToX(0);
                slide.play();
                slider.setTranslateX(-300);
            }
           isMenu=!isMenu;
        });


    }
}
