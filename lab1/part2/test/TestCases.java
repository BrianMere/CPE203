import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestCases
{
   /*
   public static void main(String args[]){ // if you uncomment, make all test cases static
      TestCases.testGetItems();
      TestCases.testApplicants();
   }
   */
   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetItems()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades, 50, 60000, 4);
      assertEquals("Aakash", testApplicant.getName());
      assertEquals(grades, testApplicant.getGrades());
      assertEquals(50, testApplicant.getHours());
      assertEquals(60000, testApplicant.getSalary());
      assertEquals(4, testApplicant.getYear());

      testApplicants();
   }
   
   private void testApplicants(){
      List<Applicant> inputs = new ArrayList<Applicant>();
      //Map<String, List<CourseGrade>> inputs = new HashMap<>();
      
      List<CourseGrade> grades = new ArrayList<CourseGrade>();
      List<String> names = Arrays.asList(
         "Sarah", "Connor", "Megan", "Brian", "John"
      );
      for(int i = 0; i < names.size(); i++){ // Put in expected input values
         grades.add(new CourseGrade("Intro to CS", 100 - i));
         grades.add(new CourseGrade("Data Structures", 95 - 5*i));
         grades.add(new CourseGrade("Algorithms", 91 - 2*i));
         grades.add(new CourseGrade("Computer Organization", 91 - 3*i));
         grades.add(new CourseGrade("Operating Systems", 75 + 3*i));
         grades.add(new CourseGrade("Non-CS", 83 + i));

         inputs.add(new Applicant(names.get(i), new ArrayList<CourseGrade>(grades), 15*i + 25, 50000 + 5000*i, 6 - i));
         grades.clear();
      }
      Applicant app = new Applicant("Good", Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 86),
         new CourseGrade("Non-CS", 90)
      ), 60, 50000, 6); // confirmed good applicant

      inputs.add(app);
      for(Applicant applicant : inputs){
         if (applicant.getName() == "Good")
            assertTrue(SimpleIf.analyzeApplicant2(applicant));
         else
            assertFalse(SimpleIf.analyzeApplicant2(applicant));
      }
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
      TODO: check about the swap in the assertEqual() method with kirsten
    */
   /*
   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getName",
         "getGrades",
         "getGradeFor"
      );

      final List<Class> expectedMethodReturns = Arrays.asList(
         String.class,
         List.class,
         CourseGrade.class
      );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[] { String.class }
         );

      verifyImplSpecifics(Applicant.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields", 0, Applicant.class.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue("Unexpected number of public methods", expectedMethodNames.size()+1 >= publicMethods.size());

      assertTrue("Invalid test configuration", expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration", expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
   */
}
