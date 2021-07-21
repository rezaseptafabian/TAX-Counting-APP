package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fragment.PageFragmentPBB1;
import fragment.PageFragmentPBB2;

public class infopbb extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopbb);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragmentPBB1());
        list.add(new PageFragmentPBB2());


        pager = findViewById(R.id.pager);
        pagerAdapter = new slidepager(getSupportFragmentManager(),list);

        pager.setAdapter(pagerAdapter);


    }
}