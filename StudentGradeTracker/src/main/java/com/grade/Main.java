package com.grade;

import com.grade.model.Student;
import com.grade.service.GradeManager;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		GradeManager manager = new GradeManager();

		while (true) {
			System.out.println("\n ## WELCOME TO STUDENT GRADE TRACKER");			
			System.out.println("\n1. Add Student");
			System.out.println("2. Add Grade");
			System.out.println("3. View Report");
			System.out.println("4. Delete Student");

			System.out.println("5. Exit");
			System.out.print("\n##Enter Choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter student name: ");
				String name = sc.nextLine();
				manager.addStudent(new Student(name));
				System.out.println("Student added!");
				break;

			case 2:
				System.out.print("Enter student name: ");
				String sname = sc.nextLine();

				Student student = manager.findStudent(sname);

				if (student != null) {
					System.out.print("Enter grade: ");
					int grade = sc.nextInt();
					student.addGrade(grade);
					System.out.println("Grade added!");
				} else {
					System.out.println("Student not found!");
				}
				break;

			case 3:
				manager.displayReport();
				break;

			case 4:
				System.out.print("Enter student name: ");
				String delName = sc.nextLine();
				if (manager.deleteStudent(delName)) {
					System.out.println("Deleted!");
				} else {
					System.out.println("Student not found!");
				}
				break;

			case 5:
				System.out.println("Exiting...");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
