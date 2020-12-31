public interface PriorityQueue<K,V> { // Interface to set the structure of the priority queue
    int size(); // Return the size
    boolean isEmpty(); // Return whether or not the list is empty
    Entry<K,V> insert(K key, V value) throws IllegalArgumentException; // Insert entry into the queue
    Entry<K,V> min(); // Get minimum entry in the queue
    Entry<K,V> removeMin(); // Remove and return the minimum entry in the queue
}