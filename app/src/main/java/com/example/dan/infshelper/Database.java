package com.example.dan.infshelper;

import java.util.ArrayList;

// Mock database connnection
public class Database {
    private static ArrayList<Topic> topicArrayList = new ArrayList<Topic>() {{
        add(new Topic(1,"Barack Obama", "Law"));
        add(new Topic(2, "Michael Jackson", "Music"));
        add(new Topic(3,"Ronald McDonald", "Hospitality"));
        add(new Topic(4,"Bruce Wayne", "Law"));
        add(new Topic(5, "Kathy Xu", "Information Systems"));
        add(new Topic(6, "Michael Cahalane", "Information Systems"));
        add(new Topic(7, "Albert Einstein", "Physics"));
        add(new Topic(8,"King Arthur", "History"));
        add(new Topic(9, "Jeremy Fu", "Physics"));
        add(new Topic(10, "Gavin Chiem", "History"));
    }};

    // Retrieves an ArrayList of 'Topic' objects stored in the database
    public static ArrayList<Topic> getTopicArrayList() {
        return topicArrayList;
    }

    // Retrieves one 'Topic' object from the database by id
    public static Topic getUserById(int id) {
        for (Topic u : topicArrayList) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}