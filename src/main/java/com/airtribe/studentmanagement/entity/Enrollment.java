package main.java.com.airtribe.studentmanagement.entity;

public class Enrollment {
    private String enrollmentId;
    private String studentId;
    private String courseId;
    private String enrollmentDate;
    private boolean isActive;

    public Enrollment(){
        this.enrollmentId = "";
        this.studentId = "";
        this.courseId = "";
        this.enrollmentDate = "";
        this.isActive = true;

    }


    public Enrollment(String enrollmentId, String studentId, String courseId, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.isActive = true;
    }

    public Enrollment(Enrollment other) {
        this.enrollmentId = other.enrollmentId;
        this.studentId = other.studentId;
        this.courseId = other.courseId;
        this.enrollmentDate = other.enrollmentDate;
        this.isActive = other.isActive;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", isActive=" + isActive +
                '}';
    }

}
