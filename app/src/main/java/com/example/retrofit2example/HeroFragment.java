package com.example.retrofit2example;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HeroFragment extends Fragment {
    private static final String TAG = "HeroFragment";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HeroAdapter adapter;
    private HeroViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.progressBar);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);

        viewModel.getHeroObservable().observe(getViewLifecycleOwner(), heroes -> {

            /*
             * The recommended solution is to use fragment’s view lifecycle
             * via getViewLifecycleOwner() or getViewLifecycleOwnerLiveData() instead of"this"
             * which were added in Support Library 28.0.0 and AndroidX 1.0.0,
             * so that LiveData will remove observers every time the fragment’s view is destroyed
             *
             */

            if (heroes != null) {
                progressBar.setVisibility(View.GONE);
                progressBar.setIndeterminate(false);
            } else {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
            }

            adapter = new HeroAdapter(requireActivity(), viewModel.getHeroObservable().getValue());
            recyclerView.setAdapter(adapter);
        });
    }
}
