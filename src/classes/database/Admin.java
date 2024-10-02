package classes.database;

import java.io.Serializable;

public class Admin implements Serializable {
    public String Username;
    public String Password;
    public String CompanyName;
    public DatabaseManager dbm;
}
