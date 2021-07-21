package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fragment.PageFragmentPPN1;
import fragment.PageFragmentPPN2;

public class infoppn extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoppn);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragmentPPN1());
        list.add(new PageFragmentPPN2());


        pager = findViewById(R.id.pager);
        pagerAdapter = new slidepager(getSupportFragmentManager(),list);

        pager.setAdapter(pagerAdapter);
    }
}