# Student Management System (Console)

A simple command-line Student Management System written in Java. This project provides a menu-driven interface to manage students and their subjects, calculate weighted GPA, and perform basic operations such as adding/removing students and subjects.

## Features

- Add and remove students (with unique ID checks).
- Add and remove subjects for each student.
- Calculate weighted GPA for a student (sum(grade * creditHours) / sum(creditHours)).
- Display detailed student information including subjects and GPA.
- Display all students in the system.
- Find the student with the highest GPA.
- Convert a numeric grade (0–100) to a letter grade (A/B/C/D/F).
- Simple, robust input handling to avoid crashes on invalid input.

## Repository structure

- `Main.java` - Program entry point and menu-driven interface.
- `StudentManagementSystem.java` - Core system managing students and subjects.
- `Student.java` - Student model with subject list and GPA calculation.
- `Subject.java` - Subject model (name, credit hours, numeric grade).
- `InputValidator.java` - Helper for safely reading integers, doubles, and strings from console.

## Requirements

- Java Development Kit (JDK) 8 or newer installed and `javac`/`java` available in PATH.

## How to compile and run (PowerShell)

Open PowerShell in the project directory (where the `.java` files are) and run:

```powershell
# Compile all Java source files
javac *.java

# Run the application
java Main
```

The program is interactive and will show a menu. Enter the number for the operation you want to perform and follow the prompts.

## Example (quick automated session)

You can also pipe input for automated testing. Example (PowerShell style):

```powershell
"1`n1`nAhmed`nCS`n10`n10`n" | java Main
```

This example automates menu selections; use with care and adjust the inputs to match the expected prompts.

## Notes & Suggestions

- The application currently stores everything in memory; data will be lost when the program exits. If you want persistence, consider adding save/load functionality (JSON, CSV, or simple serialization).
- Input handling is defensive thanks to `InputValidator`, but business rules (like disallowing negative IDs) can be tightened if needed.
- Consider adding unit tests (JUnit) for core logic such as `calculateGPA`, `addStudent`, and `addSubjectToStudent`.
- Minor UI cleanup: some print lines and formatting can be improved (for example replacing stray characters like `?` when printing results).

## How to contribute

If you want to extend this project, please edit the source files and open a pull request or add your changes locally. Keep public methods documented and add unit tests for new behavior when possible.

## Contributors

1. Ibraim Saeed — Role/Contribution: Main File
2. Heda Ahmed — Role/Contribution: Subject File
3. Mariam Sameh — Role/Contribution: Student Management File
4. jana Rajab — Role/Contribution: Student Management File
5. Habiba Hossam — Role/Contribution: Student Management File
6. Ali Saad — Role/Contribution: Student File
7. Ammar yasser — Role/Contribution: Student File
8. Ahmed Saeed — Role/Contribution: Collected the project code, wrote and ran tests, and pushed the repository to GitHub.
