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

public class CatBreeds extends AppCompatActivity {
    ListView listView;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_breeds);

        listView = (ListView) findViewById(R.id.listViewCat);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("Cat Breeds");
        setSupportActionBar(toolBar);
        final String[] values = new String[]{
                "Indian","Foreign"
        };
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_2,android.R.id.text2,values);

        listView.setAdapter(mAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(view.getContext(),Indian.class);
                    startActivityForResult(intent, 0);
                }
                if(position == 1){
                    Intent intent = new Intent(view.getContext(),Foreign.class);
                    startActivityForResult(intent, 0);
                }

                Toast.makeText(getApplicationContext(),
                        "You have selected : " + values[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

