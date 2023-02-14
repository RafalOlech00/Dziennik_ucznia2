package com.example.lab_6_official;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class EditGroup extends JFrame {


    private JPanel MainPanel;
    private JButton edit_group_button;
    private JLabel group_name_label;
    private JLabel group_capacity_label;
    private JTextField group_name_input;
    private JTextField group_capacity_input;
    /*

    public EditGroup(String title) {

        edit_group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainPanel.setVisible(true);
            }
        });


        edit_group_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Student_System.GroupTableModel model = (Student_System.GroupTableModel) Student_System.table1.getModel();
                int i = table1.getSelectedRow();
                if (i >= 0) {
                    group_name_input.setText(model.getValueAt(i, 0).toString());
                    group_capacity_input.setText(model.getValueAt(i, 1).toString());
                    MainPanel.setVisible(true);
                } else {
                    MainPanel.setVisible(false);
                    JOptionPane.showMessageDialog(table1, "Please select single row");

                }

            }
        });


    }

     */
}
