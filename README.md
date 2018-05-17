# android_onboard
Android Onborder Library

<image src="https://github.com/pembajak/android_onboard/blob/master/Art/1.png?raw=true" width="150px"> <image src="https://github.com/pembajak/android_onboard/blob/master/Art/2.png?raw=true" width="150px"> <image src="https://github.com/pembajak/android_onboard/blob/master/Art/3.png?raw=true" width="150px"><image src="https://github.com/pembajak/android_onboard/blob/master/Art/4.png?raw=true" width="150px">

### Gradle

Add dependency in your build.gradle

```groovy
compile 'com.babbicool:Android_Onboard:0.1'
```

#### Implementation
```java
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
    ```
