package classes.database;

import java.io.File;
import java.io.Serializable;

public class DatabaseManager implements Serializable {
    private File DatabaseManagerFile;
    public void setDatabaseManagerFile(File databaseManagerFile) {
        DatabaseManagerFile = databaseManagerFile;
    }
}
