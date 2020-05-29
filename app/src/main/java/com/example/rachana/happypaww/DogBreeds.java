package com.example.rachana.happypaww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DogBreeds extends AppCompatActivity {

    ListView listView;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_breeds);

        listView = (ListView) findViewById(R.id.listViewDog);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("Dog Breeds");
        setSupportActionBar(toolBar);

        final String[] values = new String[]{
                "Small","Medium","Large"
        };
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);

        listView.setAdapter(mAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(view.getContext(),SmallBreed.class);
                        startActivityForResult(intent, 0);
                    }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(),MediumBreed.class);
                    startActivityForResult(intent, 0);
                }
                if(position == 2){
                    Intent intent = new Intent(view.getContext(),LargeBreed.class);
                    startActivityForResult(intent, 0);
                }

                Toast.makeText(getApplicationContext(),
                        "You have selected : " + values[position],
                        Toast.LENGTH_SHORT).show();
                }
            });
    }
}
