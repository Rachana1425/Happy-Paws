package com.example.rachana.happypaww;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pug extends AppCompatActivity {

    TextView textView;
    String pugdes;
    private static final int REQUEST_CALL = 1;
    private TextView callText;
    private Button callBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pug);
        textView = findViewById(R.id.tvPug);

        pugdes = getResources().getString(R.string.pugdes);
        textView.setText(pugdes);
        callText = findViewById(R.id.callTxt);
        callBtn = findViewById(R.id.callButton);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton();
            }
        });
    }

    private void CallButton() {

        String number = callText.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Pug.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Pug.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
            @Override
            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                if (requestCode == REQUEST_CALL) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        CallButton();
                    } else {
                        Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }

