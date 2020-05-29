package com.example.rachana.happypaww;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {
    Button buttonFood,buttonShop,buttonDog,buttonCat,buttonBlood,buttonLocation;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inputFragmentView = inflater.inflate(R.layout.fragment_home_service, container, false);

        buttonFood = (Button) inputFragmentView.findViewById(R.id.buttonFood);
        buttonFood.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Recycle.class);
                        startActivity(i);
                    }
                }
        );

        buttonShop = (Button) inputFragmentView.findViewById(R.id.buttonShop);
        buttonShop.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Shopping.class);
                        startActivity(i);
                    }
                }
        );

        buttonDog = (Button) inputFragmentView.findViewById(R.id.buttonDog);
        buttonDog.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), DogBreeds.class);
                        startActivity(i);
                    }
                }
        );

        buttonCat = (Button) inputFragmentView.findViewById(R.id.buttonCat);
        buttonCat.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), CatBreeds.class);
                        startActivity(i);
                    }
                }
        );

        buttonBlood = (Button) inputFragmentView.findViewById(R.id.buttonBlood);
        buttonBlood.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Blood.class);
                        startActivity(i);
                    }
                }
        );

        buttonLocation = (Button) inputFragmentView.findViewById(R.id.buttonLocation);
        buttonLocation.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), MapsActivity.class);
                        startActivity(i);
                    }
                }
        );

        return inputFragmentView;
    }
}
