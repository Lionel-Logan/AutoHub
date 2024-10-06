package com.example.first;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class home_addentryController implements Initializable {


    @FXML
    private ImageView menuexit;

    @FXML
    private AnchorPane slider;

    @FXML
    private ImageView menu;
    @FXML
    private HBox showroombox;

    @FXML
    private HBox companybox;

    @FXML
    private AnchorPane addentrypane;
    @FXML
    private AnchorPane updateentrypane;

    @FXML
    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    private TextField idfield;
    @FXML
    private TextField namefield;
    @FXML
    private TextField ctypefield;
    @FXML
    private TextField etypefield;
    @FXML
    private TextField ttypefield;
    @FXML
    private TextField ftypefield;
    @FXML
    private TextField mileagefield;
    @FXML
    private TextField pricefield;
    @FXML
    private Button confirm;
    @FXML
    private Label message;


    ;

    public void initialize(URL location, ResourceBundle resources){
        //exit.setOnMouseClicked(event ->{
        //    System.exit(0);
        //});
        confirm.setDisable(true);
        showroombox.setVisible(true);;
        companybox.setVisible(false);
        slider.setTranslateX(-176);

        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(false);
                menuexit.setVisible(true);
            });
        });

        menuexit.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(true);
                menuexit.setVisible(false);
            });
        });

    }

    public void showroom(ActionEvent event){
        companybox.setVisible(false);
        showroombox.setVisible(true);
    }

    public void company(ActionEvent event){
        companybox.setVisible(true);
        showroombox.setVisible(false);
    }
    public void addentry(ActionEvent event)throws Exception{
        showroombox.setVisible(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/home_addentry.fxml"));
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

    public void updateentry(ActionEvent event)throws Exception{
        showroombox.setVisible(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/home_updateentry.fxml"));
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
    public void done(ActionEvent event)throws Exception{
            String id = idfield.getText();
            String name = namefield.getText();
            String cartype = ctypefield.getText();
            String enginetype = etypefield.getText();
            String transtype = ttypefield.getText();
            String fueltype = ftypefield.getText();
            String mileage = mileagefield.getText();
            String price = pricefield.getText();

            System.out.println("id="+id);
            if(id.equals("")  || name.equals("") || cartype.equals("") || enginetype.equals("") || transtype.equals("") || fueltype.equals("") || mileage.equals("")|| price.equals("")){
                confirm.setDisable(true);
                message.setText("enter all credentials");
            }
            else{
                confirm.setDisable(false);
                message.setText("confirm to add to database");
            }

    }



}
