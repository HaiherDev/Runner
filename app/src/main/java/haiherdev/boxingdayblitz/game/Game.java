package haiherdev.boxingdayblitz.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;

import haiherdev.boxingdayblitz.R;
import haiherdev.boxingdayblitz.activity.PlayActivity;
import haiherdev.boxingdayblitz.manager.OptionsManager;
import haiherdev.boxingdayblitz.object.Background.Background;
import haiherdev.boxingdayblitz.object.Background.BitmapLayer;
import haiherdev.boxingdayblitz.object.Background.Layer;
import haiherdev.boxingdayblitz.object.Background.ShapeLayer;

/**
 * Created by David on 3/25/2015.
 */
public class Game extends View {

    private OptionsManager oManager;
    private PlayActivity pActivity;
    private Background background;


    /*
    testing
     */


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
        layers.add(new ShapeLayer (res.getDrawable(R.drawable.sky),
                0, 0, size.x, size.y));

        //buildings3 layer
        layers.add(new BitmapLayer(BitmapFactory.decodeResource(res, R.drawable.buildings_silhouettes_1),
                0, size.y*0.1, size.x, size.y*0.85, 0.1));

//        //buildings2 layer
//        layers.add(new BitmapLayer(BitmapFactory.decodeResource(res, R.drawable.buildings2),
//                0, size.y*0.1, size.x, size.y*0.8, 0.2));
//
//        //buildings1 layer
//        layers.add(new BitmapLayer(BitmapFactory.decodeResource(res, R.drawable.buildings1),
//                0, size.y*0.2, size.x, size.y*0.8, 0.3));

        //road layer
        layers.add(new ShapeLayer(res.getDrawable(R.drawable.road),
                0, size.y*0.85, size.x, size.y*0.15));

        //fog layer
        layers.add(new ShapeLayer(res.getDrawable(R.drawable.fog),
                0, size.y*0.6, size.x, size.y*0.25));

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
