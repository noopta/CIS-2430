
/**
 * Write a description of class Attempt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Attempt
{
    // instance variables - replace the example below with your own
    String grade;
    String semester;
    Course theCourse;
    
    /**
     * Constructor for objects of class Attempt
     */
    public Attempt()
    {
        // initialise instance variables
        theCourse = new Course();        
    }

    
    public String getAttemptGrade()
    {
        // put your code here
        return grade;
    }
    
    public void setAttemptGrade(String grade)
    {
    this.grade = grade;
    }
           
    public String getSemesterTaken()
    {
    return semester;
    }
    
     public void setSemesterTaken(String semester)
    {
     this.semester = semester;   
    }
    
    public Course getCourseAttempted()
    {
    return theCourse;
    }
    
    public void setCourseAttempted(Course theCourse)
    {
    this.theCourse = theCourse;
    }
}
