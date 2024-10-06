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

public class signupUserController_final {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField companyfield;

    @FXML
    private TextField showroomfield;
    @FXML
    private TextField departmentfield;

    public void signup_user(ActionEvent event)throws Exception{
        String companyname = companyfield.getText();
        String  showroomname = showroomfield.getText();
        String department = departmentfield.getText();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/example/first/login.fxml"));
        root=loader.load();
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
