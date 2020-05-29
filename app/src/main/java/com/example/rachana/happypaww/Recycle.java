package com.example.rachana.happypaww;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Recycle extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Food> FoodList;
    Food mFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Recycle.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        FoodList = new ArrayList<>();


        mFood = new Food("Smart Heart Power Pack Adult Dog Food","It is highly digestible and dogs love its great taste. Smart Heart Power Pack Adult Medium to Large Breed food is formulated to meet or surpass the nutritional levels established by The Association of American Feed Control Officials (AAFCO) for dogs.","2,600",R.drawable.dogfood1);
        FoodList.add(mFood);

        mFood = new Food("Pedigree Chicken And Vegetable Adult Dog Food","Pedigree Chicken & Vegetables is a healthy and complete meal for your adult dog, packed with proteins (from chicken) & vitamins (from vegetables)","2,000",R.drawable.dogfood2);
        FoodList.add(mFood);

        mFood = new Food("Whiskas Pocket Ocean Fish Cat Food ","Whiskas Pocket Ocean Fish Cat Food 7 Kg is a premium quality cat food having the goodness and taste of Real Oceanic fish for giving high-quality nutrition to adult felines of all breeds. A balanced ratio of calcium and phosphorus keeps bones and joints of the cat in strong condition.","1,780",R.drawable.catfood1);
        FoodList.add(mFood);

        mFood = new Food("Drools Cat Food Ocean Fish"," Drools Cat Food with Ocean Fish presents a nutritionally complete and balanced diet to keep your lovely furry cat in the best health condition. The food includes high-quality protein, which is sourced from ocean fish - Sardine and Mackerel.","1,400",R.drawable.catfood2);
        FoodList.add(mFood);

        MyAdapter myAdapter = new MyAdapter(Recycle.this,FoodList);
        mRecyclerView.setAdapter(myAdapter);
    }
}