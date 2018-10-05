package basicmvcapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentDetailUI extends JFrame {

    private int indexOfElementToDisplay;
    private boolean addNewButtonPressed;

    private final JTextField firstNameDisplayValue = new JTextField(15);
    private final JTextField lastNameDisplayValue = new JTextField(15);
    private final JTextField gpaDisplayValue = new JTextField(15);

    private JPanel studentPanel;
    private JPanel buttonPanel;
    
    private Student currentStudent;

    private final StudentCntl parentStudentCntl;

    public StudentDetailUI(StudentCntl studentCntl, int startingIndexOfDisplay) {
        parentStudentCntl = studentCntl;
        indexOfElementToDisplay = startingIndexOfDisplay;
        currentStudent = parentStudentCntl.getStudent(startingIndexOfDisplay);
        initComponents();
        parseCurrentStudent();
        setFieldView();
    }

    private void initComponents() {
        setTitle("Student Viewer");
        setSize(600, 400);
        setLocationRelativeTo(null);  // center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentPanel = new JPanel(new GridLayout(5, 1));
        studentPanel.add(new JLabel("First Name"));
        studentPanel.add(firstNameDisplayValue);
        studentPanel.add(new JLabel("Last Name"));
        studentPanel.add(lastNameDisplayValue);
        studentPanel.add(new JLabel("GPA"));
        studentPanel.add(gpaDisplayValue);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton nextButton = new JButton("Next");
        JButton lastButton = new JButton("Previous");
        JButton addButton = new JButton("New");
        JButton saveButton = new JButton("Add/Save Change");
        JButton removeButton = new JButton("Remove From List");
     
        nextButton.addActionListener(event -> showNextStudent(indexOfElementToDisplay));
        lastButton.addActionListener(event -> showPreviousStudent(indexOfElementToDisplay));
        addButton.addActionListener(event -> newStudent());
        saveButton.addActionListener(event -> saveChange(indexOfElementToDisplay));
        saveButton.addActionListener(event -> removeStudent());
        


        buttonPanel.add(nextButton);
        buttonPanel.add(lastButton);
        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(removeButton);
        

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(studentPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setFieldView() {
        firstNameDisplayValue.setText(parentStudentCntl.getStudent(indexOfElementToDisplay).getFirstName());
        lastNameDisplayValue.setText(parentStudentCntl.getStudent(indexOfElementToDisplay).getLastName());
        gpaDisplayValue.setText(String.valueOf(parentStudentCntl.getStudent(indexOfElementToDisplay).getGpa()));
    }

    private void showNextStudent(int currentIndex) {
        // modify currentIndex as needed; then refresh display with modified index
        currentIndex++;
        if(currentIndex >= parentStudentCntl.studentList.getStudentList().size()){
            currentIndex = 0;
        }
        
        indexOfElementToDisplay = currentIndex;
        
        refreshDisplayWithNewValues(currentIndex);
        
    }
    
    private void showPreviousStudent(int currentIndex) {
        // modify currentIndex as needed; then refresh display with modified index
        currentIndex--;
        if(currentIndex < 0){
            currentIndex = parentStudentCntl.studentList.getStudentList().size() -1 ;
        }
        
        indexOfElementToDisplay = currentIndex;
        
        refreshDisplayWithNewValues(currentIndex);
        
    }
    
    private void newStudent() {
        //Clear the values in the text boxes
        firstNameDisplayValue.setText(null);
        lastNameDisplayValue.setText(null);
        gpaDisplayValue.setText(null);  
        
        addNewButtonPressed = true;
    }
    
    
    private void saveChange(int currentIndex){
        
        //Get the current values in the text boxes
        String firstName = firstNameDisplayValue.getText();
        String lastName = lastNameDisplayValue.getText();
        String gpa = gpaDisplayValue.getText();
        
        //we want to know if we are adding a new student or editing a current one
        //If the add button was previously pressed...
        if(addNewButtonPressed == true){
            //Add the information to a new student and add it to the end of the list
            parentStudentCntl.studentList.getStudentList().add(new Student(firstName, lastName, gpa));
            addNewButtonPressed = false;
        }
        //Else, just edit the student on the current index.
        else{
            parentStudentCntl.studentList.getStudentList().remove(currentIndex);
            parentStudentCntl.studentList.getStudentList().add(new Student(firstName, lastName, gpa));
        }
        
    }
    
    private void removeStudent(){
        parentStudentCntl.studentList.getStudentList().remove(indexOfElementToDisplay);
    }

    void refreshDisplayWithNewValues(int index) {
        // handle correctly the index of the Student you want to display
        setFieldView();
    }
    
    public void parseCurrentStudent(){
        firstNameDisplayValue.setText(currentStudent.getFirstName());
        lastNameDisplayValue.setText(currentStudent.getFirstName());
        gpaDisplayValue.setText(currentStudent.getFirstName());
    }
    
}
