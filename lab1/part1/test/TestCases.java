import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant()
   {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()
   {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3()
   {
      // Added test case to check on the cusp of passing:
      assertFalse(SimpleIf.analyzeApplicant(84, 84));
      assertFalse(SimpleIf.analyzeApplicant(92, 99));
   }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      // Added test case for if the input scores are the same :
      assertEquals(SimpleIf.maxAverage(21.7, 21.7), 21.7, DELTA);
      assertEquals(SimpleIf.maxAverage(89.9, 90), 90, DELTA);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()
   {
      /* Added test case to make sure that
         this function is not just returning 7. */
      assertEquals(0, SimpleLoop.sum(-10, 10));
      assertEquals(10, SimpleLoop.sum(1, 4));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      // Added test case checking more 'at the cusp of making it' scores (IE score == threshold => false)
      assertArrayEquals(
              new boolean[] {false, false, false, true, true},
              SimpleArray.applicantAcceptable(new int[] {10, 69, 70, 71, 90}, 70)
      );
      assertArrayEquals(
           new boolean[] {false, false, false, true, true, false},
              SimpleArray.applicantAcceptable(new int[] {82, 83, 84, 85, 90, 75}, 84)
      );
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<>(Arrays.asList(80, 85, 89, 92, 76, 81));
      List<Boolean> expected =
         new ArrayList<>(Arrays.asList(false, false, true, true, false, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Boolean> expected = Arrays.asList(false, false, true, true, false, false);
      List<Integer> input = Arrays.asList(80, 85, 89, 92, 76, 81);
      assertEquals(expected, SimpleList.applicantAcceptable(input, 88));

      // Added test case
      expected = Arrays.asList(false, true, false, true, false, false);
      input = Arrays.asList(60, 76, 75, 76, 62, 62);
      assertEquals(expected, SimpleList.applicantAcceptable(input, 75));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {89, 86, 90, 92, 84, 88}));
   }

   @Test
   public void testFourOver85_3()
   {
      // Added test case where the expected result is false
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {10, 10, 10, 10}));
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {85, 80, 85, 75, 80, 92}));
   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
         Arrays.asList(
            new CourseGrade("CPE 123", 89),
            new CourseGrade("CPE 101", 90),
            new CourseGrade("CPE 202", 99),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Zoe",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86),
            new CourseGrade("CPE 473", 90),
            new CourseGrade("CPE 476", 99),
            new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2() {
      // Added test case similar to the one above...

      List<String> names = Arrays.asList("BMoney", "John", "Luke", "Stev@n", "Mat1lda", ""); // Input names
      List<List<CourseGrade>> grades = Arrays.asList(
              Arrays.asList(
                      new CourseGrade("CPE 123", 92),
                      new CourseGrade("CPE 203", 99),
                      new CourseGrade("CPE 471", 97),
                      new CourseGrade("CPE 473", 91),
                      new CourseGrade("CPE 476", 92),
                      new CourseGrade("CPE 572", 100)),
              Arrays.asList(
                      new CourseGrade("CPE 123", 82),
                      new CourseGrade("CPE 203", 89),
                      new CourseGrade("CPE 471", 87),
                      new CourseGrade("CPE 473", 81),
                      new CourseGrade("CPE 476", 82),
                      new CourseGrade("CPE 572", 90)),
              Arrays.asList(
                      new CourseGrade("CPE 123", 12),
                      new CourseGrade("CPE 203", 29),
                      new CourseGrade("CPE 471", 37),
                      new CourseGrade("CPE 473", 41),
                      new CourseGrade("CPE 476", 52),
                      new CourseGrade("CPE 572", 60)),
              Arrays.asList(
                      new CourseGrade("CPE 123", 93),
                      new CourseGrade("CPE 203", 98),
                      new CourseGrade("CPE 471", 98),
                      new CourseGrade("CPE 473", 92),
                      new CourseGrade("CPE 476", 91),
                      new CourseGrade("CPE 572", 100)),
              Arrays.asList(
                      new CourseGrade("CPE 123", 92),
                      new CourseGrade("CPE 203", 99),
                      new CourseGrade("CPE 471", 97),
                      new CourseGrade("CPE 473", 91),
                      new CourseGrade("CPE 476", 92),
                      new CourseGrade("CPE 572", 100)),
              Arrays.asList(
                      new CourseGrade("CPE 123", 91),
                      new CourseGrade("CPE 203", 91),
                      new CourseGrade("CPE 471", 91),
                      new CourseGrade("CPE 473", 91),
                      new CourseGrade("CPE 476", 91),
                      new CourseGrade("CPE 572", 91))
      ); // Input names correlate to these lists of lists (in order)
      List<String> expected = Arrays.asList("BMoney", "Stev@n", "Mat1lda",""); // Expected Students to pass on forward

      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      int counter = 0;
      for(String name : names){
         courseListsByStudent.put(name, grades.get(counter));
         counter++;
      }
      assertEquals(new HashSet<>(expected), new HashSet<>(ExampleMap.highScoringStudents(courseListsByStudent, 90)));
   }
}
