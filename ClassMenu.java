package com.example.lab_6_official;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClassMenu extends JFrame {

    private JPanel MainPanel;
    private JLabel group_name_label;
    private JLabel group_capacity_label;
    private JTextField group_name_input;
    private JTextField group_capacity_input;
    private JButton add_group_button;


    public ClassMenu(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(MainPanel);
        add_group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Class c1 =new Class(
                        group_name_input.getText(),
                        Integer.parseInt(group_capacity_input.getText()));
                c1.printInfo();

                Student_System.groupList.add(c1);

                setVisible(false); //you can't see me!
                dispose();
            }
        });







    }

}

