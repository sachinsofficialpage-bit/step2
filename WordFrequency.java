import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // HashMap to store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            boolean isStopWord = false;

            // Check whether word is a stop word
            for (int j = 0; j < stopWords.length; j++) {

                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count word
            if (frequency.containsKey(word)) {

                frequency.put(
                    word,
                    frequency.get(word) + 1
                );

            } 
            else {

                frequency.put(word, 1);
            }
        }

        // Convert HashMap entries to a list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        list.sort(
            (a, b) -> b.getValue() - a.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}