module com.example.first {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.naming;
    requires java.security.sasl;


    opens com.example.first to javafx.fxml;
    exports com.example.first;
}