package com.example.myapplication;

import java.util.Date;
import java.util.List;

public class ChecklistNote extends Note {
    //Attribute
    public List<String> items;

    public ChecklistNote(String title, Date createdDate, List<String> items) {
        super();
    }

    //getter method
    public List<String> getItems() {
        return items;
    }

    //setter method
    private void setItems(List<String> newItems) {
        this.items = newItems;
    }

    public String getSummary() {
        // String strItem = //loop for get data from List
        // return title+":"+textContent+"("+createdDate+")";
        return title + ":" + "(" + createdDate + ")";
    }

}