package com.example.first;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class signinController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void admin(ActionEvent event)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/signinadmin.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void user(ActionEvent event)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/signinuser.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void signup(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/login.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void signup_user_next(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/signup_user_final.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
