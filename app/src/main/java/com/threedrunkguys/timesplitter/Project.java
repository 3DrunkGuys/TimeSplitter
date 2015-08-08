package com.threedrunkguys.timesplitter;

/**
 * Created by Andrew on 8/7/2015.
 *
 * Contains all Project information.
 */
public class Project {
    private long id;
    private String name;
    private String note = "";

    private Project(){} // Requires basic project info

    public Project(long id, String name, String note){
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public String getName(){
        return name;
    }

    public String getNote(){
        return note;
    }

    public long getID(){
        return id;
    }

    public String toString(){
        return name + ": " + note;
    }
}
