package haiherdev.boxingdayblitz.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import haiherdev.boxingdayblitz.R;
import haiherdev.boxingdayblitz.manager.option.BoolOption;
import haiherdev.boxingdayblitz.manager.option.Option;
import haiherdev.boxingdayblitz.manager.OptionsManager;


public class OptionsMenuActivity extends ActionBarActivity {

    private final static String PREFS_NAME = "haiherdev.boxingdayblitz.optionsPREFNAME";

    private OptionsManager oManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        oManager = OptionsManager.newInstance(this, PREFS_NAME);

        //set the sound button text
        setButtonText((Button) findViewById(R.id.sound_toggle),
                "Sound: " + oManager.getOption("sound_toggle").getStringValue());

        //set the difficulty button text
        setButtonText((Button) findViewById(R.id.difficulty_toggle),
                "Difficulty: " + oManager.getOption("difficulty").getStringValue());

    }

    @Override
    protected void onStop () {
        super.onStop();
        oManager.saveOptions(this, PREFS_NAME);
    }

    //when the user presses the sound button
    public void soundToggle (View view) {
        BoolOption boolOption = ((BoolOption) oManager.getOption("sound_toggle"));
        boolOption.toggle();

        setButtonText((Button) view, "Sound: " + boolOption.getStringValue());
    }

    //when the user presses the difficulty button
    public void difficultyToggle (View view) {
        Option option = oManager.getOption("difficulty");
        switch (option.getStringValue()) {
            case "easy":
                option.setValue("normal");
                break;
            case "normal":
                option.setValue("hard");
                break;
            case "hard":
                option.setValue("easy");
                break;
        }

        setButtonText((Button) view, "Difficulty: " + option.getStringValue());
    }

    private void setButtonText (Button button, String text) {
        button.setText(text);
    }

}
