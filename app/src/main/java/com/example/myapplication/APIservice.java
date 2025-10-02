package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class APIservice {
    @GET("posts")
        //Endpoint
    Call<List<textNote>> getTextNote() {
        return null;
    }
}
