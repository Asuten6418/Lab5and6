package com.example.myapplication;

import java.util.List;
import java.util.Collection;

public abstract class ChaListNote  extends Note {
    //Attribute
    private List<String> Items;

    //getter
    public List<String> getItems() {
        return Items;
    }
    //setter
        public String setItems(String newItems){
        return newItems;
        }
    //Method
    public String getSummary(){
        String  AllItems = "" ;
        return  title+":"+AllItems+"("+createdDate+")";
    }
}