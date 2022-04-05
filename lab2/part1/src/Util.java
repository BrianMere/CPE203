public class Util {

    public static double perimeter(Circle circle){
        return circle.getRadius() * 2 * Math.PI; // P = Circum = 2PI*r
    }

    public static double perimeter(Rectangle rectangle){
        // return twice the length of the change in X and Y
        Point p1 = rectangle.getTopLeft();
        Point p2 = rectangle.getBottomRight();
        Point pr = new Point(p2.getX(), p1.getY()); //topright point
        Point pd = new Point(p1.getX(), p2.getY()); //bottomleft point
        return (
            getLineLength(p1, pd) +
            getLineLength(p1, pr) +
            getLineLength(pd, p2) +
            getLineLength(pr, p2)
        );
    }

    public static double perimeter(Polygon polygon){
        double sum = 0.0;
        int size = polygon.getPoints().size();
        for(int i = 0; i < size; i++){
            Point p1 = polygon.getPoints().get(i); // return first point
            Point p2 = polygon.getPoints().get((i+1)%size); //return next point, where it'll wrap around the list for the last side/point
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
}
