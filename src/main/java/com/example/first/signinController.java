package com.example.first;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class signinController{

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField a_userfield;
    @FXML
    private PasswordField a_passfield;
    @FXML
    private TextField a_cmp_namefield;

    public void admin(ActionEvent event)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/signinadmin.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();

        scene=new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void user(ActionEvent event)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/signinuser.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void signup(ActionEvent event)throws Exception{
        String username= a_userfield.getText();
        String password= a_passfield.getText();
        String company_name=a_cmp_namefield.getText();

        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("companyname="+company_name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/login.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
