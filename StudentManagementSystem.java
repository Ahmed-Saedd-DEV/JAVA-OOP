import java.util.ArrayList;

public class StudentManagementSystem {

    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(int id, String name, String major) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Student name cannot be empty.");
            return;
        }

        if (searchStudent(id) != null) {
            System.out.println("Error: A student with ID " + id + " already exists.");
            return;
        }

        Student newStudent = new Student(id, name.trim(), major.trim());
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    public void addSubjectToStudent(int studentId, String subjectName, int creditHours, double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Error: Invalid grade. Please enter a value between 0 and 100.");
            return;
        }

        if (creditHours <= 0) {
            System.out.println("Error: Credit hours must be a positive number.");
            return;
        }

        if (subjectName == null || subjectName.trim().isEmpty()) {
            System.out.println("Error: Subject name cannot be empty.");
            return;
        }

        Student student = searchStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return;
        }

        Subject subject = new Subject(subjectName.trim(), creditHours, grade);
        student.addSubject(subject);
    }

    public void displayStudentInfo(int studentId) {
        Student student = searchStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return;
        }
        student.displayStudentInfo();
    }

    public void calculateStudentGPA(int studentId) {
        Student student = searchStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return;
        }

        double gpa = student.calculateGPA();
        System.out.println("Student : " + student.getName());
        System.out.printf("GPA     : %.2f%n", gpa);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system yet.");
            return;
        }

        System.out.println("Students in the system:");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println((i + 1) + ". " + s.getName() + " (ID: " + s.getId() + ")");
        }
    }

    public void removeStudent(int studentId) {
        Student student = searchStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student removed successfully.");
    }

    public void removeSubjectFromStudent(int studentId, int subjectNumber) {
        Student student = searchStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return;
        }

        ArrayList<Subject> subjects = student.getSubjects();
        if (subjects.isEmpty()) {
            System.out.println("This student has no subjects.");
            return;
        }

        System.out.println("Subjects:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getSubjectName());
        }

        student.removeSubject(subjectNumber);
    }

    public void showStudentWithHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        Student topStudent = students.get(0);
        double highestGPA = topStudent.calculateGPA();

        System.out.println("Calculating highest GPA...");
        for (Student student : students) {
            double gpa = student.calculateGPA();
            System.out.printf("%s -> GPA = %.2f%n", student.getName(), gpa);

            if (gpa > highestGPA) {
                highestGPA = gpa;
                topStudent = student;
            }
        }

        System.out.println("\nStudent with Highest GPA:");
        System.out.println("Name : " + topStudent.getName());
        System.out.println("ID   : " + topStudent.getId());
        System.out.printf("GPA  : %.2f%n", highestGPA);
    }

    public void convertToLetterGrade(double numericGrade) {
        if (numericGrade < 0 || numericGrade > 100) {
            System.out.println("Error: Invalid grade. Please enter a value between 0 and 100.");
            return;
        }

        String letter;
        if (numericGrade >= 90)
            letter = "A";
        else if (numericGrade >= 80)
            letter = "B";
        else if (numericGrade >= 70)
            letter = "C";
        else if (numericGrade >= 60)
            letter = "D";
        else
            letter = "F";

        System.out.println("Letter Grade: " + letter);
    }

    public Student searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
