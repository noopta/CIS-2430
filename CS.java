import java.util.ArrayList;
/**
 * Write a description of class CS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CS
{
    // instance variables - replace the example below with your own
    private String title;
    ArrayList<Course> listOfRequiredCourseCodes;
    ArrayList<Course> allTheCoursesPlannedAndTaken;
    /**
     * Constructor for objects of class CS
     */
    public CS()
    {
        // initialise instance variables
        listOfRequiredCourseCodes = new ArrayList<Course>();
        allTheCoursesPlannedAndTaken = new ArrayList<Course>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setDegreeTitle(String title)
    {
        // put your code here
        this.title = title;
    }
    
    public String getDegreeTitle(){
    return title;
    }
    
    public void setRequiredCourses(ArrayList<Course> listOfRequiredCourseCodes){
    this.listOfRequiredCourseCodes = listOfRequiredCourseCodes;
    }
    
    public ArrayList<Course> getRequiredCourses(){
    return listOfRequiredCourseCodes;
    }
    
    public boolean meetsRequirements(ArrayList<Course> allTheCoursesPlannedAndTaken){
    return true;
    }
    
    public ArrayList<Course> remainingRequirements(ArrayList<Course> allTheCoursesPlannedAndTaken){
    return allTheCoursesPlannedAndTaken;
    }
}
