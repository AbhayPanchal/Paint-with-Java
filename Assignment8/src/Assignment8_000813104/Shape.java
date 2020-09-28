package Assignment8_000813104;

import javafx.scene.canvas.GraphicsContext;

/**
 * This is the main abstract class for creating shapes
 *
 * @Author Abhay Panchal
 * 000813104
 */

public abstract class Shape {
private double x;
private double y;
private double x1,y1;

    /**
     *
     * @param x Starting coordinates of shapes
     * @param y Starting Coordinates of shape
     * @param x1 Ending Coordinates of shape
     * @param y1 Ending Coordinates of shape
     */

    public Shape(double x, double y, double x1, double y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    /**
     * method for first X coordinates
     * @return x Coordinates
     */
    public double getX(){
        return x;
    }

    /**
     * method for first y coordinates
     * @return y Coordinates
     */
    public double getY() {
        return y;
    }

    /**
     * method for last X coordinates
     * @return x Coordinates
     */
    public double getX1() {
        return x1;
    }

    /**
     * method for Last Y coordinates
     * @return Y Coordinates
     */
    public double getY1() {
        return y1;
    }

    /**
     *  This is the abstract method which will be used in their child class
     * @param gc Graphics context for drawing shapes
     */
    public abstract void draw(GraphicsContext gc);
}
