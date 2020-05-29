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

public class VeterinaryFragment extends Fragment {
    Button buttonSur,buttonInt,buttonDent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inputFragmentView = inflater.inflate(R.layout.fragment_veterinary_service, container, false);

        buttonSur = (Button) inputFragmentView.findViewById(R.id.buttonSur);
        buttonSur.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Surgical.class);
                        startActivity(i);
                    }
                }
        );
        buttonInt = (Button) inputFragmentView.findViewById(R.id.buttonInt);
        buttonInt.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), IntMed.class);
                        startActivity(i);
                    }
                }
        );
        buttonDent = (Button) inputFragmentView.findViewById(R.id.buttonDent);
        buttonDent.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Dental.class);
                        startActivity(i);
                    }
                }
        );
        return inputFragmentView;
    }
}
