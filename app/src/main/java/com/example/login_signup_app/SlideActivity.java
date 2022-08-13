package com.example.login_signup_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class SlideActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    SlideViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sldie);

        viewPager=findViewById(R.id.viewPager);
        adapter = new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
}