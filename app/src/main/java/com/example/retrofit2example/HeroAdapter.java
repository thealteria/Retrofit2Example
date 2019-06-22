package com.example.retrofit2example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    private static final String TAG = "HeroAdapter";

    private Context mCtx;
    private List<Hero> heroList;

    HeroAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);

//        Glide.with(mCtx)
//                .load(hero.getImageurl())
//                .into(holder.imageView);

        holder.textName.setText(hero.getName());
        holder.textRealName.setText(hero.getSubjects());

        Log.i(TAG, "onBindViewHolder: " + hero.getSubjects());

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textName, textRealName, textApp;

        HeroViewHolder(View itemView) {
            super(itemView);

//            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textRealName = itemView.findViewById(R.id.textRealName);
            textApp = itemView.findViewById(R.id.textApp);
        }
    }
}
