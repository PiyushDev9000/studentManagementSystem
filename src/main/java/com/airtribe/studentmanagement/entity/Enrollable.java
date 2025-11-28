package main.java.com.airtribe.studentmanagement.entity;

public  interface Enrollable {
    java.util.List<String> getEnrolledCourses();

    void enrollInCourse(String courseId);
    void unenrollFromCourse(String courseId);

    default int getEnrollmentCount() {
        return getEnrolledCourses().size();
    }
    default boolean isEnrolled(String courseId) {
        return getEnrolledCourses().contains(courseId);
    }

    static String getEnrollmentStatus(int enrollmentCount) {
        if (enrollmentCount == 0) {
            return "Not enrolled in any courses";
        } else if (enrollmentCount < 3) {
            return "Light course load";
        } else if (enrollmentCount < 6) {
            return "Normal course load";
        } else {
            return "Heavy course load";
        }
    }
}