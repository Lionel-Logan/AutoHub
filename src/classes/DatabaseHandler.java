package classes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseHandler {
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String username = "";
    private static String password = "";

    private static final String currentWorkingDirectory = Paths.get("").toAbsolutePath().toString();

    private static Statement st;
    private static Connection conn;
    private static ResultSet rs;

    public static void connectDatabase(String inUser, String inPass, String companyName) throws SQLException{
        username = inUser;
        password = inPass;
        String urlSub = url + "mysql";
        conn = DriverManager.getConnection(urlSub, username, password);
        st = conn.createStatement();
        try{
            executeDatabaseManager(companyName);
            conn.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        url += companyName;
        conn = DriverManager.getConnection(url, username, password);
        st = conn.createStatement();
    }

    public static void executeDatabaseManager(String companyName) throws IOException {
        File dbm = new File(companyName + ".dbm");
        if(dbm.createNewFile()){
            try{
                String sql = "";
                String tsql = "";
                st.executeUpdate(tsql = "CREATE DATABASE " + companyName);
                sql += tsql + "\n";
                st.executeUpdate(tsql = "USE " + companyName);
                sql += tsql + "\n";

                st.executeUpdate(tsql = "CREATE TABLE Managers (MGR_ID INT PRIMARY KEY, MGR_NAME VARCHAR(50), AGE INT, SEX CHAR(1), PLACE VARCHAR(50), SHOWROOM_ID INT, DIVISION_ID INT)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Employees (EMP_ID INT PRIMARY KEY, EMP_NAME VARCHAR(50), AGE INT, SEX CHAR(1), PLACE VARCHAR(50), SHOWROOM_ID INT, DIVISION_ID INT)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Showrooms (SHOWROOM_ID INT PRIMARY KEY, OWNERSHIP VARCHAR(100), LOCATION VARCHAR(50), COUNTRY VARCHAR(50), MGR_ID INT)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Divisions (DIVISION_ID INT PRIMARY KEY, DIVISION_NAME VARCHAR(50))");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Cars (CAR_ID INT PRIMARY KEY, CAR_NAME VARCHAR(50), CAR_TYPE VARCHAR(50), ENGINE_TYPE VARCHAR(50), TRANSMISSION_TYPE VARCHAR(50), FUEL_CAPACITY VARCHAR(10), MILEAGE VARCHAR(10), PRICE VARCHAR(50))");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "CREATE TABLE Availability (CAR_ID INT PRIMARY KEY, SHOWROOM_ID INT)");
                sql += tsql + "\n";

                st.executeUpdate(tsql = "ALTER TABLE Managers ADD FOREIGN KEY(SHOWROOM_ID) REFERENCES Showrooms(SHOWROOM_ID)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Employees ADD FOREIGN KEY(SHOWROOM_ID) REFERENCES Showrooms(SHOWROOM_ID)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Availability ADD FOREIGN KEY(SHOWROOM_ID) REFERENCES Showrooms(SHOWROOM_ID)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Managers ADD FOREIGN KEY(DIVISION_ID) REFERENCES Divisions(DIVISION_ID)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Employees ADD FOREIGN KEY(DIVISION_ID) REFERENCES Divisions(DIVISION_ID)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Showrooms ADD FOREIGN KEY(MGR_ID) REFERENCES Managers(MGR_ID)");
                sql += tsql + "\n";
                st.executeUpdate(tsql = "ALTER TABLE Availability ADD FOREIGN KEY(CAR_ID) REFERENCES Cars(CAR_ID)");
                sql += tsql + "\n";

                System.out.println(sql);

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
                st.executeUpdate("DROP DATABASE " + companyName);
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
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void generateSQLQuery(){

    }
}