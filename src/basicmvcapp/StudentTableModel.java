/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicmvcapp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andyr
 */
public class StudentTableModel extends AbstractTableModel{
    
    private String[] columnNames = {"First Name", "Last Name", "GPA"};
    private ArrayList<Student> studentList;
    
    public StudentTableModel(ArrayList<Student> newStudentList){
        
        studentList = newStudentList;
        
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    
    public int getRowCount() { return studentList.size(); }
    
    @Override
    public int getColumnCount() { return columnNames.length; }
    
    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return (Object) studentList.get(row).getFirstName();
            case 1: return (Object) studentList.get(row).getLastName();
            case 2: return (Object) studentList.get(row).getGpa();
            default: return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col)
        { return true; }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        
    }
    
}
