import java.util.List;

public class Applicant{
    private String name;
    private List<CourseGrade> grades;

    public Applicant(String name, List<CourseGrade> grades){
        this.name = name;
        this.grades = grades;
    }

    public String getName(){
        return this.name;
    }

    public List<CourseGrade> getGrades(){
        return this.grades;
    }

    public CourseGrade getGradeFor(String course){
        switch(course) {
            default: // Includes "Intro to CS" case
                return getGrades().get(0);
            case "Data Structures":
                return getGrades().get(1);
            case "Algorithms":
                return getGrades().get(2);
            case "Computer Organization":
                return getGrades().get(3);
            case "Operating Systems":
                return getGrades().get(4);
            case "Non-CS":
                return getGrades().get(5);
        }
    }
}