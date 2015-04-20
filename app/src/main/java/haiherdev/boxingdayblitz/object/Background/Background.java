package haiherdev.boxingdayblitz.object.Background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

import java.util.ArrayList;

import haiherdev.boxingdayblitz.Global;
import haiherdev.boxingdayblitz.object.GameObject;

/**
 * Created by David on 3/26/2015.
 */
public class Background extends GameObject {

    private ArrayList<Layer> layers;

    public Background (ArrayList<Layer> layers) {
        this.layers = layers;
    }

    @Override
    public void update() {
        for (Layer l : layers) {
            l.update();
        }
    }

    @Override
    public void render(Canvas c) {
        for (Layer l : layers) {
            l.render(c);
        }
    }

    @Override
    public void input(MotionEvent e) {}
}
