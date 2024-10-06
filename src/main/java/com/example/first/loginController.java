package com.example.first;
import classes.CredentialsHandler;
import classes.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.xml.stream.events.DTD;


public class loginController {
    @FXML
    private TextField userfield;
    @FXML
    private PasswordField passfield;
    @FXML
    private TextField mysqluserfield;
    @FXML
    private PasswordField mysqlpassfield;
    @FXML
    private TextField portno;
    @FXML
    public Stage stage;
    public Scene scene;
    public Parent root;


    public void login(ActionEvent event)throws Exception{

        String username = userfield.getText();
        String pass = passfield.getText();
        String mysqlusername = mysqluserfield.getText();
        String mysqlpass = mysqlpassfield.getText();
        String port = portno.getText();
        //String companyname = CredentialsHandler.login(username,pass);
        //DatabaseHandler.connectDatabase(mysqlusername,mysqlpass,companyname);



        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/home.fxml"));
        root = loader.load();

        //homeController home = loader.getController();
        //home.display(username,pass);
        //Parent root = FXMLLoader.load(getClass().getResource("/com/example/first/login.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.centerOnScreen();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void signin(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/admin_user.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);

        stage.setScene(scene);
        stage.show();
    }


}