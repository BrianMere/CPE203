import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) throws IOException {

        // File -> List of points
        BufferedReader in_reader = new BufferedReader(new FileReader("assets/input.txt"));
        Stream<String> fileContents = in_reader.lines();
        List<Point> pointList = new ArrayList<>();
        for(String line : fileContents.toList()){
            pointList.add(getPointFromLine(line));
        }
        in_reader.close();
        fileContents.close();

        // Do point stuff here
        Function<Point, Point> func1 = (Point p)->{return new Point(p.x * 0.5, p.y * 0.5, p.z);};
        Function<Point, Point> func2 = (Point p)->{return new Point(p.x - 150, p.y - 37, p.z);};
        pointList = pointList.stream().filter(p->p.z<2.0).map(func1).map(func2).toList();

        // List of points -> File
        FileWriter outFileWriter = new FileWriter("assets/drawMe.txt");
        File out = new File("assets/drawMe.txt");
        out.delete();
        for(Point p : pointList){
            outFileWriter.write(p.toString() + "\n");
        }
        outFileWriter.flush();
        outFileWriter.close();
    }

    private static Point getPointFromLine(String line){
        String[] contents = line.split(",");
        for(int i = 0; i < contents.length; i++){
            contents[i] = contents[i].replaceAll("\\s", "");
        }
        return new Point(Double.parseDouble(contents[0]), Double.parseDouble(contents[1]), Integer.parseInt(contents[2]));
    }
}
