package main.java.com.airtribe.studentmanagement.entity;

/**
 * GraduateStudent class demonstrating multilevel inheritance.
 *
 * Inheritance Hierarchy:
 * Person → Student → GraduateStudent
 *
 * 1. Multilevel Inheritance
 *    - GraduateStudent extends Student
 *    - Student extends Person
 *    - Objects of this class can be treated as Person, Student, or GraduateStudent (polymorphism)

 * 2. Diamond Problem Explanation (Java’s Solution)
 *    - Java does NOT allow multiple inheritance of classes → avoids the diamond problem
 *    - A class can implement multiple interfaces safely
 *    - If two interfaces contain the same default method:
 *        → The class MUST override it explicitly
 *    - This ensures there is no ambiguity like in C++
 */


public class GraduateStudent extends Student{
    private String researchArea;
    private String majorProject;
    private boolean isMastersCandidate;

    public GraduateStudent(){
        super();
        this.researchArea = "";
        this.majorProject = "";
        this.isMastersCandidate = false;
        System.out.println("Graduate Student Default constructor called");
    }

    public GraduateStudent(String id, String name, int age, String city,
                           String studentId, String branch ,double cgpa,
                           String researchArea, String majorProject, boolean isMastersCandidate){
        super(id, name, age, city, studentId, branch ,cgpa);
        this.researchArea = researchArea;
        this.majorProject = majorProject;
        this.isMastersCandidate = isMastersCandidate;
        System.out.println("Graduate Student parameterized constructor called");
    }

    public GraduateStudent(GraduateStudent other) {
        super(other);
        this.researchArea = other.researchArea;
        this.majorProject = other.majorProject;
        this.isMastersCandidate = other.isMastersCandidate;
        System.out.println("Graduate Student Copy constructor called");
    }


    public String getResearchArea(){
        return researchArea;
    }
    public void setResearchArea(String researchArea){
        this.researchArea = researchArea;
    }


    public String getMajorProject(){
        return majorProject;
    }
    public void setMajorProject(String majorProject){
        this.majorProject = majorProject;
    }


    public Boolean getisMastersCandidate(){
        return isMastersCandidate;
    }
    public void setisMastersCandidate(boolean isMastersCandidate){
        this.isMastersCandidate = isMastersCandidate;
    }


    @Override
    public String getRole() {
        return isMastersCandidate ? "Master's Student" : "Graduate Student";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("\n=== Graduate Student Additional Information ===");
//        System.out.println("ID: " + getId());
//        System.out.println("Student ID: " + getStudentId());
//        System.out.println("Name: " + getName());
//        System.out.println("Age: " + getAge());
//        System.out.println("Major: " + getBranch());
//        System.out.println("CGPA: " + getCgpa());
        System.out.println("Research Area: " + getResearchArea());
        System.out.println("Major Project: " + getMajorProject());
        System.out.println("Master's Candidate: " + (isMastersCandidate ? "Yes" : "No"));
        // Using default method from interface
//        System.out.println("Enrollment Status: " + Enrollable.getEnrollmentStatus(enrolledCourses.size()));
    }


}
