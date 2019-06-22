package com.example.retrofit2example;

import com.google.gson.annotations.SerializedName;

class Hero {

    @SerializedName("name")
    private String name;

    @SerializedName("subjects")
    private String subjects;

    String getName() {
        return name;
    }

    String getSubjects() {
        return subjects;
    }
}
