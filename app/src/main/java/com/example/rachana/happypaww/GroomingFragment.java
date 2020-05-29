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
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

public class GroomingFragment extends Fragment {
    Button buttonHair,buttonShower,buttonNail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inputFragmentView = inflater.inflate(R.layout.fragment_grooming_service, container, false);

        buttonHair = (Button) inputFragmentView.findViewById(R.id.buttonHair);
        buttonHair.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Hair.class);
                        startActivity(i);
                    }
                }
        );
        buttonShower = (Button) inputFragmentView.findViewById(R.id.buttonShower);
        buttonShower.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Shower.class);
                        startActivity(i);
                    }
                }
        );
        buttonNail = (Button) inputFragmentView.findViewById(R.id.buttonNail);
        buttonNail.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Nail.class);
                        startActivity(i);
                    }
                }
        );
        return inputFragmentView;
    }
}



