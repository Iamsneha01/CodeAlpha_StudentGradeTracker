package com.grade.service;

import com.grade.model.Student;
import java.util.ArrayList;

public class GradeManager {

    private ArrayList<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
    public boolean deleteStudent(String name) {
        Student s = findStudent(name);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
    public void displayReport() {
        System.out.println("\n STUDENT REPORT");

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student s : students) {
            System.out.println("\nName: " + s.getName());
            System.out.println("Grades: " + s.getGrades());
            System.out.println("Average: " + s.getAverage());
            System.out.println("Highest: " + s.getHighest());
            System.out.println("Lowest: " + s.getLowest());
        }
    }
}
