package com.example.first;

import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class homeController {
    @FXML
    Label namelabel1;

    @FXML
    Label namelabel2;

    public void display(String username,String password){
        namelabel1.setText(username);
        namelabel2.setText(password);
    }
}
