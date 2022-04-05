public class Bigger {
    public static double whichIsBigger(Circle circle, Rectangle rectangle, Polygon polygon){
        double p_cir = circle.perimeter();
        double p_rect = rectangle.perimeter();
        double p_poly = polygon.perimeter();
        return Math.max(Math.max(p_cir, p_rect), p_poly);
    }
}
