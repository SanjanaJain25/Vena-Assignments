package collection_Day3;

import java.util.*;

public class Q2_WordFrequencyCounter {

    public static void main(String[] args) {

        String paragraph = "Java is simple. Java is powerful. Java is platform-independent.";

        // Convert to lowercase and split into words, removing punctuation
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

        //  store word frequencies
        Map<String, Integer> wordFreq = new HashMap<>();

        // Fill map with word count
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }

        // TreeSet to sort unique words alphabetically
        Set<String> sortedWords = new TreeSet<>(wordFreq.keySet());

        //
        System.out.println("Total Unique Words: " + sortedWords.size());

        System.out.println("\nWord Frequencies (Alphabetically):");
        for (String word : sortedWords) {
            System.out.println(word + " : " + wordFreq.get(word));
        }
    }
}
