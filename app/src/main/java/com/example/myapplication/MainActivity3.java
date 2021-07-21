package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    String HB;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        NumberFormat.getCurrencyInstance(localeID);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button verif2 = findViewById(R.id.verif2);

        final EditText hbr = findViewById(R.id.hbr);
        final TextView hasil = findViewById(R.id.hasil);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        verif2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    HB = hbr.getText().toString();

                    if (hbr.getText().toString().length() == 0) {
                        hbr.setError("Masukkan Harga Barang!");
                    }

                    int HargaBarang = Integer.parseInt(hbr.getText().toString());
                    double ppn = (HargaBarang * 0.1);
                    String hasilya = String.valueOf(ppn);

                    hasil.setText("PPNnya Adalah " + formatRupiah.format((Double.parseDouble(hasilya))));
                }
                catch (Exception e){
                    Log.e("Error", String.valueOf(e));
                    hasil.setText("0");
                    toast = Toast.makeText(getApplicationContext(), "Masukkan Harga !", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){

            case R.id.back_kembali:
                intent = new Intent(MainActivity3.this , MainActivity.class);
                finish();
                break;

            case R.id.info_menu:
                intent = new Intent(MainActivity3.this , infoppn.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}