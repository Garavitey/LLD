public class ConfigurationManager {

    // TODO: 1. Declare the static instance variable.
    // Hint: You need the 'volatile' keyword here. It ensures that when one thread
    // initializes this variable, all other threads immediately see the updated value in main memory.
    private static volatile ConfigurationManager instance;

    // TODO: 2. Create a private constructor.
    // This prevents any other class from doing `new ConfigurationManager()`.
    // Inside the constructor, print "Configuration Manager Initialized!" so we can test it.

    private ConfigurationManager() {
        System.out.println("Configuration Manager Initialized");
    }

    // TODO: 3. Implement the thread-safe global access point
    public static ConfigurationManager getInstance() {

        // First Check: If it is not null, we skip the lock entirely (fast performance)
        if (instance == null) {

            // Acquire the lock for this specific class
            synchronized (ConfigurationManager.class) {

                // Second Check: Once inside the lock, check if it is STILL null.
                // (Another thread might have initialized it while we were waiting for the lock!)
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    // A dummy method to simulate work
    public void loadConfig(String key, String value) {
        System.out.println("Loaded: " + key + " = " + value);
    }

    // ---------------------------------------------------------
    // TEST YOUR CODE
    // ---------------------------------------------------------
    public static void main(String[] args) {
        // We will create 3 threads that all try to get the instance at the exact same time
        Runnable task = () -> {
            ConfigurationManager manager = ConfigurationManager.getInstance();
            System.out.println("Got instance: " + manager.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        // If your singleton is truly thread-safe, "Configuration Manager Initialized!"
        // will only print ONCE, and all three hashCodes will be exactly the same.
    }
}