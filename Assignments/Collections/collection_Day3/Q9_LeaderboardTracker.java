package collection_Day3;

import java.util.*;

// Player class
class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return name + " → Score: " + score;
    }
}

// compare players based on their score in descending order
class ScoreComparator implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        return Integer.compare(p2.getScore(), p1.getScore()); // Sort in descending order
    }
}

public class Q9_LeaderboardTracker {
    // maintain players sorted by score (descending order)
    TreeSet<Player> leaderboard;

    public Q9_LeaderboardTracker() {
        // Initialize TreeSet with a custom comparator to sort by score descending
        leaderboard = new TreeSet<>(new ScoreComparator());
    }

    // Method to add a player to the leaderboard
    public void addPlayer(Player player) {
        leaderboard.add(player);
    }


    public void updatePlayerScore(Player player, int newScore) {
        //  remove the player with the old score
        leaderboard.remove(player);

        // Update the player's score
        player.setScore(newScore);

        // Add the player back with the updated score (leaderboard will re-sort itself)
        leaderboard.add(player);
    }

    // Method to display the leaderboard
    public void displayLeaderboard() {
        System.out.println("\n🏅 Leaderboard (Top Scorers):");
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }

    public static void main(String[] args) {
        Q9_LeaderboardTracker tracker = new Q9_LeaderboardTracker();

        // Add players
        Player player1 = new Player("Alice", 120);
        Player player2 = new Player("Bob", 150);
        Player player3 = new Player("Carol", 100);

        tracker.addPlayer(player1);
        tracker.addPlayer(player2);
        tracker.addPlayer(player3);

        // Display leaderboard
        tracker.displayLeaderboard();

        // Update Bob's score
        System.out.println("\nUpdating Bob's score...");
        tracker.updatePlayerScore(player2, 180);

        // Display updated leaderboard
        tracker.displayLeaderboard();
    }
}
