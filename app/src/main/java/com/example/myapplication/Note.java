package com.example.myapplication;

import java.util.Date;

public class Note {
    //Attribute
    public String title;
    public Date createdDate;
    public User owner;
    //getter method
    public String getTitle(){
        return title;
    }
    public Date getCreatedDate(){
        return createdDate;
    }
    public User getUser(){
        return owner;
    }
    //setter method
    public void setTitle(String newTitle){
        this.title = newTitle;

    }
    public void getCreatedDate(Date newCreatedDate){
        this.createdDate=newCreatedDate;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    //Method
    public String getSummary() {
        return null;
    }

    //System.out.println(title+":"+content+"("+createdDate+")");

}