import java.util.Arrays;
import java.util.Scanner;

public class Problem1_FantasyTeamScoreMultiplier {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextDouble();
        int captain = sc.nextInt(), viceCaptain = sc.nextInt();
        applyMultipliers(scores, captain, viceCaptain);
        System.out.println(Arrays.toString(scores));
        sc.close();
    }
}
