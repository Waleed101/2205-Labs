public interface Iterator<E> { // Iterator interface class
    boolean hasNext(); // Returns if element has next element
    E next(); // Returns next element
    void remove(); // Removes current element
}