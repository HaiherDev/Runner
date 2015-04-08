package haiherdev.boxingdayblitz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import haiherdev.boxingdayblitz.R;


public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.haiherdev.boxingdayblitz.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // loading screen stuff here

        startActivity(new Intent (this, MainMenuActivity.class));
    }
}
