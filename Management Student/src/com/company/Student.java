package com.company;

public class Student
{
    private String firstName;
    private String lastName;
    private String studentId;
    private String grade;

    // Constructor
    public Student(String firstName, String lastName, String studentId, String grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.grade = grade;
    }
    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }

    // Setter methods for editing
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString method to print student info
    @Override
    public String toString()
    {
        return "ID: " + studentId + ", Name: " + firstName + " " + lastName + ", Grade: " + grade;
    }
}
