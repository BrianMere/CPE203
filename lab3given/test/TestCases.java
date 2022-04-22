import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.Color;
import java.awt.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /* some sample tests but you must write more! see lab write up */

   @Test
   public void testCircleGetArea()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(101.2839543, c.getArea(), DELTA);
   }

   @Test
   public void testRectangleGetArea() {
      Rectangle r = new Rectangle(1.23, 4.56, new Point(1, 2), Color.BLUE);

      assertEquals(5.6088, r.getArea(), DELTA);
   }

   @Test
   public void testTriangleGetArea() {
      Triangle t = new Triangle(new Point(0, 0), new Point(2, 0), new Point(1,1), Color.ORANGE);

      assertEquals(1.0, t.getArea(), DELTA);

      t = new Triangle(new Point(1, 1), new Point(-1, 10), new Point(-2,1), Color.ORANGE);

      assertEquals(13.5, t.getArea(), DELTA);

      t = new Triangle(new Point(10, -20), new Point(0, 15), new Point(-2,7), Color.ORANGE);

      assertEquals(75.0, t.getArea(), DELTA);
   }

   @Test
   public void testCircleGetPerimeter()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(35.6759261, c.getPerimeter(), DELTA);
   }

   @Test
   public void testRectangleGetPerimeter() {
      Rectangle r = new Rectangle(Math.PI, Math.E, new Point(-1, -2), Color.GREEN);

      assertEquals(11.7197489641, r.getPerimeter(), DELTA);
   }

   @Test
   public void testTriangleGetPerimeter() {
      Triangle t = new Triangle(new Point(1, 3), new Point(2, 3), new Point(2,2), Color.LIGHT_GRAY);

      assertEquals(3.4142135624, t.getPerimeter(), DELTA);
   }

   @Test
   public void testColors() {
      Circle c = new Circle(2.4, new Point(1,4), Color.ORANGE);
      Rectangle r = new Rectangle(1.3, 5.9, new Point(0, 2), Color.WHITE);
      Triangle t = new Triangle(new Point(3,3), new Point(4, 6), new Point(7,10), Color.BLACK);

      assertEquals(Color.ORANGE, c.getColor());
      c.setColor(Color.BLUE);
      assertEquals(Color.BLUE, c.getColor());

      assertEquals(Color.WHITE, r.getColor());
      r.setColor(Color.RED);
      assertEquals(Color.RED, r.getColor());

      assertEquals(Color.BLACK, t.getColor());
      t.setColor(Color.ORANGE);
      assertEquals(Color.ORANGE, t.getColor());
   }

   @Test
   public void testTranslation() {
      Circle c = new Circle(2.4, new Point(1,4), Color.ORANGE);
      Rectangle r = new Rectangle(1.3, 5.9, new Point(0, 2), Color.WHITE);
      Triangle t = new Triangle(new Point(3,3), new Point(4, 6), new Point(7,10), Color.BLACK);

      c.translate(new Point(1,2));
      assertEquals(new Point(2, 6), c.getCenter());

      r.translate(new Point(3,4));
      assertEquals(new Point(3,6), r.getTopLeft());

      t.translate(new Point(5,6));
      assertEquals(new Point(8, 9), t.getVertexA());
      assertEquals(new Point(9, 12), t.getVertexB());
      assertEquals(new Point(12, 16), t.getVertexC());
   }

   @Test
   public void testGettersSetters() {
      Circle c = new Circle(1.2, new Point(0,1), Color.yellow);
      Rectangle r = new Rectangle(7.2, 6.9, new Point(-1, 2), Color.RED);
      Triangle t = new Triangle(new Point(4,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      // Circle Getters/Setters
      assertEquals(1.2, c.getRadius(), DELTA);
      c.setRadius(3.4);
      assertEquals(3.4, c.getRadius(), DELTA);
      assertEquals(new Point(0,1), c.getCenter());

      // Rectangle Getters/Setters
      assertEquals(7.2, r.getWidth(), DELTA);
      r.setWidth(2.1);
      assertEquals(2.1, r.getWidth(), DELTA);
      assertEquals(6.9, r.getHeight(), DELTA);
      r.setHeight(4.5);
      assertEquals(4.5, r.getHeight(), DELTA);
      assertEquals(new Point(-1,2), r.getTopLeft());

      // Triangle Getters
      assertEquals(new Point(4,7), t.getVertexA());
      assertEquals(new Point(4,6), t.getVertexB());
      assertEquals(new Point(2,1), t.getVertexC());
   }

   @Test
   public void testEquals() {
      Circle c1 = new Circle(1.2, new Point(0,1), Color.yellow);
      Rectangle r1 = new Rectangle(7.2, 6.9, new Point(-1, 2), Color.RED);
      Triangle t1 = new Triangle(new Point(4,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      // Completely different
      Circle c2 = new Circle(2.4, new Point(1,4), Color.ORANGE);
      Rectangle r2 = new Rectangle(1.3, 5.9, new Point(0, 2), Color.WHITE);
      Triangle t2 = new Triangle(new Point(3,3), new Point(4, 6), new Point(7,10), Color.BLACK);

      // Slightly different
      Circle c3 = new Circle(1.2, new Point(0,1), Color.GREEN);
      Rectangle r3 = new Rectangle(7.2, 6.8, new Point(-1, 2), Color.RED);
      Triangle t3 = new Triangle(new Point(5,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      // Exactly the same
      Circle c4 = new Circle(1.2, new Point(0,1), Color.yellow);
      Rectangle r4 = new Rectangle(7.2, 6.9, new Point(-1, 2), Color.RED);
      Triangle t4 = new Triangle(new Point(4,7), new Point(4, 6), new Point(2,1), Color.CYAN);
      
      // Circles
      assertTrue(c1.equals(c4));
      assertTrue(c1.equals(c1));
      assertFalse(c1.equals(c2));
      assertFalse(c1.equals(c3));

      // Rectangles
      assertTrue(r1.equals(r4));
      assertTrue(r1.equals(r1));
      assertFalse(r1.equals(r2));
      assertFalse(r1.equals(r3));

      // Triangles
      assertTrue(t1.equals(t4));
      assertTrue(t1.equals(t1));
      assertFalse(t1.equals(t2));
      assertFalse(t1.equals(t3));
   }

   @Test
   public void testGetWorkSpaceShapes() {
      Circle c1 = new Circle(1.2, new Point(0,1), Color.yellow);
      Rectangle r1 = new Rectangle(7.2, 6.9, new Point(-1, 2), Color.RED);
      Triangle t1 = new Triangle(new Point(4,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      Circle c2 = new Circle(2.4, new Point(1,4), Color.ORANGE);
      Rectangle r2 = new Rectangle(1.3, 5.9, new Point(0, 2), Color.WHITE);
      Triangle t2 = new Triangle(new Point(3,3), new Point(4, 6), new Point(7,10), Color.BLACK);

      Circle c3 = new Circle(1.2, new Point(0,1), Color.GREEN);
      Rectangle r3 = new Rectangle(7.2, 6.8, new Point(-1, 2), Color.RED);
      Triangle t3 = new Triangle(new Point(5,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      Circle c4 = new Circle(1.2, new Point(0,1), Color.yellow);
      Rectangle r4 = new Rectangle(7.2, 6.9, new Point(-1, 2), Color.RED);
      Triangle t4 = new Triangle(new Point(4,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      WorkSpace ws = new WorkSpace();
      ws.add(c1);
      ws.add(c2);
      ws.add(r1);
      ws.add(r2);
      ws.add(t1);
      ws.add(c3);
      ws.add(r3);
      ws.add(t2);
      ws.add(t3);
      ws.add(c4);
      ws.add(r4);
      ws.add(t4);

      // Get Circles
      List<Circle> list1 = new ArrayList<Circle>();
      list1.add(c1);
      list1.add(c2);
      list1.add(c3);
      list1.add(c4);
      assertEquals(list1, ws.getCircles());

      // Get Rectangles
      List<Rectangle> list2 = new ArrayList<Rectangle>();
      list2.add(r1);
      list2.add(r2);
      list2.add(r3);
      list2.add(r4);
      assertEquals(list2, ws.getRectangles());

      // Get Triangles
      List<Triangle> list3 = new ArrayList<Triangle>();
      list3.add(t1);
      list3.add(t2);
      list3.add(t3);
      list3.add(t4);
      assertEquals(list3, ws.getTriangles());
      
      // Get Shapes by Color
      List<Shape> list4 = new ArrayList<Shape>();
      list4.add(r1);
      list4.add(r3);
      list4.add(r4);
      assertEquals(list4, ws.getShapesByColor(Color.RED));
   }

   @Test
   public void testGettersAndSizeWorkSpace() {
      Circle c3 = new Circle(1.2, new Point(0,1), Color.GREEN);
      Circle c4 = new Circle(1.2, new Point(0,1), Color.yellow);

      WorkSpace ws = new WorkSpace();
      
      ws.add(c3);
      ws.add(c4);

      assertEquals(c3, ws.get(0));
      assertEquals(c4, ws.get(1));
      assertEquals(2, ws.size());
   }

   @Test
   public void testWorkSpaceAreaOfAllShapes()
   {
      WorkSpace ws = new WorkSpace();

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
                 Color.BLACK));

      assertEquals(114.2906063, ws.getAreaOfAllShapes(), DELTA);
   }

   @Test
   public void testWorkSpacePerimeterAllShapes() {
      WorkSpace ws = new WorkSpace();

      Circle c1 = new Circle(1.2, new Point(0,1), Color.yellow);

      Circle c2 = new Circle(2.4, new Point(1,4), Color.ORANGE);
      Rectangle r2 = new Rectangle(1.3, 5.9, new Point(0, 2), Color.WHITE);

      Triangle t3 = new Triangle(new Point(5,7), new Point(4, 6), new Point(2,1), Color.CYAN);

      ws.add(c1);
      ws.add(c2);
      ws.add(t3);
      ws.add(r2);

      assertEquals(50.5270491, ws.getPerimeterOfAllShapes(), DELTA);
   }

   @Test
   public void testWorkSpaceGetCircles()
   {
      WorkSpace ws = new WorkSpace();
      List<Circle> expected = new LinkedList<>();

      // Have to make sure the same objects go into the WorkSpace as
      // into the expected List since we haven't overriden equals in Circle.
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Circle c2 = new Circle(1.11, new Point(-5, -3), Color.RED);

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(c1);
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
                 Color.BLACK));
      ws.add(c2);

      expected.add(c1);
      expected.add(c2);

      // Doesn't matter if the "type" of lists are different (e.g Linked vs
      // Array).  List equals only looks at the objects in the List.
      assertEquals(expected, ws.getCircles());
   }

   /* HINT - comment out implementation tests for the classes that you have not 
    * yet implemented */
   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getRadius", "setRadius", "getCenter", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getWidth", "setWidth", "getHeight", "setHeight", "getTopLeft", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {double.class}, 
         new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testTriangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getVertexA", "getVertexB", "getVertexC", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         Point.class, Point.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[0], new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Triangle.class, expectedMethodNames,
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
}
