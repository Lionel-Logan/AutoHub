package classes;

import classes.database.*;
import classes.exceptions.CompanyNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseHandler {
    private static String url = "jdbc:mysql://localhost:";
    private static String companyName = "";

    public static boolean isConnected = false;

    private static Statement st;
    private static Connection conn;
    private static ResultSet rs;

    public static void connectDatabase(String inUser, String inPass, String inCompanyName, String portNo) throws SQLException{   //Call this function first to establish the connection with MySQL
        companyName = inCompanyName;
        String urlSub = url + portNo + "/mysql";
        conn = DriverManager.getConnection(urlSub, inUser, inPass);
        st = conn.createStatement();
        try{
            executeDatabaseManager();
            conn.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        url += portNo + "/" + companyName;
        conn = DriverManager.getConnection(url, inUser, inPass);
        st = conn.createStatement();
        isConnected = true;
    }

    public static void disconnectDatabase() throws SQLException {    //This function is to be called upon closing the application
        conn.close();
        isConnected = false;
        url="jdbc:mysql://localhost:";
        CredentialsHandler.isAdmin = false;
    }

    public static void executeDatabaseManager() throws IOException {  //This function is used to load the database manager file from local computers and synchronize databases across all remote computers
        File dbm = new File(companyName + ".dbm");
        if(dbm.createNewFile()){
            try{
                String sql = "";
                String tsql = "";
                st.executeUpdate(tsql = "CREATE DATABASE " + companyName);
                sql += tsql + "\n";
                st.executeUpdate(tsql = "USE " + companyName);
                sql += tsql + "\n";

                st.executeUpdate(tsql = "CREATE TABLE Managers (MGR_ID INT PRIMARY KEY, MGR_NAME VARCHAR(50), AGE INT, SEX VARCHAR(10), PLACE VARCHAR(50))");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Employees (EMP_ID INT PRIMARY KEY, EMP_NAME VARCHAR(50), AGE INT, SEX VARCHAR(10), PLACE VARCHAR(50))");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Showrooms (SHOWROOM_ID INT PRIMARY KEY, OWNERSHIP VARCHAR(100), LOCATION VARCHAR(50), COUNTRY VARCHAR(50), MGR_ID INT)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Divisions (DIVISION_ID INT PRIMARY KEY, DIVISION_NAME VARCHAR(50), MGR_ID INT)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Cars (CAR_ID INT PRIMARY KEY, CAR_NAME VARCHAR(50), CAR_TYPE VARCHAR(50), ENGINE_TYPE VARCHAR(50), TRANSMISSION_TYPE VARCHAR(50), FUEL_CAPACITY VARCHAR(10), MILEAGE VARCHAR(10), PRICE VARCHAR(50))");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Availability (CAR_ID INT PRIMARY KEY, SHOWROOM_ID INT, COUNT INT)");
                sql += tsql + "\n";

                st.executeUpdate(tsql = "ALTER TABLE Availability ADD FOREIGN KEY(SHOWROOM_ID) REFERENCES Showrooms(SHOWROOM_ID) ON DELETE SET NULL");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Showrooms ADD FOREIGN KEY(MGR_ID) REFERENCES Managers(MGR_ID) ON DELETE SET NULL");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Divisions ADD FOREIGN KEY(MGR_ID) REFERENCES Managers(MGR_ID) ON DELETE SET NULL");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Availability ADD FOREIGN KEY(CAR_ID) REFERENCES Cars(CAR_ID)");
                sql += tsql + "\n";

                FileWriter fw = new FileWriter(dbm);
                fw.write(sql);
                fw.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                try{
                    st.executeUpdate("DROP DATABASE " + companyName);
                }
                catch(SQLException s){}
                finally {
                    FileReader fr = new FileReader(dbm);
                    int c = fr.read();
                    String sql = "";
                    while(c != -1){
                        if((char)c != '\n'){
                            sql += (char)c;
                        }
                        else{
                            st.executeUpdate(sql);
                            sql = "";
                        }
                        c = fr.read();
                    }

                    rs = st.executeQuery("SELECT CAR_ID, CAR_NAME FROM Cars");
                    while(rs.next()){
                        String carID = "";
                        String carName = "";
                        carID = rs.getString(1);
                        carName = rs.getString(2);
                        CredentialsHandler.initializeImageFolderFor(carID, carName);
                    }
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static void updateDatabaseManager(String sql) throws IOException{
        File dbm = new File(companyName + ".dbm");
        if(dbm.exists()){
            FileWriter fw = new FileWriter(dbm, true);
            for(int i = 0; i < sql.length(); i++){
                fw.append(sql.charAt(i));
            }
            fw.close();
        }
        else{
            throw new CompanyNotFoundException();
        }
    }

    public static int generateSQLQuery(String conditionString, String conditionInput) throws SQLException, IOException { //This is the function which generates the necessary SQL Query according to the condition code passed as parameter. 1 for true, 0 for false, -1 for exception
        String sql = "";
        switch(conditionString){
            case "CheckShowroom":   //Returns true if the showroom does exist
                sql = "SELECT * FROM Showrooms WHERE OWNERSHIP = '" + conditionInput + "'";
                rs = st.executeQuery(sql);
                if(!rs.next()){
                    return 0;
                }
                else{
                    return 1;
                }

            case "CheckDivision":   //Returns true if the division does exist
                sql = "SELECT * FROM Divisions WHERE DIVISION_NAME = '" + conditionInput + "'";
                rs = st.executeQuery(sql);
                if(!rs.next()){
                    return 0;
                }
                else{
                    return 1;
                }

            case "CheckManager":
                sql = "SELECT MGR_ID FROM Managers";
                rs = st.executeQuery(sql);
                while(rs.next()){
                    if(rs.getInt(1) == Integer.valueOf(conditionInput)){
                        return 1;
                    }
                }
                return 0;

            case "CheckUniqueCar":  //Returns 1 if unique
                sql = "SELECT * FROM Cars WHERE CAR_ID = " + conditionInput;
                rs = st.executeQuery(sql);
                if(!rs.next()){
                    return 1;
                }
                else{
                    return 0;
                }

            case "DeleteCar":
                sql = "DELETE FROM Availability WHERE CAR_ID = " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                sql = "DELETE FROM Cars WHERE CAR_ID = " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            case "DeleteEmployee":
                rs = st.executeQuery("SELECT EMP_NAME FROM Employees WHERE EMP_ID = " + conditionInput);
                rs.next();
                String name = rs.getString(1);
                sql = "DELETE FROM Employees WHERE EMP_ID = " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                CredentialsHandler.deleteUser(name);
                return 1;

            case "DeleteManager":
                rs = st.executeQuery("SELECT MGR_NAME FROM Managers WHERE MGR_ID = " + conditionInput);
                rs.next();
                String name2 = rs.getString(1);
                sql = "DELETE FROM Managers WHERE MGR_ID = " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                CredentialsHandler.deleteUser(name2);
                return 1;

            case "EraseTable":
                sql = "TRUNCATE TABLE " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            case "RetrieveManagerID":
                rs = st.executeQuery("SELECT MGR_ID FROM Managers");
                int managerID = 0;
                while(rs.next()){
                    managerID = rs.getInt(1);
                }
                if(managerID == 0) return 1;
                else return managerID + 1;

            case "RetrieveUserID":
                rs = st.executeQuery("SELECT EMP_ID FROM Employees");
                int userID = 0;
                while(rs.next()){
                    userID = rs.getInt(1);
                }
                if(userID == 0) return 1;
                else return userID + 1;

            default:
                return -1;
        }
    }

    public static int generateSQLQuery(String conditionString, Object obj, String conditionInput) throws SQLException, IOException { //This is the function which generates the necessary SQL Query according to the condition code passed as parameter. 1 for true, 0 for false, -1 for exception
        String sql = "";
        switch(conditionString){
            case "UserAccountCreation":
                User user = (User) obj;
                if(user.IsManager){
                    sql = "INSERT INTO Managers VALUES (" + generateSQLQuery("RetrieveManagerID", "") + ", '" + user.Username + "', " + user.Age + ", '" + user.Sex + "', '" + user.Place + "')";
                    st.executeUpdate(sql);
                    updateDatabaseManager(sql + "\n");
                    return 1;
                }
                else{
                    sql = "INSERT INTO Employees VALUES (" + generateSQLQuery("RetrieveUserID", "") + ", '" + user.Username + "', " + user.Age + ", '" + user.Sex + "', '" + user.Place + "')";
                    st.executeUpdate(sql);
                    updateDatabaseManager(sql + "\n");
                    return 1;
                }

            case "AddCar":  //Adds a car and returns 1 upon completion
                Car car = (Car) obj;
                sql = "INSERT INTO Cars VALUES (" + car.CarID + ", '" + car.Name + "', '" + car.CarType + "', '" + car.EngineType + "', '" + car.TransmissionType + "', '" + car.FuelCapacity + "', '" + car.Mileage + "', '" + car.Price + "')";
                st.executeUpdate(sql);
                CredentialsHandler.initializeImageFolderFor(car.CarID, car.Name);
                updateDatabaseManager(sql + "\n");
                sql = "INSERT INTO Availability VALUES (" + car.CarID + ", " + car.ShowroomID + ", " + car.Count + ")";
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            case "AddShowroom":
                Showroom showroom = (Showroom) obj;
                sql = "INSERT INTO Showrooms VALUES (" + showroom.ID + ", '" + showroom.Ownership + "', '" + showroom.Location + "', '" + showroom.Country + "', " + showroom.ManagerID + ")";
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            case "AddDivision":
                Division division = (Division) obj;
                sql = "INSERT INTO Divisions VALUES (" + division.ID + ", '" + division.Name + "', " + division.ManagerID + ")";
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            case "UpdateCar":
                Car car2 = (Car) obj;
                rs = st.executeQuery("SELECT CAR_NAME FROM Cars WHERE CAR_ID = " + conditionInput);
                String carName = "";
                while(rs.next()){
                    carName = rs.getString(1);
                }
                sql = "UPDATE Cars SET CAR_NAME = '" + car2.Name + "', CAR_TYPE = '" + car2.CarType + "', ENGINE_TYPE = '" + car2.EngineType + "', TRANSMISSION_TYPE = '" + car2.FuelCapacity + "', FUEL_CAPACITY = '" + car2.FuelCapacity + "', MILEAGE = '" + car2.Mileage + "', PRICE = '" + car2.Price + "' WHERE CAR_ID = " + conditionInput;
                st.executeUpdate(sql);
                CredentialsHandler.updateImageFolderFor(conditionInput, carName, car2.Name);
                updateDatabaseManager(sql + "\n");
                sql = "UPDATE Availability SET SHOWROOM_ID = " + car2.ShowroomID + ", COUNT = " + car2.Count + " WHERE CAR_ID = " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            case "UpdateShowroom":
                Showroom showroom2 = (Showroom) obj;
                sql = "UPDATE Showrooms SET OWNERSHIP = '" + showroom2.Ownership + "', LOCATION = '" + showroom2.Location + "', COUNTRY = '" + showroom2.Country + "', MGR_ID = '" + showroom2.ManagerID + "' WHERE SHOWROOM_ID = " + conditionInput;
                st.executeUpdate(sql);
                updateDatabaseManager(sql + "\n");
                return 1;

            default:
                return -1;
        }
    }

    public static ObservableList<Car> retrieveCars(String name) throws SQLException{
        ObservableList<Car> cars = FXCollections.observableArrayList();

        if(name.equals("All"))
            rs = st.executeQuery("SELECT * FROM Cars LEFT JOIN AVAILABILITY ON Cars.CAR_ID = Availability.CAR_ID");
        else
            rs = st.executeQuery("SELECT * FROM Cars LEFT JOIN AVAILABILITY ON Cars.CAR_ID = Availability.CAR_ID WHERE CAR_NAME = '" + name + "'");

        while(rs.next()){
            Car car = new Car();

            car.CarID = rs.getString(1);
            car.Name = rs.getString(2);
            car.CarType = rs.getString(3);
            car.EngineType = rs.getString(4);
            car.TransmissionType = rs.getString(5);
            car.FuelCapacity = rs.getString(6);
            car.Mileage = rs.getString(7);
            car.Price = rs.getString(8);
            car.button = new Button("VIEW");
            car.ShowroomID = rs.getString(10);
            car.Count = rs.getString(11);
            System.out.println(car.Count);

            cars.add(car);
        }

        return cars;
    }

    public static ObservableList<Employee> retrieveEmployees(String name) throws SQLException{
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        if(name.equals("All"))
            rs = st.executeQuery("SELECT * FROM Employees");
        else
            rs = st.executeQuery("SELECT * FROM Employees where EMP_NAME = '" + name + "'");

        while(rs.next()){
            Employee employee = new Employee();

            employee.ID = rs.getString(1);
            employee.Name = rs.getString(2);
            employee.Age = rs.getString(3);
            employee.Sex = rs.getString(4);
            employee.Place = rs.getString(5);
            employee.button = new Button("view");

            employees.add(employee);
        }

        return employees;
    }

    public static ObservableList<Manager> retrieveManagers(String name) throws SQLException{
        ObservableList<Manager> employees = FXCollections.observableArrayList();

        if(name.equals("All"))
            rs = st.executeQuery("SELECT * FROM Managers");
        else
            rs = st.executeQuery("SELECT * FROM Managers where MGR_NAME = '" + name + "'");

        while(rs.next()){
            Manager employee = new Manager();

            employee.ID = rs.getString(1);
            employee.Name = rs.getString(2);
            employee.Age = rs.getString(3);
            employee.Sex = rs.getString(4);
            employee.Place = rs.getString(5);
            employee.button = new Button("view");

            employees.add(employee);
        }

        return employees;
    }
}