package main.java.com.airtribe.studentmanagement.main;
import main.java.com.airtribe.studentmanagement.entity.GraduateStudent;
import main.java.com.airtribe.studentmanagement.entity.Student;
import main.java.com.airtribe.studentmanagement.service.StudentService;
import main.java.com.airtribe.studentmanagement.entity.Course;
import main.java.com.airtribe.studentmanagement.entity.Enrollment;
import main.java.com.airtribe.studentmanagement.entity.Person;

import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {
    private StudentService studentService;
    private Scanner scanner;

    public StudentManagementApp() {
        this.studentService = new StudentService();
        this.scanner = new Scanner(System.in);
    }



    public static void main(String[] args){
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }

    public void run(){
        System.out.println("-----------------------");
        System.out.println("Welcome to the Student Management System");
        System.out.println("-----------------------");

        boolean running = true;
        while(running){
            displayActionsMenu();
            int choice = getIntInput("So, what do you wanna do?: ");

            switch (choice){
                case 1:
                    viewStudentsMenu();
                    break;

                case 2:
                    addStudentMenu();
                    break;

                case 3:
                    updateStudentMenu();
                    break;

                case 4:
                    deleteStudentMenu();
                    break;

                case 5:
                    searchStudentMenu();
                    break;

                case 6:
                    manageCoursesMenu();
                    break;

                case 7:
                    manageEnrollmentsMenu();
                    break;

                case 8:
                    runTimePolymorphism();
                    break;

                case 0:
                    running = false;
                    System.out.println("Good Bye");
                    break;

                default:
                    System.out.println("Wrong choice!");

            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();

    }

    private void displayActionsMenu(){
        System.out.println("\n------ACTIONS YOU CAN PERFORM------");
        System.out.println("1. View All Students");
        System.out.println("2. Add Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Manage Courses");
        System.out.println("7. Manage Enrollments");
        System.out.println("8. See RunTime Polymorphism");
        System.out.println("0. Exit");

    }


    /** Student Menthods Start **/
    private void viewStudentsMenu() {
        System.out.println("\n========== VIEW STUDENTS ==========");

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("Total Students: " + students.size());
        System.out.println("\n--- Student List ---");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("\n[" + (i + 1) + "] " + student.getStudentId() + " - " + student.getName());
            System.out.println("    Role: " + student.getRole());
            System.out.println("    Branch: " + student.getBranch() + ", CGPA: " + student.getCgpa());
        }

        System.out.println("\nEnter student number to view details (0 to go back): ");
        int choice = getIntInput("");

        if (choice > 0 && choice <= students.size()) {
            Student student = students.get(choice - 1);
            System.out.println("\n--- Student Details ---");
            student.displayInfo();
        }
    }
    private void addStudentMenu(){
        System.out.println("\n-----ADD STUDENT-----");
        System.out.println("1. Regular Student");
        System.out.println("2. Graduate Student");
        System.out.println("3. Main Menu");

        int studentChoice = getIntInput("Enter Your Choice: ");

        switch (studentChoice){
            case 1:
                addRegularStudent();
                break;
            case 2:
                addGraduateStudent();
                break;
            case 3:
                return;
            default:
                System.out.println("Wrong choice!");
        }
    }
    public void updateStudentMenu(){
        System.out.println("\n========== UPDATE STUDENT ==========");

        String studentId = getStringInput("Enter Student ID: ");
        Student student = studentService.searchStudentById(studentId);

        if(student == null){
            System.out.println("\nStudent Not Found!");
            return;
        }

        System.out.println("\nCurrent Student Information:");
        student.displayInfo();

        System.out.println("\n--- Enter new information (press Enter to keep existing) ---");

        String name = getStringInput("New name: ");
        String ageStr = getStringInput("New age: ");
        String city = getStringInput("New City: ");
        String branch = getStringInput("New Branch: ");
        String cgpaStr = getStringInput("New CGPA: ");

        int age = ageStr.isEmpty() ? -1 : Integer.parseInt(ageStr);
        double cgpa = cgpaStr.isEmpty() ? -1 : Double.parseDouble(cgpaStr);

        boolean updated = studentService.updateStudent(
                studentId,
                name,
                age,
                city,
                branch,
                cgpa
        );

        if(updated){
            System.out.println("\nStudent Information Updated!");
            studentService.searchStudentById(studentId).displayInfo();
        }else{
            System.out.println("\nStudent Information Update Failed");
        }
    }
    private void deleteStudentMenu() {
        System.out.println("\n========== DELETE STUDENT ==========");

        String studentId = getStringInput("Enter Student ID to delete: ");
        Student student = studentService.searchStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\nStudent to be deleted:");
        student.displayInfo();

        String confirm = getStringInput("\nAre you sure you want to delete? (yes/no): ");

        if (confirm.equalsIgnoreCase("yes")) {
            boolean deleted = studentService.deleteStudent(studentId);
            if (deleted) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Failed to delete student!");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    private void searchStudentMenu(){
        System.out.println("\n========== SEARCH STUDENT ==========");
        System.out.println("1. Search by Student ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Back to Main Menu");
        System.out.println("====================================");

        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1:
                searchByStudentId();
                break;
            case 2:
                searchByName();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
    private void searchByStudentId() {
        String studentId = getStringInput("Enter Student ID: ");
        Student student = studentService.searchStudentById(studentId);

        if (student != null) {
            System.out.println("\n--- Student Found ---");
            student.displayInfo();
        } else {
            System.out.println("Student not found!");
        }
    }
    private void searchByName() {
        String name = getStringInput("Enter Student Name: ");
        List<Student> students = studentService.searchStudentByName(name);

        if (students.isEmpty()) {
            System.out.println("No students found with that name!");
        } else {
            System.out.println("\n--- Found " + students.size() + " student(s) ---");
            for (Student student : students) {
                System.out.println("\n--- Student ---");
                student.displayInfo();
            }
        }
    }
    public void addRegularStudent(){
        System.out.println("-----Kindly provide some information-----");
        String name = getStringInput("Enter Name: ");
        int age = getIntInput("Enter Age: ");
        String city = getStringInput("Enter City: ");
        String branch = getStringInput("Enter Branch: ");
        double cgpa = getDoubleInput("Enter cgpa (0.0-10.0): ");

        Student student =  studentService.addStudent(name, age, city, branch, cgpa);

        if(student!= null){
            System.out.println("\nStudent added successfully!");
            System.out.println("Student ID: " + student.getStudentId());
            student.displayInfo();
        }else{
            System.out.println("\nSorry! Failed to add student");
        }

    }
    public void addGraduateStudent(){
        System.out.println("\n-----Kindly provide some information-----");
        String name = getStringInput("Enter Name: ");
        int age = getIntInput("Enter Age: ");
        String city = getStringInput("Enter City: ");
        String branch = getStringInput("Enter Branch: ");
        double cgpa = getDoubleInput("Enter cgpa (0.0-10.0): ");
        String researchArea = getStringInput("What's your Research Area: ");
        String majorProject = getStringInput("Your Major Project: ");
        boolean isMastersCandidate = getStringInput("Is Master's candidate? (yes/no): ").equalsIgnoreCase("yes");


        GraduateStudent gradStudent =  studentService.addGraduateStudent(name, age, city, branch, cgpa,researchArea,majorProject,isMastersCandidate);

        if(gradStudent!= null){
            System.out.println("\nStudent added successfully!");
            System.out.println("Student ID: " + gradStudent.getStudentId());
            gradStudent.displayInfo();
        }else{
            System.out.println("\nSorry! Failed to add student");
        }

    }
    /** Students Methods Start **/

    /** Course Methods Start **/
    private void manageCoursesMenu() {
        System.out.println("\n========== MANAGE COURSES ==========");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Update Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Back to Main Menu");
        System.out.println("=====================================");

        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                addCourse();
                break;
            case 2:
                viewCourses();
                break;
            case 3:
                updateCourse();
                break;
            case 4:
                deleteCourse();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
    private void addCourse() {
        System.out.println("\n--- Add Course ---");

        String courseName = getStringInput("Enter course name: ");
        String instructor = getStringInput("Enter instructor name: ");

        Course course = studentService.addCourse(courseName, instructor);

        if (course != null) {
            System.out.println("\nCourse added successfully!");
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println(course);
        } else {
            System.out.println("Failed to add course!");
        }
    }
    private void viewCourses() {
        System.out.println("\n--- All Courses ---");

        List<Course> courses = studentService.getAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found!");
            return;
        }

        System.out.println("Total Courses: " + courses.size());
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    private void updateCourse() {
        System.out.println("\n--- Update Course ---");

        String courseId = getStringInput("Enter Course ID to update: ");
        Course course = studentService.getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        System.out.println("\nCurrent Course Information:");
        System.out.println(course);
        System.out.println("\n--- Enter new information (press Enter to keep existing) ---");

        String courseName = getStringInput("New course name: ");
        String instructor = getStringInput("New instructor: ");

        boolean updated = studentService.updateCourse(
                courseId,
                courseName.isEmpty() ? null : courseName,
                instructor.isEmpty() ? null : instructor
        );

        if (updated) {
            System.out.println("\nCourse updated successfully!");
            System.out.println(studentService.getCourseById(courseId));
        } else {
            System.out.println("Failed to update course!");
        }
    }
    private void deleteCourse() {
        System.out.println("\n--- Delete Course ---");

        String courseId = getStringInput("Enter Course ID to delete: ");
        Course course = studentService.getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        System.out.println("\nCourse to be deleted:");
        System.out.println(course);

        String confirm = getStringInput("\nAre you sure you want to delete? (yes/no): ");

        if (confirm.equalsIgnoreCase("yes")) {
            boolean deleted = studentService.deleteCourse(courseId);
            if (deleted) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Failed to delete course!");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    /** Course Methods End **/

    /** Enrollment Methods Start **/
    private void manageEnrollmentsMenu() {
        System.out.println("\n========== MANAGE ENROLLMENTS ==========");
        System.out.println("1. Enroll Student in Course");
        System.out.println("2. Unenroll Student from Course");
        System.out.println("3. View Student Enrollments");
        System.out.println("4. View Course Enrollments");
        System.out.println("5. Back to Main Menu");
        System.out.println("========================================");

        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                enrollStudent();
                break;
            case 2:
                unenrollStudent();
                break;
            case 3:
                viewStudentEnrollments();
                break;
            case 4:
                viewCourseEnrollments();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
    private void enrollStudent() {
        System.out.println("\n--- Enroll Student in Course ---");

        String studentId = getStringInput("Enter Student ID: ");
        String courseId = getStringInput("Enter Course ID: ");

        boolean enrolled = studentService.enrollStudentInCourse(studentId, courseId);

        if (enrolled) {
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Failed to enroll student! (Student/Course not found or course is full)");
        }
    }
    private void unenrollStudent() {
        System.out.println("\n--- Unenroll Student from Course ---");

        String studentId = getStringInput("Enter Student ID: ");
        String courseId = getStringInput("Enter Course ID: ");

        boolean unenrolled = studentService.unenrollStudentFromCourse(studentId, courseId);

        if (unenrolled) {
            System.out.println("Student unenrolled successfully!");
        } else {
            System.out.println("Failed to unenroll student!");
        }
    }
    private void viewStudentEnrollments() {
        System.out.println("\n--- Student Enrollments ---");

        String studentId = getStringInput("Enter Student ID: ");
        List<Enrollment> enrollments = studentService.getEnrollmentsForStudent(studentId);

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found for this student!");
        } else {
            System.out.println("\nEnrollments for Student " + studentId + ":");
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment);
            }
        }
    }
    private void viewCourseEnrollments() {
        System.out.println("\n--- Course Enrollments ---");

        String courseId = getStringInput("Enter Course ID: ");
        List<Enrollment> enrollments = studentService.getEnrollmentsForCourse(courseId);

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found for this course!");
        } else {
            System.out.println("\nEnrollments for Course " + courseId + ":");
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment);
            }
        }
    }
    /** Enrollment Methods End **/

    /** Run Time Polymorphism Example **/
    private void runTimePolymorphism(){
        Person p1 = new Student("P0001", "Goku", 20, "Delhi", "STU001", "CS", 8.5);
        Person p2 = new GraduateStudent("P0001", "Vegeta", 24, "Mumbai", "STU002", "IT", 9.1, "AI", "Thesis", true);

        System.out.println("\n--- Runtime Polymorphism Demo ---");
        p1.displayInfo();  // Executes Student’s displayInfo()
        System.out.println("\n  ");
        p2.displayInfo();  // Executes GraduateStudent’s displayInfo()
    }

    /** Helper Methods Start **/
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input;
    }
    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
    /** Helper Methods End **/
}
