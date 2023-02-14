package com.example.lab_6_official;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {

    private Map<String, Class> classes = new HashMap<>();

    public void addClass(String key, int max) {

        Class c = new Class(key, max);
        this.classes.put(key, c);
    }

    public void removeClass(String name)
    {
        classes.remove(name);
    }

    public List<Class> findEmpty()
    {
        List<Class> emptyClasses = new ArrayList<>();
        this.classes.forEach((key, value) ->
        {
            if (value.getSize() == 0) {
                emptyClasses.add(value);
            }
        });

        System.out.println("Empty classes:");
        for(Class c: emptyClasses)
        {
            System.out.println(c.groupName);
        }

        return emptyClasses;
    }

    public void summary()
    {
        classes.forEach((k, v)
                -> System.out.println((k + " : Name " + v.getClassName() + " Actual Amount " + v.getSize() +
                " Fill : " + ((double)v.getSize()/(double)v.getGroupSize()*100) + "%")));
    }

    public Map<String, Class> getClasses() {
        return classes;
    }

}
