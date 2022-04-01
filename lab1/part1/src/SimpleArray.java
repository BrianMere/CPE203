
public class SimpleArray {

  /**
   * Write a function that takes in an applicant's numerical scores and returns
   * Boolean values to tell us if they are above a certain threshold.
   * 
   * For example, if the applicant's scores are [80, 85, 89, 92, 76, 81], and the
   * threshold value is 85, return [false, false, true, true, false, false].
   * 
   * @param scores    The applicant's array of scores
   * @param threshold The threshold value
   * @return An array of boolean values: true if the score is higher than
   *         threshold, false otherwise
   */
  public static boolean[] applicantAcceptable(int[] scores, int threshold) {
    boolean[] highScores = new boolean[scores.length];
    for (int i = 0; i < highScores.length; i++)
      highScores[i] = SimpleIf.analyzeApplicant(scores[i], threshold);
    return highScores;
  }
}
