package com.babbicool.widget.onboard;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.airbnb.paris.Paris;
import com.babbicool.widget.onboard.views.CircleIndicatorView;

import java.util.List;

public abstract class OnboardActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private Integer[] colors;
    private CircleIndicatorView circleIndicatorView;
    private ViewPager vpOnboarderPager;
    private OnboardAdapter onboarderAdapter;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarder);
        setStatusBackgroundColor();
        hideActionBar();

        circleIndicatorView = (CircleIndicatorView) findViewById(R.id.circle_indicator_view);
        btnFinish = (Button) findViewById(R.id.buttonFinish);
        vpOnboarderPager = (ViewPager) findViewById(R.id.vp_onboarder_pager);
        vpOnboarderPager.addOnPageChangeListener(this);
        btnFinish.setOnClickListener(this);

    }

    public void setOnboardPagesReady(List<OnboardPage> pages) {
        onboarderAdapter = new OnboardAdapter(pages, getSupportFragmentManager());
        vpOnboarderPager.setAdapter(onboarderAdapter);
        circleIndicatorView.setPageIndicators(pages.size());
    }



    public void setStatusBackgroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_transparent));
        }
    }

    public void setButtonStyle(@StyleRes int styleResId){
        Paris.styleBuilder(btnFinish).add(styleResId).apply();
    }

    public void setFinishText(String text){
        btnFinish.setText(text);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.buttonFinish){
            onFinishButtonPressed();
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        circleIndicatorView.setCurrentPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    abstract public void onFinishButtonPressed();

}
