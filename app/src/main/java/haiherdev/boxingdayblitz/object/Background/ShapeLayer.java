package haiherdev.boxingdayblitz.object.Background;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
/**
 * Created by David on 4/21/2015.
 */
public class ShapeLayer extends Layer{

    private Drawable shape;

    public ShapeLayer (Drawable shape, double x, double y, double width, double height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);

        initShape(shape);
    }

    private void initShape (Drawable shape) {
        shape.setBounds((int) getX(), (int) getY(), (int) (getX() + getWidth()), (int) (getY() + getHeight()));
        setShape(shape);
    }

    @Override
    public void update() {}

    @Override
    public void render(Canvas c) {
        shape.draw(c);
    }

    public void setShape (Drawable shape) {
        this.shape = shape;
    }

    public Drawable getShape () {
        return shape;
    }
}
