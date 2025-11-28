package main.java.com.airtribe.studentmanagement.service;
import main.java.com.airtribe.studentmanagement.entity.Student;
import main.java.com.airtribe.studentmanagement.entity.GraduateStudent;
import main.java.com.airtribe.studentmanagement.entity.Enrollment;
import main.java.com.airtribe.studentmanagement.entity.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class StudentService {
    private List<Student> students;
    private List<Course> courses;
    private List<Enrollment> enrollments;


    private int studentIdCounter;
    private int personIdCounter;
    private int courseIdCounter;
    private int enrollmentIdCounter;


    public StudentService() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.enrollments = new ArrayList<>();

        this.studentIdCounter = 1;
        this.personIdCounter = 1;
        this.courseIdCounter = 1;
        this.enrollmentIdCounter = 1;

    }

    /** Student Services **/
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return copy to maintain encapsulation
    }
    public Student addStudent(String name, int age, String city, String branch, double cgpa) {
        String id = String.format("%03d", personIdCounter++);
        String studentId = "STU" + String.format("%03d", studentIdCounter++);

        Student student = new Student(id, name, age, city,studentId,branch, cgpa);
        students.add(student);
        return student;
    }
    public GraduateStudent addGraduateStudent(String name, int age, String city, String branch, double cgpa, String researchArea, String majorProject, boolean isMastersCandidate) {
        String id = String.format("%03d", personIdCounter++);
        String studentId = "GRAD" + String.format("%03d", studentIdCounter++);

        GraduateStudent gradStudent = new GraduateStudent(id, name, age, city,studentId,branch, cgpa, researchArea, majorProject, isMastersCandidate);
        students.add(gradStudent);
        return gradStudent;
    }
    public Student searchStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }
    public List<Student> searchStudentByName(String name) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                results.add(student);
            }
        }
        return results;
    }

    public List<Student> searchStudent(String name) {
        return searchStudentByName(name);
    }

    public Student searchStudent(String studentId, boolean searchById) {
        return searchStudentById(studentId);
    }



    public boolean updateStudent(String studentId, String name, int age, String city,
                                 String branch, double cgpa) {
        Student student = searchStudentById(studentId);
        if (student != null) {
            if (name != null && !name.isEmpty()) {
                student.setName(name);
            }
            if (age > 0) {
                student.setAge(age);
            }
            if (city != null && !city.isEmpty()) {
                student.setCity(city);
            }
            if (branch != null && !branch.isEmpty()) {
                student.setBranch(branch);
            }
            if (cgpa >= 0) {
                student.setCgpa(cgpa);
            }
            return true;
        }
        return false;
    }

    /** Course Services **/
    public Course addCourse(String courseName, String instructor) {
        String courseId = "CS" + String.format("%03d", courseIdCounter++);
        Course course = new Course(courseId, courseName, instructor);
        courses.add(course);
        return course;
    }
    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(courseId)) {
                return course;
            }
        }
        return null;
    }
    public boolean updateCourse(String courseId, String courseName, String instructor) {
        Course course = getCourseById(courseId);
        if (course != null) {
            if (courseName != null && !courseName.isEmpty()) {
                course.setCourseName(courseName);
            }
            if (instructor != null && !instructor.isEmpty()) {
                course.setInstructor(instructor);
            }
            return true;
        }
        return false;
    }
    public boolean deleteStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                // Also remove associated enrollments
                removeEnrollmentsForStudent(studentId);
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(String courseId) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getCourseId().equalsIgnoreCase(courseId)) {
                // Also remove associated enrollments
                removeEnrollmentsForCourse(courseId);
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    /** Enrollment Services **/
    public boolean enrollStudentInCourse(String studentId, String courseId) {
        Student student  = searchStudentById(studentId);
        Course course = getCourseById(courseId);

        if(student!=null && course!=null){
            String enrollmentId = "EN" + String.format("%03d", enrollmentIdCounter++);
            String enrollmentDate = java.time.LocalDate.now().toString();
            Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId,enrollmentDate);
            enrollments.add(enrollment);

            student.enrollInCourse(courseId);
            course.enrollStudent();

            return true;
        }
        return false;

    }
    public boolean unenrollStudentFromCourse(String studentId, String courseId) {
        Student student = searchStudentById(studentId);
        Course course = getCourseById(courseId);

        if (student != null && course != null) {
            Iterator<Enrollment> iterator = enrollments.iterator();
            while (iterator.hasNext()) {
                Enrollment enrollment = iterator.next();
                if (enrollment.getStudentId().equalsIgnoreCase(studentId) &&
                        enrollment.getCourseId().equalsIgnoreCase(courseId) &&
                        enrollment.isActive()) {
                    enrollment.setActive(false);
                    break;
                }
            }

            student.unenrollFromCourse(courseId);
            course.unenrollStudent();

            return true;
        }
        return false;
    }
    public List<Enrollment> getEnrollmentsForStudent(String studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equalsIgnoreCase(studentId) && enrollment.isActive()) {
                result.add(enrollment);
            }
        }
        return result;
    }
    public List<Enrollment> getEnrollmentsForCourse(String courseId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId().equalsIgnoreCase(courseId) && enrollment.isActive()) {
                result.add(enrollment);
            }
        }
        return result;
    }
    private void removeEnrollmentsForStudent(String studentId) {
        Iterator<Enrollment> iterator = enrollments.iterator();
        while (iterator.hasNext()) {
            Enrollment enrollment = iterator.next();
            if (enrollment.getStudentId().equalsIgnoreCase(studentId)) {
                iterator.remove();
            }
        }
    }
    private void removeEnrollmentsForCourse(String courseId) {
        Iterator<Enrollment> iterator = enrollments.iterator();
        while (iterator.hasNext()) {
            Enrollment enrollment = iterator.next();
            if (enrollment.getCourseId().equalsIgnoreCase(courseId)) {
                iterator.remove();
            }
        }
    }
    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }

    /** To get Student Counts **/
    public int getStudentCount() {
        return students.size();
    }

    /** To get Course Counts **/
    public int getCourseCount() {
        return courses.size();
    }

}

