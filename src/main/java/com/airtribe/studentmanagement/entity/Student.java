package main.java.com.airtribe.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;


public class Student extends Person implements Enrollable {
    private String studentId;
    private String branch;
    private double cgpa;
    private List<String> enrolledCourses;

    public Student() {
        this("", "", 0, "", "", "", 0.0);
        System.out.println("Student default constructor called");
    }


    public Student(String id, String name, int age, String city,
                   String studentId, String branch, double cgpa) {
        super(id, name, age, city); // constructor chaining
        this.studentId = studentId;   // this keyword
        this.branch = branch;
        this.cgpa = cgpa;
        this.enrolledCourses = new ArrayList<>();
        System.out.println("Student parameterized constructor called");
    }

    public Student(Student other) {
        super(other);
        this.studentId = other.studentId;
        this.branch = other.branch;
        this.cgpa = other.cgpa;
        this.enrolledCourses = new ArrayList<>(other.enrolledCourses);
        System.out.println("Student copy constructor called");
    }


    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }


    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 10.0) {
            this.cgpa = cgpa;
        }
    }


    public List<String> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    public void enrollInCourse(String courseId) {
        if (!enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
        }
    }
    public void unenrollFromCourse(String courseId) {
        enrolledCourses.remove(courseId);
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("ID: " + getId());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Major: " + getBranch());
        System.out.println("CGPA: " + getCgpa());
        System.out.println("Enrollment Status: " + Enrollable.getEnrollmentStatus(enrolledCourses.size()));
//        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        // Using default method from interface
//
    }



}
