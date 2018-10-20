package com.example.dan.infshelper;

public class Topic {
    public int id;
    public String name;
    public String desc;
    public String vid;

    public Topic(int id, String name, String desc, String vid) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.vid = vid;
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

    public String getDesc() { return desc; }

    public String getVid() { return vid; }

    public void setName(String name) {
        this.name = name;
    }

}
