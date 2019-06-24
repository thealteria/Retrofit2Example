package com.example.retrofit2example;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private HeroAdapter adapter;
    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifecycleRegistry = new LifecycleRegistry(this);
        lifecycleRegistry.markState(Lifecycle.State.CREATED);

        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        final HeroViewModel viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);

        viewModel.getHeroObservable().observe(MainActivity.this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {

                adapter = new HeroAdapter(MainActivity.this, viewModel.getHeroObservable().getValue());
                recyclerView.setAdapter(adapter);

                adapter.notifyDataSetChanged();

                Log.i(TAG, "onChanged: " + viewModel.getHeroObservable().getValue());
            }
        });
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        Log.i(TAG, "getLifecycle: getlifecycle started");
        return lifecycleRegistry;
    }
}
