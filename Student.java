import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String major;
    private ArrayList<Subject> subjects;

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        System.out.println("Subject added to student " + name + " successfully.");
    }

    public boolean removeSubject(int index) {
        if (index < 1 || index > subjects.size()) {
            System.out.println("Error: Invalid subject number.");
            return false;
        }
        subjects.remove(index - 1);
        System.out.println("Subject removed successfully.");
        return true;
    }

    public double calculateGPA() {
        if (subjects.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            totalPoints += subject.getGrade() * subject.getCreditHours();
            totalCredits += subject.getCreditHours();
        }

        if (totalCredits == 0)
            return 0.0;

        return totalPoints / totalCredits;
    }

    public void displayStudentInfo() {
        System.out.println("------------------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Major      : " + major);
        System.out.println("Subjects   :");

        if (subjects.isEmpty()) {
            System.out.println("  No subjects added yet.");
        } else {
            for (Subject subject : subjects) {
                System.out.println("  - " + subject);
            }
        }
        System.out.printf("GPA        : %.2f%n", calculateGPA());
        System.out.println("------------------------------------");
    }
}
