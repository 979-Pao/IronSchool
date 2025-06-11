<<<<<<<< HEAD:src/model/Teacher.java
package model;
========
package classes;
>>>>>>>> origin/dev:src/classes/Teacher.java

import java.util.UUID;

public class Teacher {
    private static int idCounter = 1;

    private final String uuid;
    private final String teacherId; // ID legible tipo T001
    private String name;
    private double salary;

    // Constructor
    public Teacher(String name, double salary) {
        this.uuid = UUID.randomUUID().toString(); // Generación automática de teacherId
        this.teacherId = String.format("T%03d", idCounter++);     // ID visible
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString
    @Override
    public String toString() {
        return "Teacher ID: " + teacherId + ", Name: " + name + ", Salary: $" + salary;
    }
}