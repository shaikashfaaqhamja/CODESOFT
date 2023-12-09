import java.util.Random;
import java.util.*;

public class guessthenumber {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        while (true) {
            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
            int userGuess = scanner.nextInt();
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number " + secretNumber + "!");
                totalAttempts += (maxAttempts - Math.max(0, maxAttempts - totalAttempts));
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            totalAttempts++;
            if (totalAttempts >= maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
                break;
            }
        }
        roundsPlayed++;
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Average attempts per round: " + ((double) totalAttempts / roundsPlayed));
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();
        if (playAgain.equals("yes")) {
            playGame();
        } else {
            System.out.println("Thanks for playing!");
            scanner.close();
        }
    }
}
