package com.example.retrofit2example;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class HeroRepository {

    private static HeroRepository repository;
    private Retrofit retrofit;

    static HeroRepository getInstance() {
        if (repository == null) {

            repository = new HeroRepository();
        }
        return repository;
    }

    MutableLiveData<List<Hero>> getHeroList(Application application) {
        final MutableLiveData<List<Hero>> data = new MutableLiveData<>();

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiInterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Hero>> call = apiInterface.getHeroList("9810266790");

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(@NonNull Call<List<Hero>> call, @NonNull Response<List<Hero>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Hero>> call, @NonNull Throwable t) {

            }
        });

        return data;
    }
}
