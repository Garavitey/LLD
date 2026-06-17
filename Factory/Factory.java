//import java.util.*;
//
//enum StoreType {
//    FIFO,
//    PRIORITY,
//    UNIQUE
//}
//
//// 1. The common interface
//interface TaskStore {
//    void addTask(String task);
//    String getNextTask();
//    int size();
//}
//
//// 2. FIFO Implementation
//class FifoTaskStore implements TaskStore {
//    // TODO: Declare your Collection here (Hint: You need a Queue)
//    Queue<String> queue = new ArrayDeque<>();
//
//    @Override
//    public void addTask(String task) {
//        queue.add(task);
//    }
//
//    @Override
//    public String getNextTask() {
//        // TODO: Return and remove the next task. Return null if empty.
//        if(queue.isEmpty()){
//            return null;
//        }
//        else{
//            return queue.poll();
//        }
//    }
//
//    @Override
//    public int size() {
//        return queue.size();
//    }
//}
//
//// 3. Priority Implementation
//class PriorityTaskStore implements TaskStore {
//    // TODO: Declare your Collection here (Hint: Needs to sort alphabetically naturally)
//    PriorityQueue<String> pq = new PriorityQueue<>();
//
//    @Override
//    public void addTask(String task) {
//        pq.add(task);
//    }
//
//    @Override
//    public String getNextTask() {
//
//        return pq.poll();
//    }
//
//    @Override
//    public int size() {
//        return pq.size();
//    }
//}
//
//// 4. Unique Implementation
//class UniqueTaskStore implements TaskStore {
//    // TODO: Declare your Collection here (Hint: Needs to preserve insertion order BUT ignore duplicates)
//    Set<String> st = new HashSet<>();
//
//    @Override
//    public void addTask(String task) {
//        //
//        st.add(task);
//
//    }
//
//    @Override
//    @Override
//    public int size() {
//        // TODO
//        return st.size();
//    }
//}
//
//// 5. The Factory
//public class Factory {
//
//    public TaskStore createStore(StoreType type) {
//        // TODO: Implement a switch statement based
//
//        if(type == StoreType.FIFO){
//            return  new FifoTaskStore();
//        } else if (type == StoreType.PRIORITY) {
//            return new PriorityTaskStore();
//
//        } else if (type == StoreType.UNIQUE) {
//            return new UniqueTaskStore();
//        }
//        return null;
//    }
//
//    // A main method so you can test your code right here in the IDE
//    public static void main(String[] args) {
//        Factory factory = new Factory();
//
//        // Example test:
//        // TaskStore myStore = factory.createStore(StoreType.FIFO);
//        // myStore.addTask("Task 1");
//        // System.out.println(myStore.getNextTask());
//    }
//}