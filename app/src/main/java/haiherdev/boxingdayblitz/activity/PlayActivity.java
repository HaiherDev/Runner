package haiherdev.boxingdayblitz.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import haiherdev.boxingdayblitz.game.Game;
import haiherdev.boxingdayblitz.manager.OptionsManager;

/**
 * Created by David on 3/25/2015.
 */
public class PlayActivity extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        setContentView(new Game (this, new OptionsManager(), size));
    }

    public void pause () {
        Intent intent = new Intent(this, PauseGameActivity.class);
        startActivity(intent);
    }

}
