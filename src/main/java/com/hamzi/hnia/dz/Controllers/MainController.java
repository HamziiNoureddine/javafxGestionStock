package com.hamzi.hnia.dz.Controllers;

import com.hamzi.hnia.dz.Utils.SwitchScenne;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
    @FXML
    private BorderPane borderpane;
    @FXML
    private JFXButton dashbord;
    private double childPosition;
    @FXML
    private VBox centerContainer;
    private AnchorPane child;
    @Autowired
    private SwitchScenne switchScenne;
    boolean isMenu = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        closeIcon.setOnMouseClicked(event->{
               System.exit(0);
        });
        slider.setTranslateX(-300);
        Menu.setOnMouseClicked(e->{

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.7));

            TranslateTransition Childslide = new TranslateTransition();
            Childslide.setDuration(Duration.seconds(0.7));

            slide.setNode(slider);
            Childslide.setNode(child);
            if (isMenu){
                slide.setToX(0);
                slide.play();
                slider.setTranslateX(-300);

                switchScenne.slideTransitioinChild(child,Childslide,slider.getWidth(),childPosition,true);

            } else {
                slide.setToX(-300);
                slide.play();
                slider.setTranslateX(0);
                switchScenne.slideTransitioinChild(child,Childslide,slider.getWidth(),childPosition,false);


            }
           isMenu=!isMenu;
        });


    }
    @FXML
    public void loadParent(ActionEvent e) throws IOException {centerContainer.getChildren().clear();
    child = (AnchorPane) switchScenne.getNodeFxml("adduser.fxml");
    childPosition = child.getLayoutX();
    child.prefWidthProperty().bind(centerContainer.widthProperty());
    child.prefHeightProperty().bind(centerContainer.heightProperty());
    centerContainer.getChildren().add(child);


    }


}
