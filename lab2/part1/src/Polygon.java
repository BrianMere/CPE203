import java.util.List;

public class Polygon {
    private List<Point> points;

    public Polygon(List<Point> points){
        setPoints(points);
    }

    public List<Point> getPoints(){
        return this.points;
    }

    private void setPoints(List<Point> points){
        this.points = points;
    }
}
