module com.example.first {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.first to javafx.fxml;
    exports com.example.first;
}