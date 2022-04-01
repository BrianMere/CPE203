
public class BetterLoop {
  /**
   * Accept an applicant if they have at least 4 grades above 85. Their non-CS
   * GPA counts as a grade in this case.
   * 
   * @param scores The applicant's list of scores
   * @return true if the applicant meets the requirements
   */
  public static boolean atLeastFourOver85(int[] scores) {
    int counter = 0;
    for(int score : scores){
      if(score >= 85) {
        counter++;
      }
    }
    if(counter >= 4){
      return true;
    }
    return false;
  }

  /**
   * Compute an applicant's average score in their 5 CS courses (that is, you must
   * NOT consider the final item in the array, the non-CS GPA).
   * 
   * @param scores
   * @return The average score
   */
  public static double average(int[] scores) {
    // Assume that scores.length > 1, since an average cannot exist for a CS class if none have ever been taken
    int sum = 0;
    for(int i = 0; i < scores.length - 1; i++)
      sum += scores[i];
    return (double) sum / (double)scores.length;
  }
}
