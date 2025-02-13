package com.hamzi.hnia.dz;

import com.hamzi.hnia.dz.Utils.SwitchScenne;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class ReadyStageListenner implements ApplicationListener<ReadyStage> {

    private final ApplicationContext applicationContext;

    ReadyStageListenner(ApplicationContext applicationContext) {
        System.out.println("service created");
        this.applicationContext = applicationContext;
    }


    @Override
    public void onApplicationEvent(ReadyStage event) {

        try {

            Stage stage = event.getStage();
            stage.initStyle(StageStyle.UNDECORATED);
            SwitchScenne.primaryStage = stage;

            ClassPathResource resource = new ClassPathResource("Views/password.fxml");
            FXMLLoader loader=new FXMLLoader(resource.getURL());
            loader.setControllerFactory(applicationContext::getBean);
            Parent root = loader.load();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.getIcons().add(new Image("Images/img.png"));
            stage.setTitle("Login");
         //   stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
