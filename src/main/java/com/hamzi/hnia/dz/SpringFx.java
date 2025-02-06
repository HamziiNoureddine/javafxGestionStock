package com.hamzi.hnia.dz;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;


public class SpringFx extends Application {

    private ConfigurableApplicationContext applicationContext;



    @Override
    public void init() throws Exception {

        ApplicationContextInitializer<GenericApplicationContext> initializer = (e) -> {
            e.registerBean(Application.class, ()-> SpringFx.this);
            e.registerBean(Parameters.class, this::getParameters);
            e.registerBean(HostServices.class,this::getHostServices);
        };

        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpringApplicationStock.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext.publishEvent(new ReadyStage(stage));
    }

    @Override
    public void stop() throws Exception {
        applicationContext.stop();
        Platform.exit();
    }
}

class ReadyStage extends ApplicationEvent{

   public Stage getStage(){
       return (Stage) getSource();
   }
    public ReadyStage(Stage source) {
        super(source);

        }
}
