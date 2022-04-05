public class Bigger {
    public static double whichIsBigger(Circle circle, Rectangle rectangle, Polygon polygon){
        double p_cir = Util.perimeter(circle);
        double p_rect = Util.perimeter(rectangle);
        double p_poly = Util.perimeter(polygon);
        return Math.max(Math.max(p_cir, p_rect), p_poly);
    }
}
