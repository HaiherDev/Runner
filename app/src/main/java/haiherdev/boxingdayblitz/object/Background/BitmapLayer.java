package haiherdev.boxingdayblitz.object.Background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import haiherdev.boxingdayblitz.Global;

/**
 * Created by David on 4/8/2015.
 */
public class BitmapLayer extends Layer {

    private Bitmap bitmap;
    private double scaleSpeed;

    public BitmapLayer(Bitmap bitmap, double x, double y, double width, double height, double scaleSpeed) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        this.scaleSpeed = scaleSpeed;

        initBitmap (bitmap);
    }

    private void initBitmap (Bitmap bitmap) {
        int bitmapWidth, bitmapHeight;

        double k = bitmap.getHeight() / getHeight();

        bitmapWidth = (int) (bitmap.getWidth() / k);
        bitmapHeight = (int) getHeight();


        this.bitmap = Bitmap.createScaledBitmap(bitmap, bitmapWidth, bitmapHeight, true);
    }

    @Override
    public void update () {
        scrollX ((int) (Global.playerSpeed*scaleSpeed));
    }

    @Override
    public void render (Canvas c) {
        Paint p = new Paint();

        int repeats = (int) (getWidth() / bitmap.getWidth());
        for (int i = 0; i <= repeats + 1; i ++) {
            c.drawBitmap(bitmap, (int) getX() + bitmap.getWidth()*i, (int) getY(), p);
        }
    }

    private void scrollX (int scrollSpeed) {
        setX((int) (getX() - scrollSpeed));
        if (getX() <= -bitmap.getWidth())
            setX(0);
    }
}
