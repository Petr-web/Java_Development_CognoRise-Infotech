import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] WORDS = { "java", "programming", "hangman", "computer", "code" };
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedLetters = new char[wordToGuess.length()];
        boolean[] guessed = new boolean[wordToGuess.length()];
        int attempts = 0;
        boolean gameOver = false;

        while (attempts < MAX_ATTEMPTS && !gameOver) {
            System.out.println("Word: " + getGuessedWord(guessedLetters));
            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess && !guessed[i]) {
                    guessed[i] = true;
                    guessedLetters[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts++;
                System.out.println("Incorrect guess. Try again!");
            }

            gameOver = isWordGuessed(guessed);
        }

        if (gameOver) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
        }

        scanner.close();
    }

    private static String getGuessedWord(char[] guessedLetters) {
        StringBuilder sb = new StringBuilder();
        for (char c : guessedLetters) {
            if (c == '\0') {
                sb.append('_');
            } else {
                sb.append(c);
            }
            sb.append(' ');
        }
        return sb.toString();
    }

    private static boolean isWordGuessed(boolean[] guessed) {
        for (boolean b : guessed) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
