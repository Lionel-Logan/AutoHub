package com.example.first;

import classes.CredentialsHandler;
import classes.DatabaseHandler;
import classes.database.Car;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

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
        stage.centerOnScreen();
        stage.setResizable(false);



        stage.setScene(scenel);
        stage.show();
    }

    public static void main(String[] args) throws IOException, SQLException {
        launch();
        CredentialsHandler.initialize();

        /*
        DatabaseHandler.connectDatabase("root", "root", "Ford");

        Car car = new Car();
        car.Name = "Mustang";
        car.CarID = "86";
        car.Price = "140000";
        car.Mileage = "17";
        car.TransmissionType = "blah";
        car.EngineType = "run";
        car.CarType = "yum";
        car.FuelCapacity = "17999";

        DatabaseHandler.generateSQLQuery("AddCar", car);

        Vector<Car> cars = DatabaseHandler.retrieveCars("All");
        for(Car c : cars){
            System.out.println(c.CarID);
        }

        DatabaseHandler.disconnectDatabase();
        */
    }
}