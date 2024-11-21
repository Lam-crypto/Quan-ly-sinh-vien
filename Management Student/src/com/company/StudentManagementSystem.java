package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem
{
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList();
        scanner = new Scanner(System.in);
    }

    // Method to enter a new student
    public void enterStudent() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(firstName, lastName, studentId, grade);
        students.add(student);
        System.out.println("Student " + firstName + " " + lastName + " added successfully.");
    }

    // Method to find students by last name
    public void findStudentsByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with that last name.");
        }
    }

    // Method to find and edit student by full name
    public void findAndEditStudentByFullName() {
        System.out.print("Enter full name (first and last name): ");
        String fullName = scanner.nextLine();
        String[] nameParts = fullName.split(" ");
        if (nameParts.length != 2) {
            System.out.println("Invalid full name format.");
            return;
        }

        String firstName = nameParts[0];
        String lastName = nameParts[1];
        boolean found = false;

        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(firstName) && student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Found student: " + student);
                found = true;

                // Edit student details
                System.out.println("Edit student details:");
                System.out.print("Enter new first name (or press Enter to keep current): ");
                String newFirstName = scanner.nextLine();
                if (!newFirstName.isEmpty()) student.setFirstName(newFirstName);

                System.out.print("Enter new last name (or press Enter to keep current): ");
                String newLastName = scanner.nextLine();
                if (!newLastName.isEmpty()) student.setLastName(newLastName);

                System.out.print("Enter new student ID (or press Enter to keep current): ");
                String newStudentId = scanner.nextLine();
                if (!newStudentId.isEmpty()) student.setStudentId(newStudentId);

                System.out.print("Enter new grade (or press Enter to keep current): ");
                String newGrade = scanner.nextLine();
                if (!newGrade.isEmpty()) student.setGrade(newGrade);

                System.out.println("Student updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with that full name.");
        }
    }

    // Method to display the menu
    public void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Enter student list");
        System.out.println("2. Find students by last name");
        System.out.println("3. Find and edit students by full name");
        System.out.println("4. End");
    }

    // Method to run the system
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    enterStudent();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
