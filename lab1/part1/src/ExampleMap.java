
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> output = new LinkedList<>();
    Set<String> keys = scoresByApplicantName.keySet();
    boolean good = true;
    for (String name : keys){
      good = true;
      List<CourseGrade> courseGrades = scoresByApplicantName.get(name);
      for (CourseGrade grade : courseGrades){
        if (grade.getScore() <= scoreThreshold) { // Check case if there's a grade under or at the threshold
          good = false;
          break; // Don't add the applicants that meet the condition!
        }
      }
      if(good){
        output.add(name); // Add the candidate if they're good enough
      }
    }
    return output;
  }
}
