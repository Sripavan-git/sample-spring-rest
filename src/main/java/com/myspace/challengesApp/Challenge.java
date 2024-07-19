package com.myspace.challengesApp;

public class Challenge {
    private long id;
    private String month;
    private String description;


    public Challenge(long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public long getId(){
        return this.id;
    }

    public String getMonth(){
        return this.month;
    }
    public String getDescription(){
        return this.description;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setMonth(String month){
        this.month = month;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
