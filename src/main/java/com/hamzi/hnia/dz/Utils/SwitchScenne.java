package com.hamzi.hnia.dz.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class SwitchScenne {

    public static Stage primaryStage;

    @Autowired
    private ApplicationContext applicationContext;

    public  void switchScenneFxml(String filename,double width,double height) throws IOException {

        Resource resource = new ClassPathResource("Views/"+filename);
        FXMLLoader fxmlLoader = new FXMLLoader(resource.getURL());
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setScene(scene);
      centerStage();
    }

    public void centerStage(){
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        double stageWidth = primaryStage.getWidth();
        double stageHeight = primaryStage.getHeight();

        primaryStage.setX((screenWidth - stageWidth)/2);
        primaryStage.setY((screenHeight - stageHeight)/2);
        primaryStage.show();
    }

}
