import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        boolean playAgain = true;
        int totalGames = 0;
        int totalWins = 0;


        while (playAgain) {
            boolean isWin = playGame();
            totalGames++;
            if (isWin) {
                totalWins++;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
            playAgain = (choice == JOptionPane.YES_OPTION);
        }

        double winRate = (double) totalWins / totalGames * 100; //optional could add or remove this
        JOptionPane.showMessageDialog(null, "Total games played: " + totalGames + "\nTotal wins: " + totalWins + "\nWin rate: " + winRate + "%");
    }


    public static boolean playGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        int count = 3;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game! You have " + count + " tries to win.");

        while (true) {
            String input = JOptionPane.showInputDialog("Enter your guess (1-100): ");
            int userGuess = Integer.parseInt(input);
            count--;

            if (userGuess == randomNumber) {
                JOptionPane.showMessageDialog(null, "Correct! You've won!");
                return true;
            }
            else if (randomNumber > userGuess) {
                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "Sorry, you lost. The correct number was " + randomNumber);
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Number is higher, try again.\nYou have " + count + " tries left.");

            }
            else {
                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "Sorry, you lost. The correct number was " + randomNumber);
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Number is lower, try again.\nYou have " + count + " tries left.");
            }
        }
    }

}
