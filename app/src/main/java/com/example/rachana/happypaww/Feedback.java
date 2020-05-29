package com.example.rachana.happypaww;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {
    Button buttonFeed;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        buttonFeed = findViewById(R.id.buttonFeed);
        fAuth = FirebaseAuth.getInstance();
        buttonFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Feedback form");
        dialog.setMessage("Provide us your valuable feedback!");

        LayoutInflater inflater = LayoutInflater.from(this);

        View reg_layout = inflater.inflate(R.layout.send_feedback,null);

        final TextInputEditText edtEmail = reg_layout.findViewById(R.id.edtEmail);
        final TextInputEditText edtName = reg_layout.findViewById(R.id.edtName);
        final TextInputEditText edtFeed = reg_layout.findViewById(R.id.edtFeed);

        dialog.setView(reg_layout);

        dialog.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                    Toast.makeText(Feedback.this, "Please type your email...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(edtName.getText().toString())) {
                    Toast.makeText(Feedback.this, "Please type your Name...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(edtFeed.getText().toString())) {
                    Toast.makeText(Feedback.this, "Please type your Feedback...", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Object value = dataSnapshot.getValue();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Feedback.this, "Failed to read value.", Toast.LENGTH_SHORT).show();

                    }
                });
            myRef.child("Users").child(edtName.getText().toString()).child("Email").setValue(edtEmail.getText().toString());
            myRef.child("Users").child(edtName.getText().toString()).child("Feedback").setValue(edtFeed.getText().toString());
            myRef.child("Users").child(edtName.getText().toString()).child("Name").setValue(edtName.getText().toString());

            Toast.makeText(Feedback.this,"Thanks for your feedback...",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }
}
