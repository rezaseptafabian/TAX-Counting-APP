package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageButton buttoncamera = findViewById(R.id.buttoncamera);
        ImageButton buttonwifi = findViewById(R.id.buttonwifi);
        ImageButton buttonbluetooth = findViewById(R.id.buttonbluetooth);
        ImageButton buttonmaps = findViewById(R.id.buttonmaps);

        buttoncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent C = new Intent(setting.this , Camera.class);
                startActivity(C);
            }
        });

        buttonwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent A = new Intent(setting.this, wifi.class);
                startActivity(A);
            }
        });

        buttonbluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent A = new Intent(setting.this, bluetooth.class);
                startActivity(A);
            }
        });

        buttonmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent A = new Intent(setting.this, CurrentLocation.class);
                startActivity(A);

            }
        });
    }
}