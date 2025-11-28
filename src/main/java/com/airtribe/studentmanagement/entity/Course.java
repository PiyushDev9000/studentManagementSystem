package main.java.com.airtribe.studentmanagement.entity;

public class Course {

    private String courseId;
    private String courseName;
    private String instructor;
    private int enrolledStudents;

    public Course() {
        this.courseId = "";
        this.courseName = "";
        this.instructor = "";
        this.enrolledStudents = 0;
    }

    public Course(String courseId, String courseName, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.enrolledStudents = 0;
    }

    public Course(Course other) {
        this.courseId = other.courseId;
        this.courseName = other.courseName;
        this.instructor = other.instructor;
        this.enrolledStudents = other.enrolledStudents;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void unenrollStudent() {
        enrolledStudents--;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }


}
