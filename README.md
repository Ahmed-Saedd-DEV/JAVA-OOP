# Student Management System
> Java Project — Information Technology Department, Borg Al Arab Technological University  
> Course: Java Programming | Semester 2 — 2025/2026  
> Instructors: Dr. Radwa Rady & Dr. Ghada Fathy

---

## Project Overview

A **menu-driven console application** built in Java that allows users to manage student records including personal information, subjects, grades, and GPA calculations.

The system supports:
- Managing student profiles
- Assigning subjects with credit hours and grades
- Calculating weighted GPA
- Converting numeric grades to letter grades
- Finding the top-performing student

---

## Project Structure

```
StudentManagementSystem/
│
├── Subject.java                  # Represents a course/subject
├── Student.java                  # Represents a student
├── StudentManagementSystem.java  # Core system logic
├── InputValidator.java           # Handles safe user input
└── Main.java                     # Entry point + menu
```

---

## How to Run

### Requirements
- Java JDK 8 or higher installed
- Any terminal / command prompt

### Steps

**1. Compile all files:**
```bash
javac *.java
```

**2. Run the program:**
```bash
java Main
```

---

## Menu Options

```
===== Student Management System =====
1.  Add Student
2.  Add Subject to Student
3.  Display Student Information
4.  Calculate Student GPA
5.  Display All Students
6.  Remove Student
7.  Remove Subject
8.  Show Student with Highest GPA
9.  Convert Numeric Grade to Letter Grade
10. Exit
=====================================
```

---

## GPA Calculation Formula

GPA is calculated using a **weighted average** based on credit hours:

```
GPA = Σ(grade × creditHours) / Σ(creditHours)
```

### Example:

| Subject         | Credit Hours | Grade |
|-----------------|:------------:|:-----:|
| Java            | 3            | 90    |
| Database        | 3            | 80    |
| Data Structures | 4            | 95    |

```
GPA = (90×3 + 80×3 + 95×4) / (3+3+4)
    = (270 + 240 + 380) / 10
    = 890 / 10
    = 89.0
```

---

## Grade Conversion Table

| Numeric Range | Letter Grade |
|:-------------:|:------------:|
| 90 – 100      | A            |
| 80 – 89       | B            |
| 70 – 79       | C            |
| 60 – 69       | D            |
| Below 60      | F            |

---

## Input Validation

The program validates all user input to prevent crashes:

| Validation Rule                        | Error Message                                      |
|----------------------------------------|----------------------------------------------------|
| Grade must be between 0 and 100        | `Error: Invalid grade. Please enter a value between 0 and 100.` |
| Student name cannot be empty           | `Error: Student name cannot be empty.`             |
| Student ID must be unique              | `Error: A student with ID X already exists.`       |
| Student not found when searching       | `Error: Student with ID X not found.`              |
| Invalid subject number when removing   | `Error: Invalid subject number.`                   |
| Credit hours must be positive          | `Error: Credit hours must be a positive number.`   |
| Non-numeric input for numbers          | `Error: Please enter a valid whole number.`        |

---

## Sample Interaction

```
===== Student Management System =====
Enter your choice: 1

--- Add New Student ---
Enter Student ID: 101
Enter Name: Ahmed Ali
Enter Major: Computer Science
Student added successfully!

Enter your choice: 2

--- Add Subject to Student ---
Enter Student ID: 101
Enter Subject Name: Java Programming
Enter Credit Hours: 3
Enter Grade: 92
Subject added to student Ahmed Ali successfully.

Enter your choice: 4

--- Calculate Student GPA ---
Enter Student ID: 101
Student : Ahmed Ali
GPA     : 92.00
```

---

## Team Members 

| # | Member |
|---|--------
| 1 | Ahmed Saeed |

---

## Test Cases

Before submission, make sure to test these scenarios:

-  Add multiple students with different IDs
-  Add several subjects to one student
-  Calculate GPA correctly with different credit hours
-  Try adding a student with a duplicate ID
-  Search for a student ID that does not exist
-  Enter a grade above 100 or below 0
-  Enter an empty name
-  Remove a subject using an invalid number
-  Calculate GPA for a student with no subjects
-  Find the student with the highest GPA among multiple students

---

## Notes

- Each class is in its own separate `.java` file
- Code includes proper indentation, meaningful variable names, and comments
- The program does **not** crash on invalid input — all errors are handled gracefully
- The menu keeps running until the user selects **option 10 (Exit)**

---
