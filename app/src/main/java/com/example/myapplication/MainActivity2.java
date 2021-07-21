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

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    EditText LR,LT,HT,HB ;
    TextView hasil;
    Button buttonpbb;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        NumberFormat.getCurrencyInstance(localeID);
        LR = (EditText) findViewById(R.id.LR);
        LT = (EditText) findViewById(R.id.LT);
        HT = (EditText) findViewById(R.id.HT);
        HB = (EditText) findViewById(R.id.HB);
        buttonpbb = (Button) findViewById(R.id.buttonpbb);
        hasil = (TextView) findViewById(R.id.hasil);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



        buttonpbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (LR.getText().toString().length() == 0) {
                        LR.setError("Luas Bangunan Diperlukan");
                    } else if (LT.getText().toString().length() == 0) {
                        LT.setError("Luas Tanah Diperlukan");
                    } else if (HT.getText().toString().length() == 0) {
                        HT.setError("Nilai Tanah Diperlukan");
                    } else if (HB.getText().toString().length() == 0) {
                        HB.setError("Nilai Bangunan Diperlukan");
                    }

                    int LuasRumah = Integer.parseInt(LR.getText().toString());
                    int LuasTanah = Integer.parseInt(LT.getText().toString());
                    int HargaTanah = Integer.parseInt(HT.getText().toString());
                    int HargaBangunan = Integer.parseInt(HB.getText().toString());


                    int bangunan = (LuasRumah * HargaBangunan);
                    int tanah = (LuasTanah * HargaTanah);

                    double njop = (bangunan + tanah);
                    double njkp = (0.2 * njop);
                    double pbb = (njkp * 0.005);
                    String pbbhasil = String.valueOf(pbb);

                    hasil.setText("PBBnya Adalah " + formatRupiah.format(Double.parseDouble(pbbhasil)));
                }

                catch (Exception e){
                    Log.e("Error", String.valueOf(e));
                    hasil.setText("0");
                    toast = Toast.makeText(getApplicationContext(), "Silahkan Masukkan Yang Kosong", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){

            case R.id.back_kembali:
                intent = new Intent(MainActivity2.this , MainActivity.class);
                finish();
                break;

            case R.id.info_menu:
                intent = new Intent(MainActivity2.this , infopbb.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}