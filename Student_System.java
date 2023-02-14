package com.example.lab_6_official;

import javax.swing.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Student_System extends JFrame{
    private JPanel MainPanel;
    private JScrollPane scrool1;
    private JTable table1;
    private JButton add_student_button;
    private JButton delete_student_button;
    private JButton edit_student;
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
    private JButton group_list_button;
    private JButton student_list_button;
    private JButton add_group_button;
    private JButton delete_group_button;
    private JButton edit_group;
    private JPanel edit_panel_group;
    private JLabel group_name_label;
    private JLabel group_capacity_label;
    private JTextField group_name_input;
    private JTextField group_capacity_input;
    private JButton editgroup;
    private JButton przejdz_do_klasy;
    private JLabel statusButton;
    private JTextField student_condition_input;
    private JButton wybierzPrzedmiotButton;


    public static List<Student> studentList = new ArrayList<>();
    public static List<Class> groupList = new ArrayList<>();


    public Student_System(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainPanel);
        edit_panel_group.setVisible(false);
        editgroup.setVisible(false);

        //studentList.add(new Student("Jakub", "Wrona", 1999,9,1));
        //studentList.add(new Student("Adam", "Kot", 1999,0,0));
        //studentList.add(new Student("Kuba", "Kot", 1998,5,3));

       // groupList.add(new Class("Programowanie okienkowe", 15));
        //groupList.add(new Class("Programowanie rownolegle", 20));
        //groupList.add(new Class("Programowanie obiektowa", 25));


        StudentTableModel studentTableModel = new StudentTableModel(studentList);
        GroupTableModel groupTableModel = new GroupTableModel(groupList);

        // Przycisk Student list
        student_list_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                table1.setModel(studentTableModel);
                table1.setAutoCreateRowSorter(true);



                //add student button visibility
                add_student_button.setVisible(true);
                delete_student_button.setVisible(true);
                edit_student.setVisible(true);
                edit_panel_group.setVisible(false);
            }
        });

        // Przycisk Group list
        group_list_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                table1.setModel(groupTableModel);
                table1.setAutoCreateRowSorter(true);



                //add student button visibility
                add_group_button.setVisible(true);
                delete_group_button.setVisible(true);
                edit_group.setVisible(true);
                edit_panel_group.setVisible(false);
            }
        });

