// Task 1: Number Guessing Game
// Author: Vaishali Gupta
// Internship: CodSoft (September 2025)

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===== Welcome to the Number Guessing Game =====");

        // user decides how many rounds they want to play
        System.out.print("Enter number of rounds you want to play: ");
        int rounds = scanner.nextInt();

        int totalScore = 0;

        // run game for given number of rounds
        for (int r = 1; r <= rounds; r++) {
            int targetNumber = random.nextInt(100) + 1;  // random number between 1 and 100
            int attemptsLeft = 7;  // limit attempts
            boolean guessed = false;

            System.out.println("\n--- Round " + r + " ---");
            System.out.println("I have selected a number between 1 and 100. You have " + attemptsLeft + " attempts!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    System.out.println("Attempts used: " + (7 - attemptsLeft + 1));
                    totalScore += attemptsLeft; // more attempts left = more score
                    guessed = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low, try again.");
                } else {
                    System.out.println("Too high, try again.");
                }

                attemptsLeft--;
            }

            if (!guessed) {
                System.out.println("❌ You are out of attempts. The number was: " + targetNumber);
            }
        }

        // final result
        System.out.println("\n===== Game Over =====");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Thanks for playing! #codsoft");

        scanner.close();
    }
}
