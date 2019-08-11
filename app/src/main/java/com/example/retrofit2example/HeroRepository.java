package com.example.retrofit2example;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HeroRepository {

    private static HeroRepository repository;

    static HeroRepository getInstance() {
        if (repository == null) {

            repository = new HeroRepository();
        }
        return repository;
    }

    MutableLiveData<List<Hero>> getHeroList() {
        final MutableLiveData<List<Hero>> data = new MutableLiveData<>();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Hero>> call = apiInterface.getHeroList("9810266790");

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(@NonNull Call<List<Hero>> call
                    , @NonNull Response<List<Hero>> response) {

                if (response.isSuccessful() && response.body() != null)
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Hero>> call, @NonNull Throwable t) {

            }
        });

        return data;
    }
}
