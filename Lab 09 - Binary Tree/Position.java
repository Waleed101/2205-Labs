public interface Position<E> { // Interface to hold the poisition of the element
    E getElement() throws IllegalArgumentException;
}