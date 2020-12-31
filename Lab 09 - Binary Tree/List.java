public interface List<E> { // List interaface class
    int size(); // Returns size in practice
    boolean isEmpty(); // Returns true if empty in practice

    E get(int i) throws IndexOutOfBoundsException; // Function to get element at specific index
    E set(int i, E e) throws IndexOutOfBoundsException; // Function set element at specific index

    void add(int i, E e) throws IndexOutOfBoundsException; // Function to add element at specific index
    E remove(int i) throws IndexOutOfBoundsException; // Function to remove element at specific index
}