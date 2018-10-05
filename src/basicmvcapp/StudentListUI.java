/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicmvcapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author andyr
 */
public class StudentListUI extends JFrame {
    
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable studentTable;
    private JButton doneButton;
    private JButton newButton;
    private JButton detailsButton;
    private JScrollPane tableScroller;
    private final StudentCntl parentStudentCntl;
    
    public StudentListUI(StudentCntl studentCntl) {
        parentStudentCntl = studentCntl;
        initComponents();
    }
    
    public void initComponents(){
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        
        studentTable = new JTable(parentStudentCntl.getStudentTableModel());
        studentTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        
        doneButton = new JButton("Done");
        detailsButton = new JButton("Show Details");
        
        newButton = new JButton("New");
        
        //detailsButton.addActionListener(new DetailsButtonListener());
        //doneButton.addActionListener(new DetailsButtonListener());
        //newButton.addActionListener(new DetailsButtonListener());
        detailsButton.addActionListener(event -> showDetailsAction());
        //doneButton.addActionListener(event -> doneButtonAction());
        newButton.addActionListener(event -> newStudentAction());
        
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        
        tableScroller = new JScrollPane(studentTable);
        studentTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350, 300));
        tablePanel.add(tableScroller);
        
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        
    }
    
    
    
    private void showDetailsAction(){
            int selectedTableRow = studentTable.getSelectedRow();
            int selectedModelRow = studentTable.convertRowIndexToModel(selectedTableRow);
            StudentListUI.this.parentStudentCntl.getStudentDetailUI(selectedModelRow);
    }
}
