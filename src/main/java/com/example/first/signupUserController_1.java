package com.example.first;
import classes.CredentialsHandler;
import classes.database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private ChoiceBox<String> u_role;
    @FXML
    private String sexa[]={"male","female"};
    @FXML
    private String role[]={"manager","user"};
    @FXML
    private Button confirm;

    @FXML
    private Label message;

    String sex;

    String rol;

    public void initialize(URL arg0, ResourceBundle arg1){
        confirm.setDisable(true);
        u_sexfield.getItems().addAll(sexa);
        u_sexfield.setOnAction(this::getsex);
        u_role.getItems().addAll(role);
        u_role.setOnAction(this::getrole);
    }

    public void getsex(ActionEvent event){
        sex = u_sexfield.getValue();

    }
    public void getrole(ActionEvent event){
        rol = u_role.getValue();

    }
    public void signup_user_next(ActionEvent event)throws Exception{

        String username = u_userfield.getText();
        String companyname = u_namefield.getText();
        String password = u_passfield.getText();
        String age = u_agefield.getText();
        String residence = u_residencefield.getText();


        if(username.equals("")  || companyname.equals("") || password.equals("") || age.equals("") || residence.equals("") ){
            confirm.setDisable(true);
            message.setText("enter all credentials");
        }
        else{
            confirm.setDisable(false);
            message.setText("confirm to add to database");
        }

    }

    public void signup(ActionEvent event)throws Exception{

        String username = u_userfield.getText();
        String companyname = u_namefield.getText();
        String password = u_passfield.getText();
        String age = u_agefield.getText();
        String residence = u_residencefield.getText();

        User user_object = new User();
        user_object.Username=username;
        user_object.CompanyName=companyname;
        user_object.Password=password;
        user_object.Age=age;
        user_object.Place=residence;
        user_object.Sex=sex;
        if(rol=="manager"){
            user_object.IsManager=true;
        }
        else {
            user_object.IsManager=false;
        }
        CredentialsHandler.signUpAsUser(user_object);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/login.fxml"));
        root = loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }



}
