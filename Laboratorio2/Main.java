import grades.GradeManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1. Add grade");
            System.out.println("2. View average grade");
            System.out.println("3. View number of passing grades");
            System.out.println("4. Exit");
            System.out.println("5. Delete a grade");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter a grade: ");
                    double grade = scanner.nextDouble();

                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade. Enter a value between 0 and 100.");
                    } else {
                        gradeManager.addGrade(grade);
                        System.out.println("Grade added successfully.");
                    }
                    break;

                case 2:
                    System.out.println(
                        "Average grade: " + gradeManager.calculateAverage()
                    );
                    break;

                case 3:
                    System.out.println(
                        "Number of passing grades: " +
                        gradeManager.countPassingGrades()
                    );
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                case 5:
                    gradeManager.showGrades();

                    System.out.println("\nDelete grade:");
                    System.out.println("1. Delete by position");
                    System.out.println("2. Delete by value");
                    System.out.print("Choose an option: ");

                    int deleteChoice = scanner.nextInt();

                    if (deleteChoice == 1) {
                        System.out.print("Enter the position of the grade: ");
                        int position = scanner.nextInt();

                        if (gradeManager.removeGradeByPosition(position)) {
                            System.out.println("Grade deleted successfully.");
                        } else {
                            System.out.println("Invalid position.");
                        }

                    } else if (deleteChoice == 2) {
                        System.out.print("Enter the grade to delete: ");
                        double gradeToDelete = scanner.nextDouble();

                        if (gradeManager.removeGradeByValue(gradeToDelete)) {
                            System.out.println("Grade deleted successfully.");
                        } else {
                            System.out.println("Grade not found.");
                        }

                    } else {
                        System.out.println("Invalid delete option.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
