
import java.util.List;
import java.util.LinkedList;

public class SimpleList {

  /**
   * Write a function that takes in an applicant's numerical scores and returns
   * Boolean values to tell us if they are above a certain threshold.
   * 
   * For example, if the applicant's scores are [80, 85, 89, 92, 76, 81], and the
   * threshold value is 85, return [false, false, true, true, false, false].
   * 
   * This is very similar to the SimpleArray exercise, but this time using LISTS
   * instead of ARRAYS.
   * 
   * @param scores    The applicant's array of scores
   * @param threshold The threshold value
   * @return An array of boolean values: true if the score is higher than
   *         threshold, false otherwise
   */
  public static List<Boolean> applicantAcceptable(List<Integer> scores, int threshold) {
    List<Boolean> highScores = new LinkedList<Boolean>();
    for (Integer score : scores){
      highScores.add(SimpleIf.analyzeApplicant(score, threshold));
    }
    return highScores;
  }
}
