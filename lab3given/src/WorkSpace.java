import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class WorkSpace {
    private List<Shape> shapes;

    public WorkSpace(){
        this.shapes = new ArrayList<Shape>();
    }

    public void add(Shape shape){
        shapes.add(shape);
    }

    public Shape get(int index){
        return shapes.get(index);
    }

    public int size(){
        return shapes.size();
    }

    public List<Circle> getCircles(){
        List<Circle> output = new ArrayList<Circle>();
        for(Shape shape : shapes){
            if(shape instanceof Circle){
                output.add((Circle) shape);
            }
        }
        return output;
    }

    public List<Rectangle> getRectangles(){
        List<Rectangle> output = new ArrayList<Rectangle>();
        for(Shape shape : shapes){
            if(shape instanceof Rectangle){
                output.add((Rectangle) shape);
            }
        }
        return output;
    }

    public List<Triangle> getTriangles(){
        List<Triangle> output = new ArrayList<Triangle>();
        for(Shape shape : shapes){
            if(shape instanceof Triangle){
                output.add((Triangle) shape);
            }
        }
        return output;
    }

    public List<Shape> getShapesByColor(Color color){
        List<Shape> output = new ArrayList<Shape>();
        for(Shape shape : shapes){
            if(shape.getColor() == color){
                output.add((Triangle) shape);
            }
        }
        return output;
    }

    public double getAreaOfAllShapes(){
        double sum = 0;
        for(Shape shape : shapes){
            sum += shape.getArea();
        }
        return sum;
    }

    public double getPerimeterOfAllShapes(){
        double sum = 0;
        for(Shape shape : shapes){
            sum += shape.getPerimeter();
        }
        return sum;
    }
}
