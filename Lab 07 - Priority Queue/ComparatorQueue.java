class ComparatorQueue<K> implements Comparator<K> { // Comparator for queues implementation, used when called
    ComparatorQueue() {}

    public int compare(K aKey, K bKey) throws ClassCastException {
        return ((Comparable<K>) aKey).compareTo(bKey);
    }
}