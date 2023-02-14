package com.example.lab_6_official;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ConcreteClassJava extends JFrame{
    private JPanel mainPanel;
    private JTable tabelaStudentowPrzedmiotu;
    private JButton dodajStudentaButton;
    private JButton edytujStudentaButton;
    private JButton usunStudentaButton;
    private JButton listaStudentowPrzedmiotuButton;
    private JPanel edit_panel;
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
    private JButton editstudent;
    private JLabel student_condition_label;
    private JTextField student_condition_input;



    public static List<Student> studentListJava = new ArrayList<>();

    public ConcreteClassJava(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        studentListJava.add(new Student("Jan", "Kowalski", 1999,9, 1234, "Obecny"));

        ConcreteClassJava.StudentTableModel studentTableModel = new ConcreteClassJava.StudentTableModel(studentListJava);



        listaStudentowPrzedmiotuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabelaStudentowPrzedmiotu.setModel(studentTableModel);
                tabelaStudentowPrzedmiotu.setAutoCreateRowSorter(true);

                dodajStudentaButton.setVisible(true);
            }
        });


        dodajStudentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new ConcreteAddJava("Add Student") ;
                frame.setSize(600,400);
                frame.setVisible(true);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        usunStudentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ConcreteClassJava.StudentTableModel model= (ConcreteClassJava.StudentTableModel) tabelaStudentowPrzedmiotu.getModel();

                if(tabelaStudentowPrzedmiotu.getSelectedRowCount()==1)
                {
                    int index = tabelaStudentowPrzedmiotu.getSelectedRow();
                    studentListJava.remove(index);
                    model.fireTableRowsDeleted(0,0);
                }
                else
                {
                    if(tabelaStudentowPrzedmiotu.getRowCount()==0)
                    {

                        JOptionPane.showMessageDialog(tabelaStudentowPrzedmiotu,"Table is empty");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(tabelaStudentowPrzedmiotu,"Please select single row");
                    }
                }
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        edytujStudentaButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                ConcreteClassJava.StudentTableModel model= (ConcreteClassJava.StudentTableModel) tabelaStudentowPrzedmiotu.getModel();
                int i = tabelaStudentowPrzedmiotu.getSelectedRow();
                if (i>=0)
                {
                    student_index_input.setText(model.getValueAt(i, 0).toString());
                    student_name_input.setText(model.getValueAt(i, 1).toString());
                    student_surname_input.setText(model.getValueAt(i, 2).toString());
                    student_born_year_input.setText(model.getValueAt(i, 3).toString());
                    student_condition_input.setText(model.getValueAt(i, 4).toString());
                    student_points_input.setText(model.getValueAt(i, 5).toString());

                    edit_panel.setVisible(true);

                }
                else
                {
                    edit_panel.setVisible(false);
                    edit_panel.setVisible(false);
                    JOptionPane.showMessageDialog(tabelaStudentowPrzedmiotu,"Please select single row");

                }

            }
        });
        editstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ConcreteClassJava.StudentTableModel model= (ConcreteClassJava.StudentTableModel) tabelaStudentowPrzedmiotu.getModel();
                int i = tabelaStudentowPrzedmiotu.getSelectedRow();
                studentListJava.set(i,new Student(
                        student_name_input.getText(),
                        student_surname_input.getText(),
                        Integer.parseInt(student_born_year_input.getText()),
                        Integer.parseInt(student_points_input.getText()),
                        Integer.parseInt(student_index_input.getText()),
                        student_condition_input.getText()));



                /*
                System.out.println(student_index_input.getText());
                model.setValueAt(student_index_input.getText(),i,0);
                model.setValueAt(student_name_input.getText(),i,1);
                model.setValueAt(student_surname_input.getText(),i,2);
                model.setValueAt(student_born_year_input.getText(),i,3);
                model.setValueAt(student_points_input.getText(),i,5);


                 */
                edit_panel.setVisible(false);




            }
        });
        edytujStudentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit_panel.setVisible(true);
            }
        });





    }
    // Tabela studentów
    private static class StudentTableModel extends AbstractTableModel
    {
        private final String[] COLUMNS = {"INDEX", "NAME", "SURNAME","BORN","CONDITION","POINTS",};
        private List<Student> students;
        private StudentTableModel(List<Student> students)
        {
            this.students = students;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch(columnIndex)
                    {
                        case 0 -> students.get(rowIndex).getIndex();
                        case 1 -> students.get(rowIndex).getName();
                        case 2 -> students.get(rowIndex).getSurname();
                        case 3 -> students.get(rowIndex).getBornYear();
                        case 4 -> students.get(rowIndex).getCondition();
                        case 5 -> students.get(rowIndex).getPoints();
                        default ->"-";
                    };
        }

        @Override
        public String getColumnName(int column)
        {
            return COLUMNS[column];
        }

    }

}
