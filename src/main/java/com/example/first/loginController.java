package com.example.first;
import classes.CredentialsHandler;
import classes.database.Admin;
import classes.exceptions.AccountNotFoundException;
import classes.exceptions.InvalidCredentialsException;
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

public class loginController {
    @FXML
    private TextField userfield;
    @FXML
    private PasswordField passfield;

    @FXML


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Circle mycircle;
    private double x;
    private double y;
    public void up(ActionEvent e){
        mycircle.setCenterY(y=y-1);
    }

    public void down(ActionEvent e){
        mycircle.setCenterY(y=y+1);
    }
    public void right(ActionEvent e){
        mycircle.setCenterX(x=x+1);
    }
    public void left(ActionEvent e){
        mycircle.setCenterX(x=x-1);
    }

    public void login(ActionEvent event)throws Exception{

        String username = userfield.getText();
        String pass = passfield.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/home.fxml"));
        root = loader.load();

        homeController home = loader.getController();
        home.display(username,pass);
        //Parent root = FXMLLoader.load(getClass().getResource("/com/example/first/login.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
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