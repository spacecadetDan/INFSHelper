package com.example.dan.infshelper;

public class Topic {
    public int id;
    public String name;
    public String degree;

    public Topic(int id, String name, String degree) {
        this.id = id;
        this.name = name;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
