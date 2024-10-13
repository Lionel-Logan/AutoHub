package com.example.first;
import classes.DatabaseHandler;
import classes.database.Car;
import classes.database.Employee;
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

public class homeadmin_company_viewempployeeController implements Initializable {


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
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee,String> id;
    @FXML
    private TableColumn<Employee,String> name;

    @FXML
    private TableColumn<Employee,String> age;

    @FXML
    private TableColumn<Employee,String> sex;

    @FXML
    private TableColumn<Employee, String> place;

    @FXML
    private TableColumn<Employee, Button> imageview;


            ;

    public void initialize(URL location, ResourceBundle resources){
        //exit.setOnMouseClicked(event ->{
        //    System.exit(0);
        //});
        try {
            ObservableList<Employee> list = DatabaseHandler.retrieveEmployees("All");
            id.setCellValueFactory(new PropertyValueFactory<Employee,String>("ID"));
            name.setCellValueFactory(new PropertyValueFactory<Employee,String>("Name"));
            age.setCellValueFactory(new PropertyValueFactory<Employee,String>("Age"));
            sex.setCellValueFactory(new PropertyValueFactory<Employee,String>("sex"));
            place.setCellValueFactory(new PropertyValueFactory<Employee,String>("place"));
            imageview.setCellValueFactory(new PropertyValueFactory<Employee, Button>("button"));

            for(int i = 0; i < list.size(); i++) {
                Button button = list.get(i).getButton();
                button.setText("DELETE");
                int finalI = i;
                button.setOnAction(event -> {
                    try {
                        DatabaseHandler.generateSQLQuery("DeleteEmployee", list.get(finalI).ID);
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



