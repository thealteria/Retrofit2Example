package com.example.retrofit2example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://api-dot-gpschat.appspot.com/GetClasses/";

    @POST("appliedleads")
    @FormUrlEncoded
    Call<List<Hero>> getHeroList(@Field("phone") String phone);
}
