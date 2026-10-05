package grades;

import java.util.ArrayList;
import java.util.List;

public class GradeManager {

    private List<Double> grades;

    public GradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    public Double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;

        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public int countPassingGrades() {
        int count = 0;

        for (Double grade : grades) {
            if (grade >= 50.0) {
                count++;
            }
        }

        return count;
    }

    public void showGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }

        System.out.println("Grades:");

        for (int i = 0; i < grades.size(); i++) {
            System.out.println((i + 1) + ". " + grades.get(i));
        }
    }

    public boolean removeGradeByPosition(int position) {
        int index = position - 1;

        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
            return true;
        }

        return false;
    }

    public boolean removeGradeByValue(double grade) {
        return grades.remove(grade);
    }
}
