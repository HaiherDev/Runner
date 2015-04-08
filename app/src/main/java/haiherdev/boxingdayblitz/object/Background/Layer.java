package haiherdev.boxingdayblitz.object.Background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
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

    private void initBitmap (Bitmap bitmap) {
        int bitmapHeight = height;
        int bitmapWidth = width * (bitmap.getHeight() / height);

        this.bitmap = Bitmap.createScaledBitmap(bitmap, bitmapWidth, bitmapHeight, true);
    }

    protected void update () {
        scrollX ((int) (Global.playerSpeed/scaleSpeed));
    }

    protected void render (Canvas c) {
        Paint p = new Paint();
        c.drawBitmap(bitmap, getX(), getY(), p);
        c.drawBitmap(bitmap, getX() + bitmap.getWidth(), getY(), p);
    }

    private void scrollX (int scrollSpeed) {
        setX(getX() - scrollSpeed);
        if (getX() < -bitmap.getWidth())
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
}
