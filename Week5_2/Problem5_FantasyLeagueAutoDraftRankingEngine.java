import java.util.Arrays;
import java.util.Scanner;

public class Problem5_FantasyLeagueAutoDraftRankingEngine {
    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, battingAverage);
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = Arrays.stream(players)
                .filter(p -> Player.isDraftable(p.matchesPlayed)
                        || Player.isDraftable(p.matchesPlayed, p.injured))
                .toArray(Player[]::new);
        Arrays.sort(draftable);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftable[i].name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int matches = sc.nextInt();
            double average = sc.nextDouble();
            boolean injured = sc.nextBoolean();
            players[i] = new Player(name, matches, average, injured);
        }
        System.out.println(draftAndRank(players));
        sc.close();
    }
}
