public class PathNode {


    private Point point;
    private PathNode priorNode;

    public PathNode(Point point, PathNode priorNode){
        this.point = point;
        this.priorNode = priorNode;
    }

    public Point getPoint(){
        return point;
    }

    public PathNode getPriorNode(){ return priorNode;}

    @Override
    public int hashCode(){
        return point.hashCode(); // See equals() for reasoning
    }

    @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass()) && this.point.equals(((PathNode) o).point); // We want to use an equals method that just has each main point as ONE point (priorNode will ebb and flow)
    }
}
