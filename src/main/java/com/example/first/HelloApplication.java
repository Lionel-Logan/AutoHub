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
        //System.out.println("JavaFX version: " + System.getProperty("javafx.runtime.version"));
        Parent rootl = FXMLLoader.load(getClass().getResource("/com/example/first/login.fxml"));
        //Group rooth = FXMLLoader.load(getClass().getResource("/com/example/first/home.fxml"));;
        //Scene sceneh = new Scene(rooth);//to create a scene
        Scene scenel = new Scene(rootl);

        //scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        String css = this.getClass().getResource("application.css").toExternalForm();
        scenel.getStylesheets().add(css);

        Image icon= new Image("navneet.png");
        //to change the icon (save the image in resourse)
        stage.getIcons().add(icon);

        stage.setTitle("AutoHub");
        stage.setWidth(400);
        stage.setHeight(600);

        stage.setResizable(false);

        //stage.setX(50);                               //to set where the stage appear on the screen
        //stage.setY(50);
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("you cant escape press enter");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("enter"));         //to set exit key

        /*Text text =new Text();
        text.setText("RENJISH \nAGE:LESS THAN NEEDED");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("verdana",30));

        Line line = new Line();     //add a line and its characters can be changed
        line.setStartX(400);
        line.setStartY(400);
        line.setEndX(200);
        line.setEndY(500);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        line.setRotate(45);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setHeight(50);
        rectangle.setWidth(30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.DARKBLUE);
        rectangle.setStrokeWidth(10);

        Polygon triangle =new Polygon();
        triangle.getPoints().setAll(
                200.0,200.0,
                300.0,300.0,
                200.0,300.0
        );
        triangle.setFill(Color.GREEN);

        Circle circle = new Circle();
        circle.setCenterX(500);
        circle.setCenterY(500);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);

        Image image =new Image("navneet.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(100);
        imageView.setY(100);
        */



        //rooth.getChildren().add(text);
        //rooth.getChildren().add(line);
        //rooth.getChildren().add(rectangle);
        //rooth.getChildren().add(triangle);
        //rooth.getChildren().add(circle);
        //rooth.getChildren().add(imageView);
        //stage.setScene(sceneh);

        stage.setScene(scenel);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}