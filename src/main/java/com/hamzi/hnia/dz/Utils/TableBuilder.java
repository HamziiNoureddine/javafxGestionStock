package com.hamzi.hnia.dz.Utils;

import com.hamzi.hnia.dz.Annotation.FXColumn;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

public class TableBuilder {

    public static <T> void build(TableView<T> table,Class<T> clazz){

        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream( fields)
                .filter(f->f.isAnnotationPresent(FXColumn.class))
                .sorted(Comparator.comparingInt(
                        f->f.getAnnotation(FXColumn.class).order()
                ))
                .forEach(field -> {
                    FXColumn annotations = field.getAnnotation(FXColumn.class);
                    TableColumn<T,Object> column =
                            new TableColumn<>(annotations.title());

                    column.setCellValueFactory(param->{
                        try {

                            field.setAccessible(true);

                            Property<?> prop =
                                    (Property<?>) field.get(param.getValue());

                            return (ObservableValue<Object>) prop;

                        } catch (Exception e) {

                            e.printStackTrace();
                            return null;

                        }
                    });
                    table.getColumns().add(column);
                });
    }
}
