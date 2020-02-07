package com.jonas.helper;

import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper {

    private Map<String, String> database;

    public DatabaseHelper(){
        database = new HashMap<>();

    }

    public void put(String key, String value){
        database.put(key, value);
    }

    public String get(String key){
        return database.entrySet().stream()
                .filter(e -> e.getKey().equals(key))
                .findFirst()
                .get()
                .getValue();
    }

    public void clearDatabase() {
        database = new HashMap<>();
    }

    public int sizeOf(){
        return database.size();
    }
}
