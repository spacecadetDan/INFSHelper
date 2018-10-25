package com.example.dan.infshelper;

import java.util.ArrayList;

// Array of topics, descriptions and youtube links
public class Array {
    private static ArrayList<Topic> topicArrayList = new ArrayList<Topic>() {{
        add(new Topic(1, "Java fundamentals",
                "This topic will recap the fundamentals of Java, focusing on methods, objects and classes and object-oriented thinking:\n\n" +
                        "Objectives:\n" +
                        "•\tUnderstand how to use methods to define reusable code and organise and simplify coding\n" +
                        "•\tUnderstand how to describe objects and classes and use classes to model objects\n" +
                        "•\tBe able to apply class abstraction to develop software\n" +
                        "•\tTo explore the differences between the procedural paradigm and object oriented paradigm\n",
                        "OEfSFrk_KEI"));

        add(new Topic(2, "Inheritance and abstract classes",
                "Inheritance and abstract classes are important and powerful features for reusing software.\n\n" +
                        "Objectives:\n" +
                        "•\tUnderstand how to define a subclass from a superclass through inheritance\n" +
                        "•\tTo override instance methods in the subclass\n" +
                        "•\tTo distinguish differences between overriding and overloading\n" +
                        "•\tTo design and use abstract classes\n",
                        "2aQ9Y7bumts"));

        add(new Topic(3, "Polymorphism and interfaces",
                "This section introduces polymorphism and interfaces. Polymorphism allows a variable of a supertype to refer to a subtype object. Interfaces are class like constructs that contains only constants and abstract methods.\n\n" +
                        "Objectives:\n" +
                        "•\tTo discover polymorphism and dynamic binding\n" +
                        "•\tTo specify common behaviour for objects and interfaces\n" +
                        "•\tBe able to define interfaces and classes that implement interfaces\n" +
                        "•\tExplore the similarities and differences among concrete classes, abstract classes, and interfaces\n",
                        "p9rOOzLjD5Q"));

        add(new Topic(4, "JavaFX",
                "This chapter introduces JavaFX, presenting the basics of JavaFX programming and demonstrating object oriented design and programming. It will explain the framework of JavaFX and discuss the JavaFX GUI components and their relationships\n\n" +
                        "Objectives:\n" +
                        "•\tTo distinguish between JavaFX, Swing and AWT\n" +
                        "•\tBe able to write a simple JavaFX program and understand the relationship among stages, scenes and nodes\n" +
                        "•\tLearn how to create user interfaces using panes, UI controls, and shapes\n" +
                        "•\tBe able to create colours, fonts and images using the Colour, Font and Image class\n",
                    "FLkOX4Eez6o"));

        add(new Topic(5, "Exception handling",
                "Exception handling enables a program to deal with exceptional situations and continue its normal executions. An exception refers to an object that represents an error or condition that prevents execution from proceeding normally.\n\n" +
                        "Objectives:\n" +
                        "•\tTo get an overview of exceptions and exception handling\n" +
                        "•\tTo explore the advantages of using exception handling\n" +
                        "•\tUnderstand how to distinguish exception types\n" +
                        "•\tLearn how to declare exceptions in a method header\n" +
                        "•\tLearn how to throw exceptions in a method\n",
                        "K_-3OLkXkzY"));

        add(new Topic(6, "Event-driven programming",
                "This topic focuses on event driven programming. When a Java GUI program interacts with the user, the events drive its execution. This is called event-driven programming.\n\n" +
                        "Objectives:\n" +
                        "•\tTo learn the basics of event driven programming\n" +
                        "•\tBe able to describe events, event sources, and event classes\n" +
                        "•\tUnderstand how to define handler classes, register handler objects with the source object, and write the code to handle events\n" +
                        "•\tTo define handler classes using inner classes\n" +
                        "•\tTo define handler classes using anonymous inner classes\n",
                        "3EE7E3bvfe8"));

        add(new Topic(7, "Databases",
                "Database systems are everywhere. Not only do they store data, they also provide means of accessing, updating, manipulating and analysing data. Database systems play an important role in society and in commerce.\n\n" +
                        "Objectives:\n" +
                        "•\tTo understand the concepts of databases and database management systems\n" +
                        "•\tTo understand the relational data model: relational data structures, constraints and languages\n" +
                        "•\tTo learn how to load a driver, connect to a database, execute statements, and process result sets using JDBC\n",
                    "JyMkANs3vhI"));

        add(new Topic(8, "Review",
                "Congratulations on reaching the end of the course!\n\n" + "This section will review all topics and provide a summary on the chapters. It will also introduce what's next for Java and discuss the opportunities of using Java in a professional environment.",
                "5ApeBo1LujE"));
    }};

    // Retrieves an ArrayList of 'Topic' objects stored in the database
    public static ArrayList<Topic> getTopicArrayList() {
        return topicArrayList;
    }

    // Retrieves one 'Topic' object from the database by id
    public static Topic getTopicById(int id) {
        for (Topic u : topicArrayList) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}