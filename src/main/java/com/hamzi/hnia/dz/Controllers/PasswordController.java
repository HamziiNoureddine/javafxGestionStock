package com.hamzi.hnia.dz.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Controller;



@Controller
public class PasswordController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView logo;
    @FXML
    private BorderPane container;

    @FXML
    public void initialize(){
        ImageView loginImg = new ImageView("/Images/logon.png");
        loginImg.setFitWidth(40);
        loginImg.setFitHeight(40);
        logo.fitHeightProperty().bind(container.heightProperty());
        loginButton.setGraphicTextGap(15);
        loginButton.setGraphic(loginImg);
    }

}
