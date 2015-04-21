package haiherdev.boxingdayblitz.object.Background;

import android.graphics.Canvas;

/**
 * Created by David on 4/21/2015.
 */
public abstract class Layer {

    private double x, y, width, height;

    public abstract void update();
    public abstract void render(Canvas c);


    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
        this.y = y;
    }

    public double getWidth () {
        return width;
    }

    public double getHeight () {
        return height;
    }

    public void setWidth (double width) {
        this.width = width;
    }

    public void setHeight (double height) {
        this.height = height;
    }
}
