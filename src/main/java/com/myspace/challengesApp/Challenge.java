package com.myspace.challengesApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String monthName;
    private String description;


    public Challenge(long id, String monthName, String description) {
        this.id = id;
        this.monthName = monthName;
        this.description = description;
    }
    public Challenge(){

    }

    public long getId(){
        return this.id;
    }

    public String getMonth(){
        return this.monthName;
    }
    public String getDescription(){
        return this.description;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setMonth(String monthName){
        this.monthName = monthName;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
