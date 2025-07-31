package com.example.myapplication;

public abstract class Note {
    //Attribute
    public String title;
    public String createdDate;
    //getter
/* public String getTitle(){
    return title;
}
    public String getCreatedDate(){
    return createdDate;
 */
    //Method
    abstract public String getSummary();
       //title:context(CreateDate)
    //system.out.println(title+":"+content+"("createdDate+")");
}