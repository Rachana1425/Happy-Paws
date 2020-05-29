package com.example.rachana.happypaww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MediumBreed extends AppCompatActivity {
    ListView listView;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_breed);

        listView = (ListView) findViewById(R.id.listViewMedium);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("Medium Breeds");
        setSupportActionBar(toolBar);
        final String[] values = new String[]{
                "Bulldog","Dalmatian","Drever","Poodle","American Staffordshire terrier","Keeshond"
        };
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), BullDog.class);
                    startActivityForResult(intent, 0);
                }
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Dalmatian.class);
                    startActivityForResult(intent, 0);
                }
            }
        });


    }
}
