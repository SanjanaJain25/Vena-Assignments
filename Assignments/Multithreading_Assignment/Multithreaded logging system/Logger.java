package Multithreading_Assignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class Logger {
    // Enum for log levels
    public enum LogLevel {
        INFO, WARN, ERROR
    }

    private final BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
    private final Thread logFlusher;
    private volatile boolean running = true;
    private final boolean logToFile;
    private PrintWriter fileWriter;

    // Constructor
    public Logger(boolean logToFile) {
        this.logToFile = logToFile;

        // Setup file writer if enabled
        if (logToFile) {
            try {
                fileWriter = new PrintWriter(new FileWriter("logs.txt", true), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Background flusher thread
        logFlusher = new Thread(() -> {
            while (running || !logQueue.isEmpty()) {
                try {
                    Thread.sleep(5000);
                    flushLogs();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupt flag
                }
            }
            // Final flush on shutdown
            flushLogs();
            if (fileWriter != null) fileWriter.close();
        });

        logFlusher.start();
    }

    // Public log method
    public void log(LogLevel level, String message) {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String formatted = "[" + timestamp + "] [" + level + "] " + message;
        logQueue.offer(formatted);
    }

    // Convenience method: default INFO level
    public void log(String message) {
        log(LogLevel.INFO, message);
    }

    // Flush log entries to output
    private void flushLogs() {
        while (!logQueue.isEmpty()) {
            String log = logQueue.poll();
            if (logToFile && fileWriter != null) {
                fileWriter.println(log);
            } else {
                System.out.println(log);
            }
        }
    }

    // Graceful shutdown
    public void shutdown() {
        running = false;
        try {
            logFlusher.join(); // wait for flushing thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Main method for stress testing
    public static void main(String[] args) {
        Logger logger = new Logger(false); // true to log to file

        // Simulate 100 threads × 100 logs
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100; i++) {
            int threadId = i;
            executor.submit(() -> {
                for (int j = 1; j <= 100; j++) {
                    logger.log(LogLevel.INFO, "Thread " + threadId + " - Message " + j);
                }
            });
        }

        // Shutdown executor and logger
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.shutdown();
        System.out.println("All logs flushed. Exiting.");
    }
}
