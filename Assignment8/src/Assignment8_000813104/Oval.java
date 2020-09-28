package Assignment8_000813104;

/**
 * This class use to draw the Oval on the canvas
 *
 * @author Abhay Panchal
 *
 * 000813104
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends Shape{
    //initializing instance variables
    private double x,y,x1,y1;
    private int r;
    private Color strokeColor;
    private Color ovalColor;

    /**
     *
     * @param x Starting x coordinates
     * @param y Starting y coordinates
     * @param x1 Ending x coordinates
     * @param y1 Ending y coordinates
     * @param r Radius
     * @param strokeColor StrokeColor
     */
    public Oval(double x, double y, double x1, double y1,int r, Color strokeColor) {
        super(x, y, x1, y1);
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.r = r;
        this.strokeColor = strokeColor;
    }

    /**
     * Get method for Radius
     * @return r
     */
    public int getR() {
        return r;
    }

    /**
     * get Method for OvalColor
     * @return ovalColor
     */
    public Color getOvalColor() {
        return ovalColor;
    }

    /**
     * get Method for StrokeColor
     * @return strokeColor
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    /**
     * This Method use to Draw the Oval on Canvas
     * @param gc
     */
    public void draw(GraphicsContext gc) {

        gc.setFill(getOvalColor());
        double width = Math.abs(x1-x);
        double height = Math.abs(y1 - y);
        gc.setStroke(getStrokeColor());
        gc.fillOval(getX()-r,getY()-r,width,height);
        gc.strokeOval(getX()-r,getY()-r,width,height);
    }
}
