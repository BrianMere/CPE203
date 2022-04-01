
public class SimpleIf {

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than the threshold.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    if (avg > threshold) {
      return true; // Yay!
    }
    return false; // A bit pessimistic!
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    if (avg1 > avg2){
      return avg1;
    }
    return avg2;
  }
}
