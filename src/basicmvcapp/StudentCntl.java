package basicmvcapp;

public class StudentCntl {

    private static final int STARTING_INDEX_OF_DISPLAY = 0;
    StudentList studentList;
    StudentUI studentUI;
    StudentTableModel studentTableModel;
    

    public StudentCntl() {
        studentList = new StudentList();
        studentTableModel = new StudentTableModel(studentList.getStudentList());
        studentUI = new StudentUI(this, STARTING_INDEX_OF_DISPLAY); // pass 0 so UI starts at first element in list
        studentUI.setVisible(true);
    }

    Student getStudent(int index) {
        // you'll need to change this to return the Student item at the given index in StudentList
        return studentList.getStudentList().get(index);
    }
    
    public InstrumentTableModel getInstrumentTableModel(){
        return studentTableModel;
    }

}
