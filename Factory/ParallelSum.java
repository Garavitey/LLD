import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelSum {

    // We use underscores in Java numbers for readability (same as commas)
    private static final long MAX_NUMBER = 100_000_000L;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("=====================================");
        System.out.println("   SINGLE-THREADED SUM EXECUTION");
        System.out.println("=====================================");
        singleThreadSum();

        System.out.println("\n=====================================");
        System.out.println("   MULTI-THREADED SUM EXECUTION");
        System.out.println("=====================================");
        multiThreadSum();
    }

    // ---------------------------------------------------------
    // 1. The Standard Single Thread Approach
    // ---------------------------------------------------------
    private static void singleThreadSum() {
        long startTime = System.currentTimeMillis();
        long sum = 0;

        for (long i = 1; i <= MAX_NUMBER; i++) {
            sum += i;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Sum: " + sum);
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
    }

    // ---------------------------------------------------------
    // 2. The Multi-Threaded Approach
    // ---------------------------------------------------------
    private static void multiThreadSum() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        // Create a pool of 10 workers
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // This list will hold the "promises" of the partial sums from each thread
        List<Future<Long>> futures = new ArrayList<>();

        // Divide the 100,000,000 numbers into 10 equal chunks of 10,000,000
        long chunkSize = MAX_NUMBER / NUM_THREADS;

        // Dispatch tasks to the threads
        for (int i = 0; i < NUM_THREADS; i++) {
            long startRange = (i * chunkSize) + 1;
            long endRange = (i + 1) * chunkSize;

            // Callable is just like Runnable, but it returns a value
            Callable<Long> task = () -> {
                long partialSum = 0;
                for (long j = startRange; j <= endRange; j++) {
                    partialSum += j;
                }
                System.out.println(Thread.currentThread().getName() +
                        " summed from " + startRange + " to " + endRange +
                        " ---> Partial Sum: " + partialSum);
                return partialSum;
            };

            // Hand the task to the worker pool, and save the Future result
            futures.add(executor.submit(task));
        }

        // Gather all the results from the threads
        long totalSum = 0;
        for (Future<Long> future : futures) {
            // .get() will automatically pause the main thread until this specific worker is finished
            totalSum += future.get();
        }

        // Always shut down your thread pool!
        executor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("\nTotal Sum: " + totalSum);
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
    }
}