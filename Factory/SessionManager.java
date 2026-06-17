import java.util.*;
import java.util.concurrent.*;

public class SessionManager {

    // The standard, non-thread-safe collection
    private Map<String, String> activeSessions = new ConcurrentHashMap<>();


    public void login(String userId, String token) {
        // Simulating the backend adding a session
        activeSessions.put(userId, token);
    }

    public int getTotalSessions() {
        return activeSessions.size();
    }

    // ---------------------------------------------------------
    // TEST THE CHAOS
    // ---------------------------------------------------------
    public static void main(String[] args) throws InterruptedException {
        SessionManager manager = new SessionManager();

        // Simulating a server that can handle 100 simultaneous requests
        ExecutorService serverThreadPool = Executors.newFixedThreadPool(100);

        // We simulate 10,000 users logging in at the exact same time
        for (int i = 0; i < 10000; i++) {
            final int userId = i;
            serverThreadPool.execute(() -> {
                manager.login("User_" + userId, "Token_" + userId);
            });
        }

        // Wait for all requests to finish
        serverThreadPool.shutdown();
        serverThreadPool.awaitTermination(1, TimeUnit.MINUTES);

        // If the system is perfectly safe, this MUST print 10000.
        System.out.println("Expected Sessions: 10000");
        System.out.println("Actual Sessions: " + manager.getTotalSessions());
    }
}