import java.util.*;

public class Problem5_StopWordWordFrequency {
    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "")
                .replace("\"", "")
                .replace("'", "");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopSet = new HashSet<>(Arrays.asList(stopWords));
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : cleaned.split("\\s+")) {
            if (!word.isEmpty() && !stopSet.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printFilteredWordFrequency(sc.nextLine());
        sc.close();
    }
}
