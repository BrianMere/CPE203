import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalTime;
import java.util.Collection;

import org.junit.Test;

public class TestCases
{
   @Test
   public void testExercise1()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      ArrayList classes = new ArrayList<CourseSection>();
      classes.add(one);
      classes.add(two);

      final Student s1 = new Student("Johnny", "John", 20, classes);
      final Student s2 = new Student("Johnny", "John", 20, classes);

      assertTrue(one.equals(two));
      assertTrue(two.equals(one));

      assertTrue(s1.equals(s2));
      assertTrue(s2.equals(s1));
   }

   @Test
   public void testExercise2()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(1, 10), LocalTime.of(2, 0));

      ArrayList classes1 = new ArrayList<CourseSection>();
      ArrayList classes2 = new ArrayList<CourseSection>();
      classes1.add(one);
      classes2.add(two);

      final Student s1 = new Student("Johnny", "John", 20, classes1);
      final Student s2 = new Student("Johnny", "John", 20, classes2);

      assertFalse(one.equals(two));
      assertFalse(two.equals(one));

      assertFalse(s1.equals(s2));
      assertFalse(s2.equals(s1));
   }

   @Test
   public void testExercise3()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertEquals(one.hashCode(), two.hashCode());

      ArrayList classes = new ArrayList<CourseSection>();
      classes.add(one);
      classes.add(two);

      final Student s1 = new Student("Johnny", "John", 20, classes);
      final Student s2 = new Student("Johnny", "John", 20, classes);

      assertEquals(s1.hashCode(), s2.hashCode());
   }

   @Test
   public void testExercise4()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
         LocalTime.of(9, 10), LocalTime.of(10, 0));

      assertNotEquals(one.hashCode(), two.hashCode());

      ArrayList classes1 = new ArrayList<CourseSection>();
      ArrayList classes2 = new ArrayList<CourseSection>();
      classes1.add(one);
      classes2.add(two);

      final Student s1 = new Student("Johnny", "John", 20, classes1);
      final Student s2 = new Student("Johnny", "John", 20, classes2);

      assertNotEquals(s1.hashCode(), s2.hashCode());
   }

   @Test
   public void testExerciseNULL()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = null;
      final CourseSection three = new CourseSection(null, "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection four = new CourseSection(null, "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));

      ArrayList classes1 = new ArrayList<CourseSection>();
      classes1.add(one);

      final Student s1 = new Student("Johnny", "John", 20, classes1);
      final Student s2 = new Student("Johnny", "John", 20, null);
      final Student s3 = new Student("Johnny", "John", 20, null);

      assertFalse(one.equals(two));
      assertFalse(one.equals(three));
      assertTrue(three.equals(four));
      assertNotEquals(one.hashCode(), three.hashCode());

      assertFalse(s1.equals(s2));
      assertFalse(s2.equals(s1));
      assertTrue(s3.equals(s2));
      assertNotEquals(s1.hashCode(), s2.hashCode());
   }
}
