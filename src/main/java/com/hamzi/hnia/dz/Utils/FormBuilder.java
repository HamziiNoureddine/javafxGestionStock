package com.hamzi.hnia.dz.Utils;

import com.hamzi.hnia.dz.Annotation.FXColumn;
import javafx.beans.property.Property;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;

public class FormBuilder {

    public static <T> void buildForm(GridPane grid, T model){

        int row = 0;

        for(Field field : model.getClass().getDeclaredFields()){

            if(field.isAnnotationPresent(FXColumn.class)){

                FXColumn ann = field.getAnnotation(FXColumn.class);

                Label label = new Label(ann.title());

                TextField textField = new TextField();

                try{
                    field.setAccessible(true);

                    Property<String> prop =
                            (Property<String>) field.get(model);

                    textField.textProperty().bindBidirectional(prop);

                }catch(Exception e){

                    e.printStackTrace();

                }

                grid.add(label,0,row);
                grid.add(textField,1,row);

                row++;
            }

        }

    }

}