class DefaultComparator<K> implements Comparator<K> { // Default comparator if one is not intialized
    DefaultComparator() {}

    public int compare(K aKey, K bKey) throws ClassCastException {
        return ((Comparable<K>) aKey).compareTo(bKey);
    }
}