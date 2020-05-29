package com.example.rachana.happypaww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Blood extends AppCompatActivity {
    ListView listView;
    Toolbar toolBar;
    Button donorbtn,recbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
        listView = findViewById(R.id.listViewBlood);
        donorbtn = findViewById(R.id.donorbtn);
        recbtn = findViewById(R.id.recbtn);
        donorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Donor.class));
            }
        });
        recbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Receiver.class));
            }
        });
        String[] values = new String[] {"FAQ","FeedBack","Contact"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1, values);
        listView.setAdapter(adapter);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("BloodDonation");
        setSupportActionBar(toolBar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(view.getContext(),Faq.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(view.getContext(),Feedback.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(),Contact.class);
                    startActivity(intent);
                }
            }
        });
    }
}
