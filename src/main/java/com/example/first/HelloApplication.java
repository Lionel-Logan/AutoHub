package com.example.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.shape.Line;
import javafx.scene.shape.*;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent rootl = FXMLLoader.load(getClass().getResource("/com/example/first/login.fxml"));
        Scene scenel;
        scenel = new Scene(rootl);

        //scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        String css = this.getClass().getResource("application.css").toExternalForm();
        scenel.getStylesheets().add(css);

        Image icon= new Image("navneet.png");
        stage.getIcons().add(icon);

        stage.setTitle("AutoHub");
        stage.setWidth(400);
        stage.setHeight(600);

        stage.setResizable(false);



        stage.setScene(scenel);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}