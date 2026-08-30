package arrays_and_strings.practice_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            System.out.println("Round " + i +
                    " - Player: " + playerMove +
                    ", Computer: " + computerMove +
                    " - " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + winPercentage + "%");

        sc.close();
    }
}