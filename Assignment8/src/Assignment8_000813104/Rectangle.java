package Assignment8_000813104;

/**
 * Main class to create the rectangle
 *
 * @author Abhay PAnchal
 *
 * 000813104
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    private double x,y,x1,y1,w;
    private Color rectangleColor;
    private Color strokeColor;

    /**
     *
     * @param rx Starting x coordinates
     * @param ry Starting y coordinates
     * @param sx Ending x coordinates
     * @param sy Ending y coordinates
     * @param w Width
     * @param rectangleColor rectangle color
     */
    public Rectangle(double rx, double ry, double sx, double sy,int w,Color rectangleColor) {
        super(rx, ry, sx, sy);
        this.x=rx;
        this.y = ry;
        this.x1=sx;
        this.y1=sy;
        this.w= w;
        this.rectangleColor = rectangleColor;
    }

    /**
     *
     * @return strokeColor
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * method for set the width
     * @param w Width
     */
    public void setW(double w){
        this.w= w;
    }

    /**
     * This method use to draw the Rectangle on the Canvas
     * @param gc Graphics context for drawing shapes
     */
    public void draw(GraphicsContext gc){
        gc.setFill(rectangleColor);
        double abx = Math.abs(x1-x);
        double aby = Math.abs(y1 - y);
        double minX = Math.min(x1,x);
        double minY = Math.min(y1,y);
        gc.setStroke(getStrokeColor());
        gc.setLineWidth(w);
        gc.fillRect(minX,minY,abx,aby);
    }
}
