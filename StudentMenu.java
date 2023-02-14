package com.example.lab_6_official;

import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentMenu extends JFrame{
    private JPanel MainPanel;
    private JLabel student_name_label;
    private JLabel student_surname_label;
    private JTextField student_name_input;
    private JTextField student_surname_input;
    private JLabel student_born_year_label;
    private JTextField student_born_year_input;
    private JLabel student_points_label;
    private JTextField student_points_input;
    private JLabel student_index_label;
    private JTextField student_index_input;
    private JButton add_student_button;
    private JLabel student_condition_label;
    private JTextField student_condition_input;

    public StudentMenu(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(MainPanel);
        add_student_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s1 =new Student(
                        student_name_input.getText(),
                        student_surname_input.getText(),
                        (int) Double.parseDouble(student_born_year_input.getText()),
                        Double.parseDouble(student_points_input.getText()),
                        (int) Double.parseDouble(student_index_input.getText()),
                        student_condition_input.getText());
                s1.printInfo();

                Student_System.studentList.add(s1);

                setVisible(false); //you can't see me!
                dispose();
            }
        });




    }




}
