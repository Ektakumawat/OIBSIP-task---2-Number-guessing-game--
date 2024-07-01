import java.util.Random;
import java.util.Scanner;

public class task2{
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("I have selected a number between " + RANGE_START + " and " + RANGE_END + ". Can you guess it?");

            while (attemptsLeft > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    hasGuessedCorrectly = true;
                    int pointsEarned = attemptsLeft * 10;
                    totalScore += pointsEarned;
                    System.out.println("Congratulations! You've guessed the correct number.");
                    System.out.println("You earned " + pointsEarned + " points.");
                } else if (userGuess < targetNumber) {
                    System.out.println("The number is higher than " + userGuess + ". Try again.");
                } else {
                    System.out.println("The number is lower than " + userGuess + ". Try again.");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Your total score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}