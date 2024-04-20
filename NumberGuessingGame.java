import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 1; // lower bound of the guessing range
        int upperBound = 100; // upper bound of the guessing range
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Generate random number

        int attempts = 0;
        final int maxAttempts = 5; // Maximum number of attempts allowed

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ".");

        boolean guessedCorrectly = false;

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly!");
                System.out.println("Number of attempts: " + attempts);
                guessedCorrectly = true;
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
            System.out.println("The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
