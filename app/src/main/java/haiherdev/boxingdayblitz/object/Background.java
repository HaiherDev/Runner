package haiherdev.boxingdayblitz.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

/**
 * Created by David on 3/26/2015.
 */
public class Background extends GameObject {

    private Bitmap bitmap;
    private double
            posX = 0,
            posY = 0,
            scrollSpeed;

    public Background (Bitmap bitmap, Point location, Point size, int scrollSpeed) {
        this.bitmap = bitmap;
        this.scrollSpeed = scrollSpeed;
        this.posX = location.x;
        this.posY = location.y;
        int height = size.y;
        int width = size.x;
        int bitmapHeight = height;
        int bitmapWidth = width * (bitmap.getHeight() / height);

        bitmap = Bitmap.createScaledBitmap(bitmap, bitmapWidth, bitmapHeight, true);
    }

    public Background (Bitmap bitmap, Point location, Point size) {
        this(bitmap, location, size, 0);
    }

    private void scrollX () {
        posX-= scrollSpeed;
        if (posX < -bitmap.getWidth())
            posX = 0;
    }

    @Override
    public void update() {
        scrollX();
    }

    @Override
    public void render(Canvas c) {
        Paint p = new Paint();
        c.drawBitmap(bitmap, (int) posX, (int) posY, p);
        c.drawBitmap(bitmap, (int) posX + bitmap.getWidth(), (int) posY, p);
    }

    @Override
    public void input(MotionEvent e) {}
}
