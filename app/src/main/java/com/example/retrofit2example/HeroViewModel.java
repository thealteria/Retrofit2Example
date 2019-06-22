package com.example.retrofit2example;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

class HeroViewModel extends AndroidViewModel {

    private final LiveData<List<Hero>> heroList;

    public HeroViewModel(Application application) {
        super(application);

        heroList = HeroRepository.getInstance().getHeroList(application);
    }

    LiveData<List<Hero>> getHeroObservable() {
        return heroList;
    }
}
