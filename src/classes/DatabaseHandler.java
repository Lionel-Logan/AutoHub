package classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseHandler {
    private static String url = "jdbc:sql://localhost:3306/";
    private static String username = "";
    private static String password = "";

    private static final String currentWorkingDirectory = Paths.get("").toAbsolutePath().toString();

    private static Statement st;
    private static ResultSet rs;
    private static String database;

    public static void connectDatabase(String inUser, String inPass, String companyName) throws SQLException{
        username = inUser;
        password = inPass;
        url += companyName;
        Connection conn = DriverManager.getConnection(url, username, password);
        st = conn.createStatement();
    }

    public static void executeDatabaseManager(String inDatabase) throws IOException {
        database = inDatabase;
        File dbm = new File(database + ".dbm");
        if(dbm.createNewFile()){

        }
        else{

        }
    }

    public static void generateSQLQuery(){

    }
}