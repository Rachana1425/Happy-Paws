package com.example.rachana.happypaww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Shopping extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<Shop> ShopList;
    Shop mShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Shopping.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        ShopList = new ArrayList<>();

        mShop = new Shop("Fluffy's dog and cat bed","Fluffy's dog and cat bed is ideal for indoor use as well as outdoor use such as garages or porches with its anti-skid bottom. This rectangular style pet bed is easily washable, very durable and cushion is filled with polyester. This dog and cat bed is fully machine washable.","2,300",R.drawable.bed);
        ShopList.add(mShop);

        mShop = new Shop("Pet Bowl","These bowls are made of heavy duty stainless steel which prevents them from rusting. The silicone base at the bottom does not let the bowl to skid while your pet eats , giving them a perfect eating time.","500",R.drawable.bowl);
        ShopList.add(mShop);

        mShop = new Shop("Clothing","Very good quality and soft padded vest harness Extremely soft touch and comfortable wear Suitable for wearing in Autumn and Winter Make your pet fashionable as you at home or outside.","550",R.drawable.clothing);
        ShopList.add(mShop);

        mShop = new Shop("Pet Crate","Flight dog and cat cages and plastic crates are often used for this purpose. They can provide your pet with a “den” of his own, to provide him comfort while you are traveling as well as while you are outdoors.","1,000",R.drawable.crate);
        ShopList.add(mShop);


        ShopAdapter shopAdapter = new ShopAdapter(Shopping.this,ShopList);
        mRecyclerView.setAdapter(shopAdapter);

    }
}
