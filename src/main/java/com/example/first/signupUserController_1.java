package com.example.first;
import classes.database.User;
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
public class signupUserController_1 implements Initializable{

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField u_userfield;
    @FXML
    private TextField u_namefield;
    @FXML
    private TextField u_agefield;
    @FXML
    private TextField u_residencefield;
    @FXML
    private PasswordField u_passfield;
    @FXML
    private ChoiceBox<String> u_sexfield;
    @FXML
    private String sexa[]={"male","female"};

    String sex;
    @FXML
    private TextField companyfield;

    @FXML
    private TextField showroomfield;
    @FXML
    private TextField departmentfield;

    public void initialize(URL arg0, ResourceBundle arg1){
        u_sexfield.getItems().addAll(sexa);
        u_sexfield.setOnAction(this::getsex);
    }

    public void getsex(ActionEvent event){
        sex = u_sexfield.getValue();

    }
    public void signup_user_next(ActionEvent event)throws Exception{

        String username = u_userfield.getText();
        String name = u_namefield.getText();
        String password = u_passfield.getText();
        String age = u_agefield.getText();
        String residence = u_residencefield.getText();

        User user_object = new User();
        user_object.Username=username;
        user_object.Password=password;
        user_object.name=name;
        user_object.Age=age;
        user_object.Place=residence;
        user_object.Sex=sex;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/signup_user_final.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }



}
