# 📚 Student Management System -- Java Fundamentals Assignment

### **Submitted by: Piyush Narwal*

------------------------------------------------------------------------

## 🚀 Project Overview

This project is a console-based Student Management System built entirely
using core Java concepts such as OOP, inheritance, polymorphism,
abstraction, interfaces, constructor chaining, and dynamic data
structures.

The application supports: - Adding, updating, deleting students\
- Managing courses and enrollments
- Searching students by ID or name
- Viewing all entities in a menu-driven interface

------------------------------------------------------------------------

## 🧩 Directory / Package Structure

    com.airtribe.studentmanagement
    │
    ├── entity
    │   ├── Person.java
    │   ├── Student.java
    │   ├── GraduateStudent.java
    │   ├── Course.java
    │   ├── Enrollment.java
    │   └── Enrollable.java
    │
    ├── service
    │   └── StudentService.java
    │
    ├── util
    │   └── DataTypesAndVariables.java
    │
    └── main
        └── StudentManagementApp.java

------------------------------------------------------------------------

## 🧠 Key Java Concepts Demonstrated

### 🔹 JVM Architecture Report

Included in `JVM_ARCHITECTURE.md`: - JVM internal components
- JIT vs Interpreter
- Bytecode execution
- Write Once, Run Anywhere

------------------------------------------------------------------------

### 🔹 Data Types, Variables & Casting

Implemented in `DataTypesAndVariables.java`: - All 8 primitive types
- Implicit & explicit casting
- Static vs instance variables
- Scope demonstration

------------------------------------------------------------------------

### 🔹 Object-Oriented Programming Concepts

#### ✔ Encapsulation

Private fields + getters/setters in entity classes.

#### ✔ Inheritance (Multilevel)

`Person → Student → GraduateStudent`

#### ✔ Method Overriding (Runtime Polymorphism)

Demonstrated using base-class references:

``` java
Person p = new GraduateStudent(...);
p.displayInfo();
```

#### ✔ Method Overloading (Compile-Time Polymorphism)

Search methods:

``` java
searchStudent(String name)
searchStudent(String id, boolean isIdSearch)
```

------------------------------------------------------------------------

## 🏗 Abstraction vs Interface (Required Explanation)

### **Abstract Class**

-   Can have abstract + concrete methods\
-   Can maintain state
-   Single inheritance only

### **Interface**

-   Only behavior contract
-   No instance state
-   Multiple interfaces allowed

### **In This Project**

-   `Person` = abstract base class
-   `Enrollable` = interface defining behavior

------------------------------------------------------------------------

## 🛠 Constructor Management

Includes: - Default constructors
- Parameterized constructors
- Copy constructors
- Constructor chaining using `this()` + `super()`

------------------------------------------------------------------------

## 📦 Student Management Features

-   Add / Update / Delete Students
-   Add / View Courses
-   Enroll students
-   Search students
-   List all students / courses / enrollments
-   Menu-driven interface using Scanner
-   ArrayList-based dynamic storage

------------------------------------------------------------------------

## 📄 Documentation Included

-   `Setup Documentation.md`
-   `JVM_ARCHITECTURE.md`
-   Compilation & execution screenshots in Setup Documentation

------------------------------------------------------------------------


## 🎉 End of Submission

Thank you for reviewing this project!
