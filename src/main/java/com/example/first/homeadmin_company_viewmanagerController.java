package com.example.first;
import classes.DatabaseHandler;
import classes.database.Employee;
import classes.database.Manager;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class homeadmin_company_viewmanagerController implements Initializable {


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
    private TableView<Manager> table;
    @FXML
    private TableColumn<Manager,String> id;
    @FXML
    private TableColumn<Manager,String> name;

    @FXML
    private TableColumn<Manager,String> age;

    @FXML
    private TableColumn<Manager,String> sex;

    @FXML
    private TableColumn<Manager, String> place;

    @FXML
    private TableColumn<Manager, Button> imageview;




            ;

    public void initialize(URL location, ResourceBundle resources){
        //exit.setOnMouseClicked(event ->{
        //    System.exit(0);
        //});

        try {
            ObservableList<Manager> list = DatabaseHandler.retrieveManagers("All");
            id.setCellValueFactory(new PropertyValueFactory<Manager, String>("ID"));
            name.setCellValueFactory(new PropertyValueFactory<Manager, String>("Name"));
            age.setCellValueFactory(new PropertyValueFactory<Manager, String>("Age"));
            sex.setCellValueFactory(new PropertyValueFactory<Manager, String>("sex"));
            place.setCellValueFactory(new PropertyValueFactory<Manager, String>("place"));
            imageview.setCellValueFactory(new PropertyValueFactory<Manager, Button>("button"));

            for (int i = 0; i < list.size(); i++) {
                Button button = list.get(i).getButton();
                button.setText("DELETE");
                int finalI = i;
                button.setOnAction(event -> {
                    try {
                        DatabaseHandler.generateSQLQuery("DeleteManager", list.get(finalI).ID);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_company_viewmanagers.fxml"));
                        root = loader.load();

                        //homeController home = loader.getController();
                        //home.display(username,pass);
                        //Parent root = FXMLLoader.load(getClass().getResource("/com/example/first/login.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setWidth(1100);
                        stage.setHeight(700);
                        stage.centerOnScreen();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            //table.isEditable();
            table.setSelectionModel(null);
            //table.getSelectionModel().setSelectionMode(null);
            table.setItems(list);
        }
        catch (Exception e){

        }
        slider.setTranslateX(0);

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

    public void showroom(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_showroom_addentry.fxml"));
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

    public void account(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_account.fxml"));
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


    public void company_viewemployee(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_company_viewemployee.fxml"));
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

    public void viewmanagers(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_company_viewmanagers.fxml"));
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

    public void managecompany(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_company_managecompany.fxml"));
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








}



