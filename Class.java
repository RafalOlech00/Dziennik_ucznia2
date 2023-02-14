package com.example.lab_6_official;


import java.util.Collections;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Class {

    public String groupName;
    public int maxStudentNumber;
    public int getSize() {return this.studentsList.size();}
    public String getClassName() {return this.groupName;}
    public int getGroupSize() {return this.maxStudentNumber;}
    //public String getName() {return this.groupName;}
    //public String getCapacity() {return this.maxStudentNumber;}
    private List<Student> studentsList = new ArrayList<Student>();

    public Class(String name, int number)
    {
        this.groupName=name;
        this.maxStudentNumber=number;

    }

    public Boolean findStudent(String name,String surname, List<Student> studentsList) {

        for (Student s : studentsList)
        {
            if ( s.getName().equals(name) && s.getSurname().equals(surname) )
            {
                return false;
            }
        }
        return true;
    }


    public void printInfo()
    {
        System.out.println(String.format("%s %s","Nazwa grupy:", this.groupName));
        System.out.println(String.format("%s %s","Maksymalna liczba studentow w grupie:", this.maxStudentNumber));
    }

    public void addStudent(Student s)
    {
        int size=this.studentsList.size();
        boolean isExist = findStudent(s.name,s.surname,studentsList);

        if(size>=maxStudentNumber)
        {
            System.out.println(String.format("Group is full"));
        }
        else if(!isExist)
        {
            System.out.println(String.format("Student already exits"));
        }
        else
        {
            studentsList.add(s);
            System.out.println(String.format("Student added"));
        }
    }

    public void addPoints(int index, double p)
    {
        for (Student s : studentsList)
        {
            if ( s.getIndex()==index )
            {
                s.points+=p;
            }

        }

    }

    public void getStudent(int index)
    {
        for (Student s : studentsList)
        {
            if ( s.getIndex()==index )
            {
                if(s.points<=0)
                    studentsList.remove(s);
            }

        }

    }

    /*
    public void changeCondition(int index, Student.condition con)
    {
        for (Student s : studentsList)
        {
            if ( s.getIndex()==index )
            {
                s.studentCondition=con;
            }

        }

    }

     */

    public void removePoints(int index, double p)
    {
        for (Student s : studentsList)
        {
            if ( s.getIndex()==index )
            {
                s.points-=p;
                if(s.points<=0)
                {
                    studentsList.remove(s);
                }
            }

        }

    }

    public void search(String surname)
    {
        System.out.println("//");
        for (Student s : studentsList)
        {
            if ( s.getSurname().equals(surname) )
            {

                System.out.println(String.format(s.toString()));

            }

        }
        System.out.println("//");
    }


    public void partSearch(String exp) {
        String s = ".*" + exp + ".*";
        List<Student> result = studentsList.stream()
                .filter(student -> student.getSurname().matches(s))
                .collect(Collectors.toList());

        for(Student st: result)
        {
            System.out.println(String.format(st.toString()));
        }
        System.out.println("\n");
    }

    /*
    public void countByCondition(Student.StudentCondition con)
    {
        int counter=0;
        for (Student s : studentsList)
        {
            if ( s.getCondition()==con )
            {
                counter++;
            }
        }
        System.out.println(counter);
    }

     */

    public void summary()
    {
        for (Student s : studentsList)
        {
            System.out.println(String.format(s.toString()));
        }
        System.out.println("\n");
    }

    public void sortByName()
    {
        Collections.sort(studentsList);
    }

    public void max()
    {
        Collections.max(studentsList);
    }

    public void sortByPoints()
    {

        PointsComparator pointsComparator =new PointsComparator();
        Collections.sort(studentsList,pointsComparator);
    }



    public void setStudentsList(List<Student> studentList) {
        this.studentsList = studentList;
    }
}



