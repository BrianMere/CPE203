public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.setCenter(center);
        this.setRadius(radius);
    }

    public Point getCenter(){
        return center;
    }

    public double getRadius(){
        return radius;
    }
    
    private void setCenter(Point center){
        this.center = center;
    }

    private void setRadius(double radius){
        this.radius = radius;
    }
}
