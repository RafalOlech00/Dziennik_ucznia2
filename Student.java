package com.example.lab_6_official;

public class Student implements Comparable<Student>{

    public String name;
    public String surname;
    public String condition;
    public int bornYear;
    double points;
    int index;

    //public StudentCondition studentCondition;
    //public enum StudentCondition {CatchUp, Sick, Absent, Present}

    public String getName() {return this.name;}
    public String getSurname() {return this.surname;}
    public double getPoints() {return this.points;}
    public int getIndex() {return this.index;}
    public int getBornYear() {return this.bornYear;}
    public String getCondition() {return this.condition;}
    public void update(int index,String name,String Surname,double points,int born)
    {
        this.index=index;
        this.name=name;
        this.surname=surname;
        this.bornYear=born;
        this.points=points;
    }


    public Student(String name,String surname,int bornYear,double points,int index, String condition)
    {
        this.name=name;
        this.surname=surname;
        this.bornYear=bornYear;
        this.points=points;
        this.condition=condition;
        this.index=index;
    }

    @Override
    public int compareTo(Student o)
    {
        return this.surname.compareTo(o.surname);
    }

    public void printInfo()
    {
        System.out.println(String.format("%s %s","Name:", this.name));
        System.out.println(String.format("%s %s","Surname:", this.surname));
        System.out.println(String.format("%s %s","Born:", this.bornYear));
        System.out.println(String.format("%s %s","Points:", this.points));
        System.out.println(String.format("%s %s","Status:", this.condition));

    }

    public String toString() {
        return (surname + " " + name + " Born:" + bornYear + " Status:" + condition + " Points:" + points + " Index: " + index);

    }


}
