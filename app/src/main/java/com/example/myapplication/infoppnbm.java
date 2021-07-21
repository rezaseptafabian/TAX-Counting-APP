package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

import fragment.PageFragmentPPNBM1;
import fragment.PageFragmentPPNBM2;

public class infoppnbm extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoppnbm);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragmentPPNBM1());
        list.add(new PageFragmentPPNBM2());


        pager = findViewById(R.id.pager);
        pagerAdapter = new slidepager(getSupportFragmentManager(),list);

        pager.setAdapter(pagerAdapter);
    }
}