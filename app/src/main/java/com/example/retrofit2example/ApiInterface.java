package com.example.retrofit2example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";
//            "https://simplifiedcoding.net/demos/";

    @GET("posts")
    Call<List<Hero>> getHeroList();

//    Call<List<Hero>> getHeroList(@Query("name") String name);

//    pass params
//    using @Query annotation
}
