package com.hamzi.hnia.dz.Controllers;

import com.hamzi.hnia.dz.Utils.SwitchScenne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SwitchScenne switchScenne;

    private static final double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

    @FXML
    public void initialize(){
        ImageView loginImg = new ImageView("/Images/logon.png");
        loginImg.setFitWidth(40);
        loginImg.setFitHeight(40);
        logo.fitHeightProperty().bind(container.heightProperty());
        loginButton.setGraphicTextGap(15);
        loginButton.setGraphic(loginImg);
    }

    @FXML
    public void LogIn(ActionEvent e){

        try {
            Authentication  authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username.getText(),password.getText()));
            System.out.println("Authetication avec succees :"+authentication.getAuthorities());
            System.out.println(screenWidth+" : "+screenHeight);
            switchScenne.switchScenneFxml("main.fxml",screenWidth,screenHeight);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



        }
    }


