package collection_Day3;

import java.util.*;

public class Q12_VotingSystem {
    // Map to store candidate names and their respective vote counts
    Map<String, Integer> votes = new HashMap<>();

    // Method to add a vote to a candidate
    public void vote(String candidate) {
        // If candidate already has votes, increment it, else set it to 1
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    // to sort the candidates by vote count (descending order)
    public void displayResults() {
        // Create a list of entries from the map (candidate and vote count)
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(votes.entrySet());

        // Sort the list based on vote count in descending order
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        //  sorted results
        System.out.println("Voting Results (Sorted by Votes Descending):");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        Q12_VotingSystem votingSystem = new Q12_VotingSystem();


        votingSystem.vote("Bhavik");
        votingSystem.vote("samiksha");
        votingSystem.vote("Ranu");
        votingSystem.vote("Aman");
        votingSystem.vote("Arpit");
        votingSystem.vote("Hardik");
        votingSystem.vote("Kartik");


        votingSystem.displayResults();
    }
}
