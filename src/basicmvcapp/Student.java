package basicmvcapp;

public class Student {
    
    private final String firstName;
    private final String lastName;
    private final double gpa;

    public Student(String[] studentInfo) {
        // studentInfo has firstName, lastName, gpa
        firstName = studentInfo[0];
        lastName = studentInfo[1];
        gpa = Double.parseDouble(studentInfo[2]);
    }
    
    public Student(String _firstName, String _lastName, String _gpa) {
        // studentInfo has firstName, lastName, gpa
        firstName = _firstName;
        lastName = _lastName;
        gpa = Double.parseDouble(_gpa);
    }
    
    // just getters below

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }
 
}
