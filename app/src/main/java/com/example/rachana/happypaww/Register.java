package com.example.rachana.happypaww;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    NestedScrollView nestedScrollView;

    TextInputLayout textInputLayoutName, textInputLayoutEmail, textInputLayoutPassword;

    TextInputEditText textInputEditTextName, textInputEditTextEmail, textInputEditTextPassword;

    AppCompatButton appCompatButtonRegister;
    AppCompatTextView appCompatTextViewLoginLink;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nestedScrollView = findViewById(R.id.nestedScrollView);

        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);

        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);

        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister);
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),Register.class));
            finish();
        }

        appCompatButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textInputEditTextEmail.getText().toString().trim();
                String password = textInputEditTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    textInputEditTextEmail.setError("Enter valid Email.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    textInputEditTextPassword.setError("Enter valid Password.");
                    return;
                }
                if (password.length()<8){
                    textInputEditTextPassword.setError("Password must be >= 8 characters");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this,"Registered Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }else{
                            Toast.makeText(Register.this,"Error!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        appCompatTextViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }
}
