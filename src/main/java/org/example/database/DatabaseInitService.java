package org.example.database;

import org.example.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public void initDB(Database database){
        String initDbFilename = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
        try {
            String sql = String.join(
                    "\n",
                    Files.readString(Paths.get(initDbFilename))
            );

            database.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseInitService().initDB(database);
    }
}
