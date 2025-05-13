package Multithreading_Assignment;

import java.util.*;
import java.util.concurrent.*;

public class ImageProcessor {
    public static void main(String[] args) throws Exception {
        int totalImages = 50;

        
        long startTime = System.currentTimeMillis();

        // Fixed thread pool of size 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // List to store Future objects
        List<Future<String>> results = new ArrayList<>();

        // Submit 50 image tasks
        for (int i = 1; i <= totalImages; i++) {
            int imageId = i;

            // Submit Callable task
            Future<String> future = executor.submit(() -> {
                Thread.sleep(100); // Simulate image processing
                return "Image " + imageId + " processed";
            });

            results.add(future);
        }

        // Print results in order
        for (Future<String> future : results) {
            System.out.println(future.get()); // get() blocks until result is ready
        }

        // Shutdown thread pool
        executor.shutdown();

        // Measure total time
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time: " + (endTime - startTime) + " ms");
    }
}
