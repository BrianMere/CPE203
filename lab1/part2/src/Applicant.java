import java.util.List;

/**
 * Class used to describe applicants in the hiring process
 * 
 * Data collected includes:
 * @param name - Name of applicant
 * @param grades - List of grades as described by lab1 docs
 * @param hours - Weekly hours available for the job
 * @param salary - Expected salary in USD$
 * @param year - Year that the applicant is in undergrad (ie 1st Year, 2nd, ...)
 * @author Brian Mere
 */
public class Applicant{
    
    private String name;
    private List<CourseGrade> grades;
    private int hours;
    private int salary;
    private int year;

    public Applicant(String name, List<CourseGrade> grades, int hours, int salary, int year){
        this.name = name;
        this.grades = grades;
        this.hours = hours;
        this.salary = salary;
        this.year = year;
    }

    public String getName(){
        return this.name;
    }
    
    public List<CourseGrade> getGrades(){
        return this.grades;
    }

    public int getHours(){
        return this.hours;
    }
    
    public int getSalary(){
        return this.salary;
    }

    public int getYear(){
        return this.year;
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