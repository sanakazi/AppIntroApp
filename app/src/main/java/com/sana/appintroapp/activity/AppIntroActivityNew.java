package com.sana.appintroapp.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.sana.appintroapp.R;
import com.sana.appintroapp.adapter.ScreenSlidePagerAdapter;
import com.sana.appintroapp.custom.AutoScrollViewPager;
import com.sana.appintroapp.custom.CirclePageIndicator;


public class AppIntroActivityNew extends Activity {

    private BroadcastReceiver mRegistrationBroadcastReceiver;
    public static final String TAG = AppIntroActivityNew.class.getSimpleName();
    private TextView getStartedBtn;
    private AutoScrollViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    private ScreenSlidePagerAdapter mPagerAdapter;
    private TextView tvSignUp;
    TextView btn_signup;
    boolean isLogedin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    //    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_app_intro_activity_new);
     //   sharedPreferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
     //   isLogedin=sharedPreferences.getBoolean("isLogedin",false);
        initialize();

    }

    private void initialize() {

        viewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
        circlePageIndicator = (CirclePageIndicator)  findViewById(R.id.indicator);
        getStartedBtn =(TextView) findViewById(R.id.btn_login);
        btn_signup =(TextView) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(AppIntroActivityNew.this, MainActivity.class));

            }
        });

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(AppIntroActivityNew.this, MainActivity.class));

            }
        });
        mPagerAdapter = new ScreenSlidePagerAdapter(AppIntroActivityNew.this);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {

            @Override
            public void transformPage(View page, float position) {
                // TODO Auto-generated method stub
            }

        });
        circlePageIndicator.setViewPager(viewPager);
        viewPager.setInterval(5000);
        viewPager.startAutoScroll();
    }




    @Override
    protected void onPause() {
        super.onPause();
        // stop auto scroll when onPause
        viewPager.stopAutoScroll();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // start auto scroll when onResume
        viewPager.startAutoScroll();



    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
//		FlurryAgent.onStartSession(this, Apis.FLURRY_KEY);
//		FlurryAgent.logEvent(TrainningSlidesActivity.class.getSimpleName());
    }
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
//		FlurryAgent.endTimedEvent(TrainningSlidesActivity.class.getSimpleName());
//		FlurryAgent.onEndSession(this);
    }


}
