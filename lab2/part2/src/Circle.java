public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.setCenter(center);
        this.setRadius(radius);
    }

    public double perimeter(){
        return getRadius() * 2 * Math.PI; // P = Circum = 2PI*r
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
