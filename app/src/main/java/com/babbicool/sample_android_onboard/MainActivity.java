package com.babbicool.sample_android_onboard;

import android.os.Bundle;

import com.babbicool.widget.onboard.OnboardActivity;
import com.babbicool.widget.onboard.OnboardPage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OnboardActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboardPage OnboardPage1 = new OnboardPage("Title 1", "Desc 1 Desc 1 Desc 1 Desc 1 Desc 1", R.drawable.onboard_1);
        OnboardPage OnboardPage2 = new OnboardPage("Title 1", "Desc 1 Desc 1 Desc 1 Desc 1 Desc 1", R.drawable.onboard_1);
        OnboardPage OnboardPage3 = new OnboardPage("Title 1", "Desc 1 Desc 1 Desc 1 Desc 1 Desc 1", R.drawable.onboard_1);
        OnboardPage OnboardPage4 = new OnboardPage("Title 1", "Desc 1 Desc 1 Desc 1 Desc 1 Desc 1", R.drawable.onboard_1);


        OnboardPage1.setImageBackgroundResourceId(R.drawable.onboard_bg_1); // set drawable background
        OnboardPage2.setImageBackgroundResourceId(R.drawable.onboard_bg_2);
        OnboardPage3.setImageBackgroundResourceId(R.color.link_blue); // set Color background
        OnboardPage4.setImageBackgroundResourceId(R.color.green_chat);

        List<OnboardPage> pages = new ArrayList<>();

        pages.add(OnboardPage1);
        pages.add(OnboardPage2);
        pages.add(OnboardPage3);
        pages.add(OnboardPage4);

        for (OnboardPage page : pages) {
            page.setTitleColor(R.color.grey_1);
            page.setDescriptionColor(R.color.grey_1);
            page.setMultilineDescriptionCentered(true);
        }

        setOnboardPagesReady(pages);

        setButtonStyle(R.style.ButtonBlue);  // set your button style

        setFinishText("Getting Started"); // set your button text
    }

    @Override
    public void onFinishButtonPressed() { // event on click finish button

    }
}
