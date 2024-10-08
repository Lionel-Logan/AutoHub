package com.example.first;
import classes.DatabaseHandler;
import classes.database.Car;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TableColumn;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;

public class homeadmin_showroom_viewcontentController implements Initializable {


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
    private TableView<Car> table;
    @FXML
    private TableColumn<Car,String> id;

    @FXML
    private TableColumn<Car,String> name;

    @FXML
    private TableColumn<Car,String> type;

    @FXML
    private TableColumn<Car, String> engine;

    @FXML
    private TableColumn<Car, String> transmission;

    @FXML
    private TableColumn<Car, String> fuel;

    @FXML
    private TableColumn<Car, String> mileage;

    @FXML
    private TableColumn<Car, String> price;

    ObservableList<Car> list =FXCollections.observableArrayList(
         new Car("12","AUDI","WEWF","V8","EFDSF","ADASA","PETROL","45"),
    new Car("12","AUDI","WEWF","V8","EFDSF","ADASA","PETROL","45")
    );

    public void initialize(URL location, ResourceBundle resources) {
        //exit.setOnMouseClicked(event ->{
        //    System.exit(0);
        //});

        id.setCellValueFactory(new PropertyValueFactory<Car,String>("CarID"));
        name.setCellValueFactory(new PropertyValueFactory<Car,String>("Name"));
        type.setCellValueFactory(new PropertyValueFactory<Car,String>("CarType"));
        engine.setCellValueFactory(new PropertyValueFactory<Car,String>("EngineType"));
        transmission.setCellValueFactory(new PropertyValueFactory<Car,String>("TransmissionType"));
        fuel.setCellValueFactory(new PropertyValueFactory<Car,String>("FuelCapacity"));
        mileage.setCellValueFactory(new PropertyValueFactory<Car,String>("Mileage"));
        price.setCellValueFactory(new PropertyValueFactory<Car,String>("Price"));
        //table.isEditable();
        table.setSelectionModel(null);
        //table.getSelectionModel().setSelectionMode(null);
        table.setItems(list);

        showroombox.setVisible(true);;
        companybox.setVisible(false);
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
        companybox.setVisible(false);
        showroombox.setVisible(true);
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

    public void company(ActionEvent event){
        companybox.setVisible(true);
        showroombox.setVisible(false);
    }
    public void addentry(ActionEvent event)throws Exception{
        showroombox.setVisible(true);
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

    public void updateentry(ActionEvent event)throws Exception{
        showroombox.setVisible(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_showroom_updateentry.fxml"));
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

    public void viewcontent(ActionEvent event)throws Exception{
        showroombox.setVisible(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/first/homeadmin_showroom_viewcontent.fxml"));
        root = loader.load();
        System.out.println("viewcontent");

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
