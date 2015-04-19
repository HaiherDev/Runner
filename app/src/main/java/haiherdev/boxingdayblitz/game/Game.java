package haiherdev.boxingdayblitz.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;

import haiherdev.boxingdayblitz.R;
import haiherdev.boxingdayblitz.activity.PlayActivity;
import haiherdev.boxingdayblitz.manager.OptionsManager;
import haiherdev.boxingdayblitz.object.Background.Background;
import haiherdev.boxingdayblitz.object.Background.Layer;

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

        initBackground(size);
        invalidate();
    }

    private void initBackground (Point size) {
        ArrayList<Layer> layers = new ArrayList<Layer>();
        Resources res = getResources();

        //sky layer
        layers.add(new Layer (BitmapFactory.decodeResource(res, R.drawable.sky1), 0, 0, size.x, size.y, 0));

        //buildings3 layer
        layers.add(new Layer (BitmapFactory.decodeResource(res, R.drawable.buildings3),
                0, (int) (size.y*0.1), size.x, (int) (size.y*0.8), 0.1));

        //buildings2 layer
        layers.add(new Layer (BitmapFactory.decodeResource(res, R.drawable.buildings2),
                0, (int) (size.y*0.1), size.x, (int) (size.y*0.8), 0.2));

        //buildings1 layer
        layers.add(new Layer (BitmapFactory.decodeResource(res, R.drawable.buildings1),
                0, (int) (size.y*0.2), size.x, (int) (size.y*0.8), 0.3));

        //fog layer
        layers.add(new Layer (BitmapFactory.decodeResource(res, R.drawable.fog1),
                0, (int) (size.y*0.5), size.x, (int) (size.y*0.35), 0));

        //road layer
        layers.add(new Layer (BitmapFactory.decodeResource(res, R.drawable.road2),
                0, (int) (size.y - size.y*0.15), size.x, (int) (size.y*0.15), 1.3));

        this.background = new Background(layers);
    }

    @Override
    public void onDraw (Canvas c) {
        background.update();
        background.render(c);

        //send updates and renders to other stuff

        invalidate();
    }


}
