import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PartTwoTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

   // Begin self-written implementation tests

   @Test
   public void testPerimCircle(){
      Circle circle = new Circle(new Point(0,0), Math.sqrt(2));
      assertEquals(circle.perimeter(), Math.sqrt(2)*2*3.14159265, DELTA);
      circle = new Circle(new Point(3.1,2.7), Math.sqrt(2));
      assertEquals(circle.perimeter(), Math.sqrt(2)*2*3.14159265, DELTA);
   }

   @Test
   public void testPerimRect(){
      Rectangle rect = new Rectangle(
         new Point(0,0), new Point(1,1)
         );
      assertEquals(rect.perimeter(), 4.0, DELTA);
      rect = new Rectangle(
         new Point(-1, 1),
         new Point(2.1, 3.4)
      );
      assertEquals(rect.perimeter(), 2*3.1 + 2.4*2, DELTA);
   }

   @Test
   public void testPerimPoly(){
      List<Point> points = new ArrayList<Point>();
      points.add(new Point(0,0));
      points.add(new Point(1,1));
      points.add(new Point(2, 0));
      points.add(new Point(1, -1));
      Polygon poly = new Polygon(points);
      assertEquals(poly.perimeter(), 4*Math.sqrt(2), DELTA);
      points.clear();
      points.add(new Point(1,1));
      points.add(new Point(-1,1));
      points.add(new Point(0, -1));
      assertEquals(poly.perimeter(), 2 + 2*(Math.sqrt(5)), DELTA);
   }

   @Test
   public void testBigger(){
      // List for polygon
      List<Point> points = new ArrayList<Point>();
      points.add(new Point(0,0));
      points.add(new Point(1,1));
      points.add(new Point(2,1));
      points.add(new Point(1,-1));
      points.add(new Point(-1,-1));

      // Shapes:
      Circle circ = new Circle(new Point(1.1, 2.2), Math.PI);
      Rectangle rect = new Rectangle(new Point(-1,1), new Point(2,0));
      Polygon poly = new Polygon(points);

      assertEquals(2*Math.pow(Math.PI, 2), Bigger.whichIsBigger(circ, rect, poly), DELTA);
   }
}
