import java.util.List;

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

  /**
   * Takes in another applicant object and tests ALL of their subfields to make sure that they pass the required tests. 
   * Similar to the first version of the method
   * @param applicant
   * @return if the applicant is up to snuff by their qualifications or not
   */
  public static boolean analyzeApplicant2(Applicant applicant){
    List<CourseGrade> grades = applicant.getGrades();
    for(CourseGrade grade : grades){
      if(!analyzeApplicant(grade.getScore(), 85)){ // keep ideal threshold to 85. If it fails at any point then fail them. 
        return false;
      }
      if(applicant.getHours() < 50 || applicant.getSalary() >= 75000 && applicant.getYear() <= 3){ // Only accept seniors, with a 50+ hour commitment and a < 75000 expected salary
        return false;
      }
    }
    return true;
  }
}
