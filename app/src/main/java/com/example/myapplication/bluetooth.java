package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;


public class bluetooth extends AppCompatActivity {

    SwitchCompat switchCompat ;
    ImageView imageView ;
    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        switchCompat = findViewById(R.id.switch_bluetooth);
        imageView = findViewById(R.id.image_view);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));


        if(bluetoothAdapter == null){
            Toast.makeText(this," Device Tidak Ada Bluetooth", Toast.LENGTH_SHORT).show();
        }else {
            switchCompat.setChecked(false);
            Toast.makeText(this, "Bluetooth OFF", Toast.LENGTH_SHORT).show();
        }

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchCompat.isChecked()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.onn));
                    bluetoothAdapter.enable();
                }else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
                    bluetoothAdapter.disable();
                }

            }
        });

        /*switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCompat.isChecked()){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.onn));
                    bluetoothAdapter.enable();
                }else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
                    bluetoothAdapter.disable();
                }
            }
        });*/
    }
}