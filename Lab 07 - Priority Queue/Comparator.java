public interface Comparator<K> { // Comparator interface
    public int compare(K aKey, K bKey) throws ClassCastException;
}