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
public class Layer {

    private Bitmap bitmap;
    private int x, y, width, height;
    private double scaleSpeed;

    public Layer (Bitmap bitmap, int x, int y, int width, int height, double scaleSpeed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scaleSpeed = scaleSpeed;

        initBitmap (bitmap);
    }

    public Layer (int color, int x, int y, int width, int height) {
        this.bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(color);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        scaleSpeed = 0;
    }

    private void initBitmap (Bitmap bitmap) {
        double k = bitmap.getHeight() / height;
        int bitmapWidth, bitmapHeight;
        bitmapWidth = (int) (bitmap.getWidth() / k);
        bitmapHeight = height;

        this.bitmap = Bitmap.createScaledBitmap(bitmap, bitmapWidth, bitmapHeight, true);
    }

    protected void update () {
        scrollX ((int) (Global.playerSpeed*scaleSpeed));
    }

    protected void render (Canvas c) {
        Paint p = new Paint();

        int repeats = this.width / bitmap.getWidth();
        for (int i = 0; i <= repeats + 1; i ++) {
            c.drawBitmap(bitmap, getX() + bitmap.getWidth()*i, getY(), p);
        }
    }

    private void scrollX (int scrollSpeed) {
        setX(getX() - scrollSpeed);
        if (getX() <= -bitmap.getWidth())
            setX(0);
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public void setX (int x) {
        this.x = x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public int getWidth () {
        return width;
    }

    public int getHeight () {
        return height;
    }

    public void setWidth (int width) {
        this.width = width;
    }

    public void setHeight (int height) {
        this.height = height;
    }
}
