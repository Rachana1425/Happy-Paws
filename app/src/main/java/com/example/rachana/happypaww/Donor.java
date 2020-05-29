package com.example.rachana.happypaww;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Donor extends AppCompatActivity {
    EditText name, email, age, phnum, address;
    FirebaseDatabase database;
    DatabaseReference reff;
    Member member;
    Button button;
    Spinner spinner;
    int maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        name = findViewById(R.id.et1);
        email = findViewById(R.id.et2);
        age = findViewById(R.id.et3);
        phnum = findViewById(R.id.et4);
        address = findViewById(R.id.et5);


        button = findViewById(R.id.butt);

        spinner = findViewById(R.id.spinner2);
        member = new Member();
        reff = database.getInstance().getReference("Data").child("1");

        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose group");
        categories.add("1.1");
        categories.add("1.2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("Dal");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("choose event")) {

                } else {
                    String item = adapterView.getItemAtPosition(i).toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, Object> map = new HashMap<>();
                map.put("Owner name", name.getText().toString());
                map.put("dog's age", age.getText().toString());
                map.put("phone number", phnum.getText().toString());
                map.put("address", address.getText().toString());
                map.put("email id", email.getText().toString());
                map.put("blood group", spinner.getSelectedItem().toString());


                reff.setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.i("Yasasvi", "onComplete:");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Yasasvi", "onFailure:" + e.toString());
                    }
                });
                Toast.makeText(getApplicationContext(), "Thank you for your interest.We will be back to you soon!", Toast.LENGTH_LONG).show();

            }
        });

        String spin = spinner.getSelectedItem().toString();
        if (spinner != null) {

            member.setSpinner(spin);

            reff.child(String.valueOf(maxid + 1)).setValue(member);

        }
    }
}
