import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.sql.*;

/**
Anupta Islam 
anupta@uoguelph.ca
CIS 2430 A2 
Student Planner 
 */
public class Planner 
{
    
    /*variable declerations*/
    MyConnection connect;
    
    JFrame adminChange;
    JFrame login;
    JFrame frame;
    JFrame deg;
    JFrame signUps;
    JFrame am;
    JFrame idFrame;
    JFrame studentInput;
    JFrame transcript;
    JFrame removeCourse;
    JFrame editCourses;
    JPanel cards;

    JOptionPane box = new JOptionPane();
     
    
    String firstName;
    String id;
    String getName;
    String getNum;
    
    
    
    
    /**
     * Constructor for objects of class PlannerGUI
     */
    public Planner()
    {
        // initialise instance variables
                
        JFrame maintainCourse = new JFrame("Maintain Courses");
        JFrame addCDB = new JFrame("Add a Course");
        JFrame removeCDB = new JFrame("Remove a Course");
        
        boolean fullyResetTables = true;
        signUps = new JFrame("Sign Up");
        adminChange = new JFrame("Course Options");
        login = new JFrame("User Login");
        idFrame = new JFrame("User Login");
        frame = new JFrame("GUI");
       
        am = new JFrame("Administration");
        removeCourse = new JFrame("Remove Course");
        GridBagConstraints c = new GridBagConstraints();
        deg = new JFrame("Select Degree");
        editCourses = new JFrame("Add Course");
        transcript = new JFrame("Transcript");
        
        JPanel removePanel = new JPanel();
        removePanel.setBackground(Color.WHITE);
        removePanel.setLayout(null);
        
        JLabel removeLabel = new JLabel("Course Name");
        removeLabel.setBounds(30,40,120,30);
        JTextField removeText = new JTextField();
        removeText.setBounds(150,40,120,30);
        
        JButton removeSubmit = new JButton("Submit Course");
        removeSubmit.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {    /*actions listener for the submit button to remove a course*/
       String removeThisCourse = removeText.getText();
       MyConnection c = new MyConnection();
       c.deleteCourse(removeThisCourse);
       removeCDB.setVisible(false);
   }
  });
        removeSubmit.setBounds(150,90,150,30);
        
        removePanel.add(removeLabel);
        removePanel.add(removeText);
        removePanel.add(removeSubmit);
        
        removeCDB.setSize(400,200);        
        removeCDB.setVisible(false);
        removeCDB.setLocationRelativeTo(null);
        removeCDB.getContentPane().add(removePanel);
        removeCDB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*j frame for the remove course panel above*/
        
        JPanel cdbPanel = new JPanel();
        cdbPanel.setBackground(Color.WHITE);
        cdbPanel.setLayout(null);        
        
        /*j frame for adding a course to database below*/
        
        JLabel  cdbLabel1 = new JLabel("Course Name");
        JLabel cdbLabel2 = new JLabel("Credit");
        JLabel cdbLabel3 = new JLabel("Name");
        JLabel cdbLabel4 = new JLabel("Semester");
        JLabel cdbLabel5 = new JLabel("Prereq");
        
        cdbLabel1.setBounds(20,30,80,30);
        cdbLabel2.setBounds(20,80,80,30);
        cdbLabel3.setBounds(20,130,80,30);
        cdbLabel4.setBounds(20,180,80,30);
        cdbLabel5.setBounds(20,230,80,30);
        
        
        
        JTextField cdbText1 = new JTextField();
        JTextField cdbText2 = new JTextField();
        JTextField cdbText3 = new JTextField();
        JTextField cdbText4 = new JTextField();
        JTextField cdbText5 = new JTextField();
        
        JButton submitCourse = new JButton("Submit Course");
        submitCourse.setBounds(110,280,150,30);
        
        submitCourse.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {    
       String getCN = cdbText1.getText();
       String getCredit = cdbText2.getText();
       String getName = cdbText3.getText();
       String getSem = cdbText4.getText();
       String getPre = cdbText5.getText();
       /*passing the user inputs into myconnection to add a course to database*/
       MyConnection connection = new MyConnection();
       connection.addCourse(getCN,getCredit,getName,getSem,getPre);
       
       
   }
  });
        
        cdbText1.setBounds(110,30,100,30);
        cdbText2.setBounds(110,80,100,30);
        cdbText3.setBounds(110,130,100,30);
        cdbText4.setBounds(110,180,100,30);
        cdbText5.setBounds(110,230,100,30);
        
        cdbPanel.add(cdbLabel1);
        cdbPanel.add(cdbLabel2);
        cdbPanel.add(cdbLabel3);
        cdbPanel.add(cdbLabel4);
        cdbPanel.add(cdbLabel5);
        
        cdbPanel.add(cdbText1);
        cdbPanel.add(cdbText2);
        cdbPanel.add(cdbText3);
        cdbPanel.add(cdbText4);
        cdbPanel.add(cdbText5);
        cdbPanel.add(submitCourse);
        
        addCDB.setSize(350,450);
        addCDB.setVisible(false);
        addCDB.getContentPane().add(cdbPanel);
        addCDB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addCDB.setLocationRelativeTo(null);
        
        /*get student ID*/
        JPanel idPanel = new JPanel();
        idPanel.setBackground(Color.WHITE);
        JLabel nums = new JLabel("Student ID");
        
        JTextField studentNum = new JTextField();
        
        JButton idButton = new JButton("Submit");
        
         nums.setBounds(50, 40, 200, 30);
         studentNum.setBounds(120, 40, 200, 30);
         idButton.setBounds(150, 100, 100, 30);
         
         
         idPanel.add(studentNum);
         idPanel.add(idButton);
         idPanel.add(nums);
         idPanel.setLayout(null);
        
        idButton.addActionListener(new ActionListener()
        {
     public void actionPerformed(ActionEvent e)
      {
    // display/center the jdialog when the button is pressed
        
    id = studentNum.getText();
    if(id.isEmpty()){
    box.showMessageDialog(null,"Enter a student number","Title",1);
    frame.setVisible(false);
   }
    
    else{
    frame.setVisible(true);
    }
    
    /**below is a connection test, if the connection to the database is 
       null then print out that it is null. If it has a connection and 
       is not null then print that it is working*/
    connect = new MyConnection(firstName,id); 
    if(connect != null){
         System.out.println("actionPerformed(): connect = null");
         connect.loadStudent(id,firstName);
         System.out.println(firstName +""+ id);   
    }else{
        System.out.println("actionPerformed(): connect != null");
    }

    
   }
  }); 
        
        JPanel first = new JPanel();
        first.setBackground(Color.WHITE);

        JLabel name = new JLabel("Username");
                                
        JTextField fName = new JTextField();       
        
        JButton loginButton = new JButton("Submit");

          name.setBounds(50, 40, 200, 30);
                    
          fName.setBounds(120, 40, 200, 30);
         
          loginButton.setBounds(150, 100, 100, 30);
          
          
          /*frame for sign ups*/ 
          
          JPanel createPanel = new JPanel();
          createPanel.setBackground(Color.WHITE);
          createPanel.setLayout(null);
          
          JButton createButton = new JButton("Submit");
          JLabel signName = new JLabel("Username");
          JLabel newID = new JLabel("Student ID");                       
          JTextField createName = new JTextField();
          JTextField createID = new JTextField();
          
           JButton signUp = new JButton("Sign Up");
           
           signUp.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {    
       signUps.setVisible(true);           /*if sign up is clicked pop up the sign up frame*/     
   }
  });
        createButton.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
    // display/center the jdialog when the button is pressed
    //firstName = fName.getText();
     getName = createName.getText();
     getNum = createID.getText();

    System.out.println("Print out:" +getNum+ " "+ getName);
    
    DBStudent s1 = new DBStudent(getNum,getName);
    MyConnection c = new MyConnection(DBDetails.username,DBDetails.password);
    ArrayList<String> courseList = c.getAllCourses();
    s1.setCourses(courseList);
    c.saveStudent(s1);

    c.loadStudent(getNum,getName);
    //c.saveStudent(newStudent);
    
    
    //c.loadStudent(getNum, getName);
    signUps.setVisible(false);
    //signUps.setVisible(true);                
   }
  });
        signUp.setBounds(20, 100, 100, 30);
          
          signName.setBounds(50,40,200,30);         
          createName.setBounds(120, 40, 200, 30);
          
          newID.setBounds(50,70,200,30);
          createID.setBounds(120,70,200,30);
          
          createButton.setBounds(150, 110,100, 30);
          
          createPanel.add(createButton);
          createPanel.add(signName);
          createPanel.add(newID);
          createPanel.add(createName);
          createPanel.add(createID);
          
        /*create frame for sign up*/
        
          first.add(signUp);
          first.add(fName);
        //first.add(lName);
        
          first.add(loginButton);
          first.add(name);
        //first.add(last);
        first.setLayout(null);
        
        loginButton.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
    // display/center the jdialog when the button is pressed
    firstName = fName.getText();
    
    if(firstName.isEmpty()){
    login.setVisible(true);
    idFrame.setVisible(false);
    box.showMessageDialog(null,"Enter a username","Title",1);
  }
  else{
    idFrame.setVisible(true);
   }   
    
   }
  });
        
        login.setSize(400,200);
        login.getContentPane().add(first);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        signUps.setSize(400,200);
        signUps.getContentPane().add(createPanel);
        signUps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUps.setVisible(false);
        signUps.setLocationRelativeTo(null);
        
        
        
        JPanel adminP = new JPanel();
        BoxLayout boxlayout = new BoxLayout(adminP, BoxLayout.Y_AXIS);

        adminP.setLayout(boxlayout);
        adminP.setBorder(new EmptyBorder(new Insets(20, 120, 100, 100)));
        
        
        JButton option1 = new JButton("Connect to Database");
        option1.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
    // display/center the jdialog when the button is pressed
    System.out.println("actionPerformed(): firsName = " + firstName + " id = " + id);
    MyConnection c = new MyConnection(firstName, id);
    
    
    /*connect to database*/
    PrepStudentScript initTables = new PrepStudentScript(fullyResetTables);
    c.repopulateCourses();  
   
   }
  });
        JButton option2 = new JButton("Maintain List of Courses");
        option2.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
          maintainCourse.setVisible(true);
   }
  });
        
        JButton option3 = new JButton("Maintain List of Degrees");
        
        adminP.add(option1);
        adminP.add(Box.createRigidArea(new Dimension(5,20)));
        adminP.add(option2);
        adminP.add(Box.createRigidArea(new Dimension(5,20)));
        adminP.add(option3);
        
        adminP.setBackground(Color.WHITE);
                                      
       JPanel maintainC1 = new JPanel(); 
                              
       JButton submitRemove = new JButton("Remove Course");
       submitRemove.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
          removeCDB.setVisible(true);
   }
  });
       
       JButton submitChange = new JButton("Change Course");
       JButton submitAdd = new JButton("Add Course");
       submitAdd.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
          addCDB.setVisible(true);
   }
  });
       
       
       submitRemove.setBounds(110,130,180,30);
       submitChange.setBounds(110,80,180,30);
       submitAdd.setBounds(110,30,180,30);
       
       maintainC1.setBackground(Color.WHITE);                
       maintainC1.setLayout(null);       
       maintainC1.add(submitRemove);
       maintainC1.add(submitChange);
       maintainC1.add(submitAdd);
       
       maintainCourse.setSize(400,250);
       maintainCourse.getContentPane().add(maintainC1);
       maintainCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       maintainCourse.setVisible(false);
       maintainCourse.setLocationRelativeTo(null);

        am.setSize(450,250);
        am.getContentPane().add(adminP);
        am.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        am.setVisible(false);
        am.setLocationRelativeTo(null);
        
        
        JPanel degPanel = new JPanel();
        degPanel.setLayout(new GridBagLayout());
        c.insets = new Insets(20,10,10,10);
                        
        JMenuBar menubar = new JMenuBar();
        
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        /*user stories*/
        JMenuItem requiredCourses = new JMenuItem("Required Courses");
        JMenuItem numCreds = new JMenuItem("Number of Credits Needed");
        JMenuItem prereq = new JMenuItem("Prerquisites required");
        JMenuItem prereq2 = new JMenuItem("Prequisites For My Courses");
        JMenuItem credComplete = new JMenuItem("Credits Completed");
        JMenuItem credLeft = new JMenuItem("Credits Remaining");
        JMenuItem coursePlan = new JMenuItem("Course Plan");
        JMenuItem gpa = new JMenuItem("Overall GPA");
        JMenuItem CISgpa = new JMenuItem("GPA for CIS Courses");
        JMenuItem recentGPA = new JMenuItem("GPA for most recent 10 courses");
        
        view.add(requiredCourses);
        view.add(numCreds);
        view.add(prereq);
        view.add(prereq2);
        view.add(credComplete);
        view.add(credLeft);
        view.add(coursePlan);
        view.add(gpa);
        view.add(CISgpa);
        view.add(recentGPA);
        
        JMenu adminMode = new JMenu("Admin Mode"); 
        JMenuItem openAdmin = new JMenuItem("Open");
        /*menubar*/
         openAdmin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        am.setVisible(true);
      }
    });
        adminMode.add(openAdmin);
        
        menubar.add(file);
        
        menubar.add(edit);
        menubar.add(view);
        menubar.add(adminMode);
        
               
        
        String[] degs = {"BCH", "BCG", "SENG"};
        JComboBox degrees = new JComboBox(degs);
        c.gridx = 0;
        c.gridy = 1;
        
        degPanel.add(degrees,c);
              
        
        JButton choiceButton = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 2;
        
        String degreeChoice = degrees.getSelectedItem().toString();
        
        choiceButton.addActionListener(new ActionListener()
        {
  public void actionPerformed(ActionEvent e)
   {
    // display/center the jdialog when the button is pressed
    String degreeChoice = degrees.getSelectedItem().toString();
    if(degreeChoice.equals("BCH")){
    System.out.println("Honors Computing");
    }
    
    if(degreeChoice.equals("BCG")){
    System.out.println("General Computing");
    }
    
    if(degreeChoice.equals("SENG")){
    System.out.println("Software Eng");
    }
   }
  });
        
        degPanel.add(choiceButton,c);
                                       
        JLabel degLabel = new JLabel("Choose Your Degree");  
        degLabel.setFont(new Font("SansSerif", Font.BOLD,18));
        c.gridx= 0;
        c.gridy =0;
        

        degPanel.add(degLabel,c);
        
        degPanel.setBackground(Color.WHITE);
         
        deg.getContentPane().add(degPanel);
        
        
        transcript.setSize(550,650);
        transcript.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        transcript.setVisible(false);
        transcript.setLocationRelativeTo(null);
        /*degree window to choose degree below*/
        deg.setSize(250,250);
        deg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deg.setVisible(false);
        deg.setLocationRelativeTo(null);
        
        idFrame.setSize(400,200);
        idFrame.getContentPane().add(idPanel);
        idFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        idFrame.setVisible(false);
        idFrame.setLocationRelativeTo(null);
        
        JPanel courses = new JPanel();
        courses.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel addCourse = new JLabel("Add Course: ");
        addCourse.setFont(new Font("SSerif",Font.BOLD,18));
        JTextField addC = new JTextField("Enter Course Name Here", 18);
        JButton submitButton = new JButton("Submit");
        
        courses.add(addCourse);
        courses.add(addC);
        courses.add(submitButton);
        
        editCourses.getContentPane().add(courses);
        editCourses.setSize(250,150);
        editCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editCourses.setVisible(false);
        editCourses.setLocationRelativeTo(null);
        
        JPanel removeC = new JPanel();
        removeC.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel remove = new JLabel("Remove Course: ");
        remove.setFont(new Font("SSerif",Font.BOLD,18));
        JTextField remC = new JTextField("Enter Course Name Here", 18);
        JButton submitR = new JButton("Submit");
        
        removeC.add(remove);
        removeC.add(remC);
        removeC.add(submitR);
        /*window to remove courses*/
        removeCourse.getContentPane().add(removeC);
        removeCourse.setSize(250,150);
        removeCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeCourse.setVisible(false);
        removeCourse.setLocationRelativeTo(null);
        
        JPanel main = new JPanel();
        
        
        /*combox for user stories*/
        main.setLayout(new GridBagLayout());
        String[] options = {"Select Option", "Select Degree", "Add Course to POS","Remove Course from POS","Maintain Courses in transcript",
            "Save program"};
            
        c.insets = new Insets(40,10,10,10);            
        
        JComboBox menu = new JComboBox(options);        
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        ActionListener combo = new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
            String s = (String) menu.getSelectedItem();
                                    
            switch(s){
            case "Select Degree":
            deg.setVisible(true);  
                                    
            deg.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                               
                e.getWindow().dispose();
                
            }
            
        });
                        
            break;
            
            case "Add Course to POS":            
            editCourses.setVisible(true);
            break;
            
            case "Remove Course from POS":
            removeCourse.setVisible(true);
            break;
            
            case "Maintain Courses in transcript":            
            transcript.setVisible(true);
            frame.setVisible(false);
            break;
            
            case "Save program":
            System.out.println("save program");
            deg.setVisible(true);
            frame.setVisible(false);
            break;
            }
            }
        };
        
        
        
        menu.addActionListener(combo);
        main.add(menu,c);
        
        
        
        JLabel label2 = new JLabel("Course Planner");
        c.gridx= 1;
        c.gridy =2;
        label2.setFont(new Font("SansSerif", Font.PLAIN,24));
        main.add(label2,c);
                                   
        JLabel pic = new JLabel();
        c.gridx=1;
        c.gridy=0;
        pic.setIcon(new ImageIcon("guelph-icon.png"));
        main.add(pic,c);
        
        main.setBackground(Color.WHITE);
        
        /*main */
        frame.setJMenuBar(menubar);
        frame.getContentPane().add(main);
        frame.setSize(550,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.setLocationRelativeTo(null);
                       
    }
              
    public static void main(String args[]){

        new Planner();
        // calling the GUI
    
     
     }
         
}