// Przycisk przejdzDoKlasy
        przejdz_do_klasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                table1.setModel(studentTableModel);
                table1.setAutoCreateRowSorter(true);



                //add student button visibility
                //add_student_button.setVisible(true);
                //delete_student_button.setVisible(true);
                //edit_student.setVisible(true);
                //edit_panel_group.setVisible(false);
            }
        });


        add_student_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new StudentMenu("Add Student") ;
                frame.setSize(600,400);
                frame.setVisible(true);
            }
        });

        add_group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new ClassMenu("Add Group") ;
                frame.setSize(600,400);
                frame.setVisible(true);
            }
        });


        delete_student_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                StudentTableModel model= (StudentTableModel) table1.getModel();

                if(table1.getSelectedRowCount()==1)
                {
                    int index = table1.getSelectedRow();
                    studentList.remove(index);
                    model.fireTableRowsDeleted(0,0);
                }
                else
                {
                    if(table1.getRowCount()==0)
                    {

                        JOptionPane.showMessageDialog(table1,"Table is empty");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(table1,"Please select single row");
                    }
                }
            }
        });


        delete_group_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GroupTableModel model= (GroupTableModel) table1.getModel();

                if(table1.getSelectedRowCount()==1)
                {
                    int index = table1.getSelectedRow();
                    groupList.remove(index);
                    model.fireTableRowsDeleted(0,0);
                }
                else
                {
                    if(table1.getRowCount()==0)
                    {

                        JOptionPane.showMessageDialog(table1,"Tabela jest pusta");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(table1,"Wybierz grupe, ktora chcesz usunac");
                    }
                }
            }
        });




        edit_student.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                StudentTableModel model= (StudentTableModel) table1.getModel();
                int i = table1.getSelectedRow();
                if (i>=0)
                {
                    student_index_input.setText(model.getValueAt(i, 0).toString());
                    student_name_input.setText(model.getValueAt(i, 1).toString());
                    student_surname_input.setText(model.getValueAt(i, 2).toString());
                    student_born_year_input.setText(model.getValueAt(i, 3).toString());
                    student_condition_input.setText(model.getValueAt(i, 4).toString());
                    student_points_input.setText(model.getValueAt(i, 5).toString());

                    edit_panel.setVisible(true);
                    edit_panel_group.setVisible(false);
                }
                else
                {
                    edit_panel.setVisible(false);
                    edit_panel_group.setVisible(false);
                    JOptionPane.showMessageDialog(table1,"Please select single row");

                }

            }
        });
        editstudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                StudentTableModel model= (StudentTableModel) table1.getModel();
                int i = table1.getSelectedRow();
                studentList.set(i,new Student(
                        student_name_input.getText(),
                        student_surname_input.getText(),
                        Integer.parseInt(student_born_year_input.getText()),
                        Integer.parseInt(student_points_input.getText()),
                        Integer.parseInt(student_index_input.getText()),
                        student_condition_input.getText()
                ));



                /*
                System.out.println(student_index_input.getText());
                model.setValueAt(student_index_input.getText(),i,0);
                model.setValueAt(student_name_input.getText(),i,1);
                model.setValueAt(student_surname_input.getText(),i,2);
                model.setValueAt(student_born_year_input.getText(),i,3);
                model.setValueAt(student_points_input.getText(),i,5);


                 */
                edit_panel.setVisible(false);
                edit_panel_group.setVisible(false);



            }
        });
        edit_student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                edit_panel.setVisible(true);
                edit_panel_group.setVisible(false);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////
        edit_group.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                GroupTableModel model= (GroupTableModel) table1.getModel();
                int i = table1.getSelectedRow();
                if (i>=0)
                {
                    group_name_input.setText(model.getValueAt(i, 0).toString());
                    group_capacity_input.setText(model.getValueAt(i, 1).toString());
                    edit_panel.setVisible(false);
                    edit_panel_group.setVisible(true);//
                    editgroup.setVisible(true);

                }
                else
                {
                    edit_panel.setVisible(false);
                    edit_panel_group.setVisible(false);
                    JOptionPane.showMessageDialog(table1,"Please select single row");

                }

            }
        });


        editgroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GroupTableModel model= (GroupTableModel) table1.getModel();
                int i = table1.getSelectedRow();
                groupList.set(i,new Class(
                        group_name_input.getText(),
                        Integer.parseInt(group_capacity_input.getText())));
                edit_panel_group.setVisible(false);
                editgroup.setVisible(false);

            }
        });

        przejdz_do_klasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new ConcreteClass("Widok konkretnej klasy");
                frame.setSize(600,400);
                frame.setVisible(true);
            }
        });

        wybierzPrzedmiotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new WybierzPrzedmiot("Wybierz przedmiot");
                frame.setSize(600,400);
                frame.setVisible(true);
            }
        });


        edit_group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit_panel.setVisible(false);

                edit_panel_group.setVisible(true);
                editgroup.setVisible(true);

            }
        });






    }



    public static void main(String[] args)
    {

        JFrame frame = new Student_System("Elektroniczny dziennik akademicki") ;
        frame.setSize(800,600);
        frame.setVisible(true);

        JFrame frame2 = new Student_System("Elektroniczny dziennik akademicki") ;
        frame.setSize(800,600);
        frame.setVisible(true);



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

        //@Override
        //public Class<?> getColumnClass(int columnIndex)
        //{
        //  if(getValueAt(0,columnIndex)!=null)
        //{
        //  return getValueAt(0,columnIndex).getClass();
        //}
        //return Object.class;
        //}





    }




// AbstractTableModel zawiera 3 metody które trzeba nadpisać

    // Tabela grup
    static class GroupTableModel extends AbstractTableModel
    {
        private final String[] COLUMNS = {"NAME", "Capacity"};
        private List<Class> groups; // lista zawierająca obiekty typu class
        // konstruktor
        private GroupTableModel(List<Class> groups)
        {
            this.groups = groups;
        }

        @Override
        public int getRowCount() {
            return groups.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch(columnIndex)
                    {
                        case 0 -> groups.get(rowIndex).getClassName();
                        case 1 -> groups.get(rowIndex).getGroupSize();
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



// SwingUtilities.invokeLater() - do wielowątkowości,
// aktualizacje interfejsu maja miejsce w watku rozsyłania zdarzeń
// pasek postępy lub inny komponent pokazującu bieżący postęp użytkownika
// metoda invokeLater z klasy SwingUtilities pozwala na wysyłanie zadań do Swing, które zostanie uruchomione
// w wątku rozsyłania zdarzen w następnym dogodnym momencie
// kod który jest w tej metodzie wykona się bezpiecznie, bezpiecznie zaaktualizujemy GUI


// MVC umożliwia wydajną obsługę danych i korzystanie z wyglądu i działania w czasie wykonania