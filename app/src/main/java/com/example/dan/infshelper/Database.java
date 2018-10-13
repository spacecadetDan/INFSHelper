package com.example.dan.infshelper;

import java.util.ArrayList;

// Mock database connnection
public class Database {
    private static ArrayList<User> userArrayList = new ArrayList<User>() {{
        add(new User(1,"Barack Obama", "Law"));
        add(new User(2, "Michael Jackson", "Music"));
        add(new User(3,"Ronald McDonald", "Hospitality"));
        add(new User(4,"Bruce Wayne", "Law"));
        add(new User(5, "Kathy Xu", "Information Systems"));
        add(new User(6, "Michael Cahalane", "Information Systems"));
        add(new User(7, "Albert Einstein", "Physics"));
        add(new User(8,"King Arthur", "History"));
        add(new User(9, "Jeremy Fu", "Physics"));
        add(new User(10, "Gavin Chiem", "History"));
    }};

    // Retrieves an ArrayList of 'User' objects stored in the database
    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    // Retrieves one 'User' object from the database by id
    public static User getUserById(int id) {
        for (User u : userArrayList) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}