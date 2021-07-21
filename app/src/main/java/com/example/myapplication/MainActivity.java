package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton buttonpbb = findViewById(R.id.buttonpbb);
        ImageButton buttonppn = findViewById(R.id.buttonppn);
        ImageButton buttonppnbm = findViewById(R.id.buttonppnbm);
        ImageButton buttonsett = findViewById(R.id.buttonsett);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        buttonpbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent A = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(A);
            }
        });

        buttonppn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent B = new Intent(MainActivity.this , MainActivity3.class);
                startActivity(B);
            }
        });

        buttonppnbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent C = new Intent(MainActivity.this , MainActivity4.class);
                startActivity(C);
            }
        });

        buttonsett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent D = new Intent(MainActivity.this , setting.class);
                startActivity(D);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent = null;
        switch (item.getItemId()){
            case R.id.exit_menu:
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                break;
            case R.id.info_menu:
                intent = new Intent(MainActivity.this , info_menu_pajak.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}


