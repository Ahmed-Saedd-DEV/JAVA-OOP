import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator(scanner);

        boolean running = true;

        while (running) {
            printMenu();

            int choice = validator.readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    System.out.println("\n--- Add New Student ---");
                    int id = validator.readInt("Enter Student ID: ");
                    String name = validator.readString("Enter Name: ");
                    String major = validator.readString("Enter Major: ");
                    system.addStudent(id, name, major);
                    break;

                case 2:
                    System.out.println("\n--- Add Subject to Student ---");
                    int studentId = validator.readInt("Enter Student ID: ");
                    String subjectName = validator.readString("Enter Subject Name: ");
                    int creditHours = validator.readInt("Enter Credit Hours: ");
                    double grade = validator.readDouble("Enter Grade: ");
                    system.addSubjectToStudent(studentId, subjectName, creditHours, grade);
                    break;

                case 3:
                    System.out.println("\n--- Display Student Information ---");
                    int displayId = validator.readInt("Enter Student ID: ");
                    system.displayStudentInfo(displayId);
                    break;

                case 4:
                    System.out.println("\n--- Calculate Student GPA ---");
                    int gpaId = validator.readInt("Enter Student ID: ");
                    system.calculateStudentGPA(gpaId);
                    break;

                case 5:
                    System.out.println("\n--- All Students ---");
                    system.displayAllStudents();
                    break;

                case 6:
                    System.out.println("\n--- Remove Student ---");
                    int removeId = validator.readInt("Enter Student ID to remove: ");
                    system.removeStudent(removeId);
                    break;

                case 7:
                    System.out.println("\n--- Remove Subject from Student ---");
                    int sId = validator.readInt("Enter Student ID: ");

                    ArrayList<Subject> subjects = null;
                    if (system.searchStudent(sId) != null) {
                        subjects = system.searchStudent(sId).getSubjects();
                        if (subjects.isEmpty()) {
                            System.out.println("This student has no subjects.");
                            break;
                        }
                        System.out.println("Subjects:");
                        for (int i = 0; i < subjects.size(); i++) {
                            System.out.println((i + 1) + ". " + subjects.get(i).getSubjectName());
                        }
                        int subjectNum = validator.readInt("Enter subject number to remove: ");
                        system.searchStudent(sId).removeSubject(subjectNum);
                    } else {
                        System.out.println("Error: Student with ID " + sId + " not found.");
                    }
                    break;

                case 8:
                    System.out.println("\n--- Student with Highest GPA ---");
                    system.showStudentWithHighestGPA();
                    break;

                case 9:
                    System.out.println("\n--- Convert Numeric Grade to Letter Grade ---");
                    double numGrade = validator.readDouble("Enter numeric grade: ");
                    system.convertToLetterGrade(numGrade);
                    break;

                case 10:
                    System.out.println("Goodbye! Thank you for using the Student Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("Error: Invalid choice. Please enter a number from 1 to 10.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Student Management System =====");
        System.out.println("1.  Add Student");
        System.out.println("2.  Add Subject to Student");
        System.out.println("3.  Display Student Information");
        System.out.println("4.  Calculate Student GPA");
        System.out.println("5.  Display All Students");
        System.out.println("6.  Remove Student");
        System.out.println("7.  Remove Subject");
        System.out.println("8.  Show Student with Highest GPA");
        System.out.println("9.  Convert Numeric Grade to Letter Grade");
        System.out.println("10. Exit");
        System.out.println("=====================================");
    }
}
