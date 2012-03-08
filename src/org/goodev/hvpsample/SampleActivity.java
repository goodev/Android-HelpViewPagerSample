package org.goodev.hvpsample;


import org.goodev.helpviewpager.CirclePageIndicator;
import org.goodev.helpviewpager.OnLastPageListener;
import org.goodev.helpviewpager.PageIndicator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class SampleActivity extends FragmentActivity {
    TestFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_circles);
        
        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
        
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        
        mIndicator.setOnLastPageListener(new OnLastPageListener() {
            @Override
            public void onLastPage() {
                finish();
            }
        });
    }
}