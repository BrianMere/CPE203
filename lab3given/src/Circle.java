import java.awt.Color;
import java.awt.Point;
import java.lang.Math;

public class Circle implements Shape{

    private double radius;
    private Point center;
    private Color color;

    // Implemented Methods
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
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public void translate(Point p) {
        center.setLocation(center.getX() + p.getX(), center.getY() + p.getY());
    }

    // New Methods

    public Circle(double radius, Point center, Color color){
        setRadius(radius);
        this.center = center;
        setColor(color);
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public Point getCenter(){
        return this.center;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        return o instanceof Circle && ((Circle) o).getRadius() == radius && ((Circle) o).getCenter().equals(center) && ((Circle) o).getColor().equals(color);
    }
    
}
