package basicmvcapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StudentList {

    private final ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
        addStudentsToList();
    }

    private void addStudentsToList() {
        String fileName = "studentInfo.txt";
        File inputFile = new File(fileName);
        try (Scanner in = new Scanner(inputFile)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                // line has firstName, lastName, gpa
                String[] data = line.split(", ");
                getStudentList().add(new Student(data));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    


    /**
     * @return the studentList
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

}
