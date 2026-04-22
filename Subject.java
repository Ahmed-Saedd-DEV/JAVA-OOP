public class Subject {

    private String subjectName;
    private int creditHours;
    private double grade;

    public Subject(String subjectName, int creditHours, double grade) {
        this.subjectName = subjectName;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public double getGrade() {
        return grade;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getLetterGrade() {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "F";
    }

    @Override
    public String toString() {
        return subjectName + " - Grade: " + grade + " - Credit Hours: " + creditHours;
    }
}
