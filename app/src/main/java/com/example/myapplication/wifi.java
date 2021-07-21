package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;


public class wifi extends AppCompatActivity {

    SwitchCompat switchCompat;
    ImageView imageView;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        switchCompat = findViewById(R.id.switch_button);
        imageView = findViewById(R.id.image_view);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.of));

        if (wifiManager.isWifiEnabled()){
            Toast.makeText(this, " Device ada WIFI", Toast.LENGTH_SHORT).show();
            switchCompat.setChecked(true);
        }else{
            Toast.makeText(this, " WIFI OFF", Toast.LENGTH_SHORT).show();
            switchCompat.setChecked(false);

        }

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.on));
                    wifiManager.setWifiEnabled(true);
                }else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.of));
                    wifiManager.setWifiEnabled(false);
                }
            }
        });
    }
}

            /*@Override
            public void onClick(View v) {
                if(switchCompat.isChecked()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.on));
                    WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.of));
                    WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);

                }
            }
        });*/
