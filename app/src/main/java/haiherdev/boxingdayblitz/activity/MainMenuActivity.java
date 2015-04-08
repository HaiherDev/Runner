package haiherdev.boxingdayblitz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import haiherdev.boxingdayblitz.R;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the text view as the activity layout
        setContentView(R.layout.activity_main_menu);
    }

    /* Called when the user clicks the options button */
    public void optionsClick (View view) {
        Intent intent = new Intent(this, OptionsMenuActivity.class);
        startActivity(intent);
    }

    /* Called when the user clicks the play button */
    public void playClick (View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}
