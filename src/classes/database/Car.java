package classes.database;

import javafx.scene.control.Button;

public class Car {
    public String CarID;
    public String Name;
    public String CarType;
    public String EngineType;
    public String TransmissionType;
    public String FuelCapacity;
    public String Mileage;
    public String Price;
    public Button button;
    public String Count;
    public String ShowroomID;

    // Default constructor
    public Car() {}

    // Parameterized constructor
    public Car(String CarID, String Name, String CarType, String EngineType, String TransmissionType, String FuelCapacity, String Mileage, String Price) {
        this.CarID = CarID;
        this.Name = Name;
        this.CarType = CarType;
        this.EngineType = EngineType;
        this.TransmissionType = TransmissionType;
        this.FuelCapacity = FuelCapacity;
        this.Mileage = Mileage;
        this.Price = Price;
        this.button=new Button("view");

    }

    // Getters and setters
    public String getCarID() {
        return CarID;
    }

    public void setCarID(String CarID) {
        this.CarID = CarID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public String getEngineType() {
        return EngineType;
    }

    public void setEngineType(String EngineType) {
        this.EngineType = EngineType;
    }

    public String getTransmissionType() {
        return TransmissionType;
    }

    public void setTransmissionType(String TransmissionType) {
        this.TransmissionType = TransmissionType;
    }

    public String getFuelCapacity() {
        return FuelCapacity;
    }

    public void setFuelCapacity(String FuelCapacity) {
        this.FuelCapacity = FuelCapacity;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String Mileage) {
        this.Mileage = Mileage;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public Button getButton(){
        return button;
    }

    public void setButton(Button button){
        this.button = button;
    }
}

