public class LinkedQueue<E> implements Queue<E> { // Linked queue that implements the queue functionality using a SinglyLinkedList
    private SinglyLinkedList<E> list = new SinglyLinkedList<E>(); // Creating the linked queue
    public LinkedQueue() {} // LinkedQueue empty constructor
    public int size() {return list.size();} // Returning the size of a list
    public boolean isEmpty() {return list.isEmpty();} // Return whether a list is empty
    public void enqueue(E element) {list.addLast(element);} // Implementing the enqueue functionality (adding to the end of a list)
    public E first() {return list.first();} // Implementing the first functionality (returning the first element of a list)
    public E dequeue() {return list.removeFirst();} // Removing and returning the first element of the queue
}