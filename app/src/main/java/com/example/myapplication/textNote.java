package com.example.myapplication;

import java.util.Date;

public class textNote extends Note{
    //Attribute
    private  String textContent;

    public textNote(String title, Date createdDate, String content) {
        super();
    }

    //getter method
    public String getTextContent(){
        return textContent;
    }

    //setter method
    public void setTextContent(String newContent){
        this.textContent = newContent;

    }

    //Method
    public String display(){
        return title+":"+textContent+"("+createdDate+")";
        //System.out.println(title+":"+content+"("+createdDate+")");
    }
}