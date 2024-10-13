package classes.database;

import javafx.scene.control.Button;

public class Employee {
    public String ID;
    public String Name;
    public String Age;
    public String Sex;
    public String Place;
    public Button button;

    public Employee() {
    }

    public Employee(String ID, String Name, String Age, String Sex, String Place, String button) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;
        this.Place = Place;
        this.button = new Button("delete");
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}