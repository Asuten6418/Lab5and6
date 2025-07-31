package com.example.myapplication;

public class Textnote extends Note {
    //attribute
    private String textContent;
    //getter method
    public String getTextContent(){
        return textContent;
    }
//setter method
    public String setTextContent(String newContent){
        this,textContent = newContent
                return newContent;
    }
    //Method
    public String getSummary() {
        return title + ":" + TextContent + "(" + createdDate + ")";
        //System.out.println(title+":"+content+"("+createdDate+")");
    }
}

