package com.example.retrofit2example;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

class HeroViewModel extends ViewModel {

    private final LiveData<List<Hero>> heroLiveData;

    public HeroViewModel() {

        heroLiveData = HeroRepository.getInstance().getHeroList();
    }

    LiveData<List<Hero>> getHeroObservable() {
        return heroLiveData;
    }
}
