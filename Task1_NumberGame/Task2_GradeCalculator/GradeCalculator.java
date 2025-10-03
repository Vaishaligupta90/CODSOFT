// GradeCalculator.java
// Vaishali Gupta - CodSoft internship
// Run:
// javac GradeCalculator.java
// java GradeCalculator

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Grade Calculator - Vaishali's version");

        System.out.print("How many subjects? ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
            if (n <= 0) {
                System.out.println("Number of subjects must be positive. Exiting.");
                sc.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid number. Exiting.");
            sc.close();
            return;
        }

        double total = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Marks for subject " + i + " (0-100): ");
            double marks;
            try {
                marks = Double.parseDouble(sc.nextLine().trim());
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks, set 0-100. Please re-enter this subject.");
                    i--;
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please re-enter this subject.");
                i--;
                continue;
            }
            total += marks;
        }

        double average = total / n;
        String grade = calculateGrade(average);

        System.out.println("Total marks: " + total);
        System.out.printf("Average: %.2f%%\n", average);
        System.out.println("Assigned Grade: " + grade);
        sc.close();
    }

    private static String calculateGrade(double avg) {
        if (avg >= 90) return "A+";
        if (avg >= 80) return "A";
        if (avg >= 70) return "B";
        if (avg >= 60) return "C";
        if (avg >= 50) return "D";
        return "F";
    }
}
