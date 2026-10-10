public class Problem2_QuizScorecard {
    static class Scorecard {
        private final boolean[] results;
        private int recorded = 0;

        Scorecard(int questionCount) {
            results = new boolean[questionCount];
        }

        void recordAnswer(boolean correct) {
            if (recorded < results.length) {
                results[recorded++] = correct;
            } else {
                System.out.println("All answers already recorded");
            }
        }

        int getScore() {
            int score = 0;
            for (int i = 0; i < recorded; i++) {
                if (results[i]) score++;
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
