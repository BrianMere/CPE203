import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape{

    private List<Point> points; // Use a general list but only use like 3 points for a triangle. Use 0 -> a, 1 -> b, ...
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
        int sum = 0;
        for(int i = 0; i < points.size() - 1; i++){
            Point point1 = points.get(i);
            Point point2 = points.get(i+1);
            sum += (point1.getX() * point2.getY()) - (point2.getX() * point1.getY());
        }
        Point point1 = points.get(points.size() - 1);
        Point point2 = points.get(0);
        sum += (point1.getX() * point2.getY()) - (point2.getX() * point1.getY());
        return Math.abs(sum / 2.0);
    }

    @Override
    public double getPerimeter() {
        double sum = 0;
        for(int i = 0; i < points.size() - 1; i++){
            Point point1 = points.get(i);
            Point point2 = points.get(i+1);
            sum += Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
        }
        Point point1 = points.get(points.size() - 1);
        Point point2 = points.get(0);
        sum += Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
        return sum;
    }

    @Override
    public void translate(Point p) {
        for(Point point : points){
            point.setLocation(point.getX() + p.getX(), point.getY() + p.getY());
        }
    }

    // Begin unique class methods

    public Triangle(Point a, Point b, Point c, Color color){
        points = new ArrayList<Point>();
        points.add(a);
        points.add(b);
        points.add(c);
        this.color = color;
    }

    public Point getVertexA(){
        return points.get(0);
    }

    public Point getVertexB(){
        return points.get(1);
    }

    public Point getVertexC(){
        return points.get(2);
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Triangle &&
        ((Triangle) o).getVertexA().equals(getVertexA()) && 
        ((Triangle) o).getVertexB().equals(getVertexB()) && 
        ((Triangle) o).getVertexC().equals(getVertexC()) && 
        ((Triangle) o).getColor().equals(getColor());
    }
}
