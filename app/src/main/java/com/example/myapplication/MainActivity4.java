package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity4 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    RadioGroup rgK;
    RadioButton rbK1, rbK2, rbK3, rbK4;
    String HB;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        NumberFormat.getCurrencyInstance(localeID);
        rgK = (RadioGroup) findViewById(R.id.rgK);
        rbK1 = (RadioButton) findViewById(R.id.rbK1);
        rbK2 = (RadioButton) findViewById(R.id.rbK2);
        rbK3 = (RadioButton) findViewById(R.id.rbK3);
        rbK4 = (RadioButton) findViewById(R.id.rbK4);
        Button verif3 = findViewById(R.id.verif3);
        final EditText hbr = findViewById(R.id.hbr);
        final TextView hasil = findViewById(R.id.hasil);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        verif3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(hbr.getText().toString().length()==0){
                        hbr.setError("Masukkan Harga Barang!");
                    }

                    HB = hbr.getText().toString();
                    int HargaBarang = Integer.parseInt(hbr.getText().toString());
                    int selectedId = rgK.getCheckedRadioButtonId();

                    if (selectedId == rbK1.getId()){
                        double ppnbm = (( HargaBarang * 0.1) + (HargaBarang * 0.2));
                        String hasilbm = String.valueOf(ppnbm);
                        hasil.setText(formatRupiah.format(Double.parseDouble(hasilbm)));
                    } else if (selectedId == rbK2.getId()){
                        double ppnbm = (( HargaBarang * 0.1) + (HargaBarang * 0.4));
                        String hasilbm = String.valueOf(ppnbm);
                        hasil.setText(formatRupiah.format(Double.parseDouble(hasilbm)));
                    } else if (selectedId == rbK3.getId()){
                        double ppnbm = (( HargaBarang * 0.1) + (HargaBarang * 0.5));
                        String hasilbm = String.valueOf(ppnbm);
                        hasil.setText(formatRupiah.format(Double.parseDouble(hasilbm)));
                    } else if (selectedId == rbK4.getId()){
                        double ppnbm = (( HargaBarang * 0.1) + (HargaBarang * 0.75));
                        String hasilbm = String.valueOf(ppnbm);
                        hasil.setText(formatRupiah.format(Double.parseDouble(hasilbm)));
                    } else {
                        Toast.makeText(getApplicationContext(), "Pilih Kategori!", Toast.LENGTH_LONG).show();
                    }
                } catch(Exception e){
                    Log.e("Error", String.valueOf(e));
                    hasil.setText("0");
                    toast = Toast.makeText(getApplicationContext(), "Masukin Harga !", Toast.LENGTH_SHORT);
                    toast.show();
                }}

        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){

            case R.id.back_kembali:
                intent = new Intent(MainActivity4.this , MainActivity.class);
                finish();
                break;

            case R.id.info_menu:
                intent = new Intent(MainActivity4.this , infoppnbm.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}