package com.example.dan.infshelper;

import java.util.ArrayList;

// Mock database connnection
public class Database {
    private static ArrayList<Topic> topicArrayList = new ArrayList<Topic>() {{
        add(new Topic(1,"Java fundamentals", "Law"));
        add(new Topic(2, "Inheritance and abstract classes", "Music"));
        add(new Topic(3,"Polymorphism and interfaces", "Hospitality"));
        add(new Topic(4,"JavaFX", "Law"));
        add(new Topic(5, "Exception handling", "Information Systems"));
        add(new Topic(6, "Event-driven programming", "Information Systems"));
        add(new Topic(7, "Database", "Physics"));
        add(new Topic(8,"Review", "History"));
    }};

    // Retrieves an ArrayList of 'Topic' objects stored in the database
    public static ArrayList<Topic> getTopicArrayList() {
        return topicArrayList;
    }

    // Retrieves one 'Topic' object from the database by id
    public static Topic getTopicById(int id) {
        for (Topic u : topicArrayList) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}