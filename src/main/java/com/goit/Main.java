package com.goit;

import com.goit.database.Database;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.migrate();
    }
}