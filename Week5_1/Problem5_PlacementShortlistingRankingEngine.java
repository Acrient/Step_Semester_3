import java.util.Arrays;
import java.util.Scanner;

public class Problem5_PlacementShortlistingRankingEngine {
    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), compositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] eligible = Arrays.stream(candidates)
                .filter(c -> Candidate.isEligible(c.cgpa)
                        || Candidate.isEligible(c.cgpa, c.codingScore))
                .toArray(Candidate[]::new);
        Arrays.sort(eligible);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < eligible.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(eligible[i].name)
                  .append(" (").append(String.format("%.1f", eligible[i].compositeScore())).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Candidate[] candidates = new Candidate[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double cgpa = sc.nextDouble();
            int coding = sc.nextInt();
            candidates[i] = new Candidate(name, cgpa, coding);
        }
        System.out.println(shortlistAndRank(candidates));
        sc.close();
    }
}
