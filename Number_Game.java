import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int round = 0;
        int totalScore = 0;

        System.out.println("Welcome to the NUMBER GAME!");
        System.out.println("Hello Player! This is a number game in which you have to guess a random number from 1 to 100 and check whether you have guessed the number same as me. So let's begin.");
        System.out.println("You have 5 attempts to guess the correct number.");

        boolean playing = true;

        while (playing) {
            int systemGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round No. " + (round + 1) + ":");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == systemGuess) {
                    System.out.println("Congratulations! You guessed the correct number in "
                            + attempts + " attempts.");
                    totalScore++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < systemGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + systemGuess);
            }

            round++;

            System.out.print("Do you want to play again? (Yes or No): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equalsIgnoreCase("yes")) {
                playing = false;
            }
        }

        System.out.println("Game over! You played " + round + " rounds and scored " + totalScore + " points.");
        scanner.close();
    }
}

