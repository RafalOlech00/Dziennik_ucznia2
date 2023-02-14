package com.example.lab_6_official;

import javax.swing.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



public class WybierzPrzedmiot extends JFrame
{
    private JPanel mainPanel;
    private JTextField wpiszPrzedmiot_input;
    private JLabel wpiszPrzedmiot_label;
    private JButton przejdzButton;

   // public static List<String> przedmiotyLista = new ArrayList<String>();
    //public static String przedmiot = "PR";

    public WybierzPrzedmiot(String title)
    {

        super(title);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(mainPanel);

       // przedmiotyLista.add("PR");
      //String przedmiot = przedmiotyLista.get(0);

        //WybierzPrzedmiot.PrzedmiotyTableModel przedmiotyTableModel = new WybierzPrzedmiot.PrzedmiotyTableModel(przedmiotyLista);

        przejdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switch(wpiszPrzedmiot_input.getText())
                        {
                            case "PR" ->
                                    {
                                        JFrame frame = new ConcreteClass("Dziennik przedmiotu PR");
                                        frame.setSize(600, 400);
                                        frame.setVisible(true);
                                        break;
                                    }
                            case "MES" ->
                                    {
                                        JFrame frame = new ConcreteClassMES("Dziennik przedmiotu MES");
                                        frame.setSize(600, 400);
                                        frame.setVisible(true);
                                        break;
                                    }
                            case "Java" ->
                                    {
                                        JFrame frame = new ConcreteClassJava("Dziennik przedmiotu Java");
                                        frame.setSize(600, 400);
                                        frame.setVisible(true);
                                        break;
                                    }
                            default ->System.out.println("Wybierz przedmiot z listy");
                        };



/*
                if (przedmiot == "PR")
                {
                    System.out.println("jesttttttttttttt");
                    JFrame frame = new ConcreteClass("Add Student");
                    frame.setSize(600, 400);
                    frame.setVisible(true);
                }

 */
            }
        });

    }

    // tabela wpisanych przedmiotow
    private static class PrzedmiotyTableModel extends AbstractTableModel
    {
        private final String[] COLUMNS = {"Nazwa przedmiotu"};
        private List<String> przedmiotyLista;
        private PrzedmiotyTableModel(List<String> przedmiotyLista)
        {
            this.przedmiotyLista = przedmiotyLista;
        }



        @Override
        public int getRowCount() {
            return przedmiotyLista.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public String getValueAt(int rowIndex, int columnIndex) {
            return switch(rowIndex)
                    {
                        case 0 -> przedmiotyLista.get(rowIndex);
                       // case 1 -> przedmiotyLista.get(rowIndex);
                        //case 2 -> przedmiotyLista.get(rowIndex);
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
