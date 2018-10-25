package com.example.dan.infshelper;

public class Topic {
    public int id;
    public String name;
    public String desc;
    public String vid;
    //describe what a topic requires
    public Topic(int id, String name, String desc, String vid) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.vid = vid;
    }

    //return topic name as a string
    public String toString() {
        return name;
    }

    //get topic id
    public int getId() {
        return id;
    }

    //get topic name
    public String getName() {
        return name;
    }

    //get topic description
    public String getDesc() {
        return desc;
    }

    //get topic youtube code
    public String getVid() {
        return vid;
    }

}
