package haiherdev.boxingdayblitz.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.View;

import haiherdev.boxingdayblitz.R;
import haiherdev.boxingdayblitz.activity.PlayActivity;
import haiherdev.boxingdayblitz.manager.OptionsManager;
import haiherdev.boxingdayblitz.object.Background;

/**
 * Created by David on 3/25/2015.
 */
public class Game extends View {

    private OptionsManager oManager;
    private PlayActivity pActivity;
    private Background background;

    public Game(Context context, OptionsManager oManager, Point size) {
        super(context);

        this.pActivity = (PlayActivity) context;
        this.oManager = oManager;

        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.buildings);

        this.background = new Background(bitmap, new Point (0, 0), size, 7);

        invalidate();
    }


    @Override
    public void onDraw (Canvas c) {
        background.update();
        background.render(c);

        invalidate();
    }


}
