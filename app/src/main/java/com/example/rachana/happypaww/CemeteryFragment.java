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

public class CemeteryFragment extends Fragment {
    Button buttonBury,buttonCremate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inputFragmentView = inflater.inflate(R.layout.fragment_cemetery_service, container, false);

        buttonBury = (Button) inputFragmentView.findViewById(R.id.buttonBury);
        buttonBury.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Burial.class);
                        startActivity(i);
                    }
                }
        );
        buttonCremate = (Button) inputFragmentView.findViewById(R.id.buttonCremate);
        buttonCremate.setOnClickListener(
                new CardView.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), Cremate.class);
                        startActivity(i);
                    }
                }
        );
        return inputFragmentView;
    }
}
