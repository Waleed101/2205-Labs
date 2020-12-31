public interface PositionalList<E> { // Interface outlining the positional list class
    int size(); // Function to retunr size

    boolean isEmpty(); // Function to return whether full or empty
    Position<E> first(); // Function to get the first position
    Position<E> last(); // Function to get the last position

    Position<E> before(Position<E> p) throws IllegalArgumentException; // Function to get the position before a specific position
    Position<E> after(Position<E> p) throws IllegalArgumentException; // Function to get the position after a specific position

    Position<E> addFirst(E e); // Function to add to the front of the positional list
    Position<E> addLast(E e); // Function to add to the end of that positional list

    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException; // Function to add a positional element before a specific one passed over
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException; // Function to add a positional element after a specific one passed over

    E set(Position<E> p, E e) throws IllegalArgumentException; // Function to set the position of a specific element
    E remove(Position<E> p) throws IllegalArgumentException; // Function to remove a specific position
}