package collection_Day3;

import java.util.*;

public class Q7_MovieRattingAggregator {

    //  movie name and list of ratings
    Map<String, List<Integer>> movieRatings = new HashMap<>();


    void addRating(String movieName, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Must be between 1 and 5.");
            return;
        }

        movieRatings.putIfAbsent(movieName, new ArrayList<>());
        movieRatings.get(movieName).add(rating);
    }


    void displayAverageRatings() {
        //  list to hold movie name and its average rating
        List<Map.Entry<String, Double>> averages = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
            String movie = entry.getKey();
            List<Integer> ratings = entry.getValue();

            // Calculate average
            double sum = 0;
            for (int r : ratings) {
                sum += r;
            }
            double avg = sum / ratings.size();

            averages.add(new AbstractMap.SimpleEntry<>(movie, avg));
        }

        // average rating descending
        averages.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));


        System.out.println("\n🎬 Movie Ratings (Highest to Lowest):");
        for (Map.Entry<String, Double> entry : averages) {
            System.out.printf("%s → ⭐ Average: %.2f\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        Q7_MovieRattingAggregator aggregator = new Q7_MovieRattingAggregator();

        //  sample ratings
        aggregator.addRating("Chava", 5);
        aggregator.addRating("Chava", 4);
        aggregator.addRating("Marco", 5);
        aggregator.addRating("Marco", 3);
        aggregator.addRating("kGF", 5);
        aggregator.addRating("KGF", 5);
        aggregator.addRating("KGF", 4);


        aggregator.displayAverageRatings();
    }
}
