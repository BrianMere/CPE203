public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight){
        this.setTopLeft(topLeft);
        this.setBottomRight(bottomRight);
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
