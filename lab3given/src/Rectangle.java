import java.awt.Color;
import java.awt.Point;

public class Rectangle implements Shape{

    private double width;
    private double height;
    private Point topLeft;
    private Color color;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void translate(Point p) {
        topLeft.setLocation(topLeft.getX() + p.getX(), topLeft.getY() + p.getY());
    }

    // Begin new methods

    public Rectangle(double width, double height, Point topLeft, Color color){
        setWidth(width);
        setHeight(height);
        this.topLeft = topLeft;
        setColor(color);
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public Point getTopLeft(){
        return topLeft;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Rectangle && 
        ((Rectangle) o).getWidth() == width && 
        ((Rectangle) o).getHeight() ==  height && 
        ((Rectangle) o).getTopLeft().equals(topLeft) && 
        ((Rectangle) o).getColor().equals(color);
    }
    
}
