public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight){
        this.setTopLeft(topLeft);
        this.setBottomRight(bottomRight);
    }

    public double perimeter(){
        // return twice the length of the change in X and Y
        Point p1 = getTopLeft();
        Point p2 = getBottomRight();
        Point pr = new Point(p2.getX(), p1.getY()); //topright point
        Point pd = new Point(p1.getX(), p2.getY()); //bottomleft point
        return (
            getLineLength(p1, pd) +
            getLineLength(p1, pr) +
            getLineLength(pd, p2) +
            getLineLength(pr, p2)
        );
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

    public Point getTopLeft(){
        return this.topLeft;
    }

    public Point getBottomRight(){
        return this.bottomRight;
    }
    
    private void setTopLeft(Point tl){
        this.topLeft = tl;
    }

    private void setBottomRight(Point br){
        this.bottomRight = br;
    }
}
