package org.example.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Prefs {
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PASS = "dbPass";
    public static final String DEFAULT_PREFS_FILE = "prefs.json";
    public static final String INIT_DB_SQL_FILE_PATH = "InitDBSql";
    public static final String POPULATE_DB_SQL_FILE_PATH = "PopulateDBSql";
    public static final String PRINT_PRICE_PROJECT_QUERY_SQL_FILE_PATH = "PrintProjectPriceQuerySql";
    public static final String YOUNGEST_OLDEST_WORKER_QUERY_SQL_FILE_PATH = "FindYoungestOldestWorkersQuerySql";
    public static final String MAX_SALARY_WORKER_QUERY_SQL_FILE_PATH = "FindMaxSalaryWorkerQuerySql";
    public static final String MAX_PROJECT_CLIENT_QUERY_SQL_FILE_PATH = "FindMaxProjectClientQuerySql";
    public static final String LONGEST_PROJECT_QUERY_SQL_FILE_PATH = "FindLongestProjectQuerySql";
    private final Map<String, Object> prefs;

    public Prefs() {
        this(DEFAULT_PREFS_FILE);
    }

    public Prefs(String filename) {

        try {
            String json = String.join(
                    "\n",
                    Files.readString(Paths.get(filename))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class
            );

            prefs = new Gson().fromJson(json, typeToken.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(String key) {
        return getPref(key).toString();
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }

}