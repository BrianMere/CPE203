import java.util.List;

public class Polygon {
    private List<Point> points;

    public Polygon(List<Point> points){
        setPoints(points);
    }

    public double perimeter(){
        double sum = 0.0;
        int size = getPoints().size();
        for(int i = 0; i < size; i++){
            Point p1 = getPoints().get(i); // return first point
            Point p2 = getPoints().get((i+1)%size); //return next point, where it'll wrap around the list for the last side/point
            sum += getLineLength(p1, p2);
        }
        return sum;
    }

    /** Method that returns the distance between any two 2D-Points
     * 
     * @param p1 Point 1 
     * @param p2 Point 2
     * @return the distance between the points
     */
    private static double getLineLength(Point p1, Point p2){
        return
        Math.sqrt(
            Math.pow(p1.getX() - p2.getX(), 2) +
            Math.pow(p1.getY() - p2.getY(), 2)
            );
    }

    public List<Point> getPoints(){
        return this.points;
    }

    private void setPoints(List<Point> points){
        this.points = points;
    }
}
