import java.util.Scanner;

public class Problem4_MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int runs : row) sum += runs;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) result.append(" | ");
            result.append("Match ").append(i).append(": ")
                  .append(rowAverage(runsPerOver[i]) >= threshold
                          ? "Power Surge" : "Normal");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matches = sc.nextInt();
        int[][] runs = new int[matches][];
        for (int i = 0; i < matches; i++) {
            int overs = sc.nextInt();
            runs[i] = new int[overs];
            for (int j = 0; j < overs; j++) runs[i][j] = sc.nextInt();
        }
        int threshold = sc.nextInt();
        System.out.println(classifyMatches(runs, threshold));
        sc.close();
    }
}
