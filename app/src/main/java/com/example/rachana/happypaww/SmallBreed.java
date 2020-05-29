package com.example.rachana.happypaww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmallBreed extends AppCompatActivity {
    ListView listView;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_breed);

        listView = (ListView) findViewById(R.id.listViewSmall);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("Small Breeds");
        setSupportActionBar(toolBar);
        final String[] values = new String[]{
                "Pug", "Shih Tzu", "Bichon Frise", "Dachshund", "German Spitz", "Pomeranian"
        };
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Pug.class);
                    startActivityForResult(intent, 0);
                }
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), ShihTzu.class);
                    startActivityForResult(intent, 0);
                }
                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Bichon.class);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
}