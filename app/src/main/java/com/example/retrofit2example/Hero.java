package com.example.retrofit2example;

import com.google.gson.annotations.SerializedName;

class Hero {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    String getId() {
        return id;
    }

    String getTitle() {
        return title;
    }
}
