package basicmvcapp;

public class StudentCntl {

    private static final int STARTING_INDEX_OF_DISPLAY = 0;
    private StudentTableModel studentTableModel;
    StudentList studentList;
    StudentDetailUI studentDetailUI;
    StudentListUI studentListUI;
    
        

    public StudentCntl() {
        //Get the StudentList
        //When instantiated it will get the individual students
        //Once the StudentList is instantiated, instantiate the StudentTableModel
        studentList = new StudentList();
        studentTableModel = new StudentTableModel(studentList.getStudentList());
        
        //studentDetailUI = new StudentDetailUI(this, STARTING_INDEX_OF_DISPLAY); // pass 0 so UI starts at first element in list
        //studentDetailUI.setVisible(true);
        studentListUI = new StudentListUI(this);
        studentListUI.setVisible(true);
    }

    Student getStudent(int index) {
        // you'll need to change this to return the Student item at the given index in StudentList
        return studentList.getStudentList().get(index);
    }
    
    public StudentTableModel getStudentTableModel(){
        return studentTableModel;
    }
    
    public void getStudentDetailUI(int selectedRow){
        studentDetailUI = new StudentDetailUI(this, selectedRow);
        //studentListUI.setVisible(false);
        studentDetailUI.setVisible(true);
    }
}
