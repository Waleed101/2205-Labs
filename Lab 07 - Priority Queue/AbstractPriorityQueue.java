public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{ // Implementation of the priority queue class
    protected static class PQEntry<K,V> implements Entry<K,V> { // PQ Entry inner class to provide a custom Entry class
        private K k;
        private V v;
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        public K getKey() { return k; }
        public V getValue() {return v;}

        protected void setKey(K key) {k = key;}
        protected void setValue(V value) {v = value;}
    }

    private Comparator<K> comp;

    // Constructors
    protected AbstractPriorityQueue(Comparator<K> c) {comp = c;}
    protected AbstractPriorityQueue() {this(new DefaultComparator<K>());}

    protected int compare(Entry<K,V> a, Entry<K,V> b) { // Compare two entries keys to see which is bigger
        return comp.compare(a.getKey(), b.getKey());
    } 

    protected boolean checkKey(K key) throws IllegalArgumentException { // Ensure key exists
        try {
            return (comp.compare(key, key) == 0);
        }
        catch(ClassCastException e) {
            throw new IllegalArgumentException("Incompatible Key");
        }
    }

    public boolean isEmpty() {return size() == 0;} // Check if list is empty
}