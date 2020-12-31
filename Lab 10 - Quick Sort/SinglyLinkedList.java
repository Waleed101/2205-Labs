public class SinglyLinkedList<E> { // SinglyLinkedList class 
    public static class Node<E> { // Inner node class for custom nodes
        private E element; // Holds the value of each element
        private Node<E> next; // Pointer to the next element
        public Node(E e, Node<E> n) { // Node constructor
            element = e;
            next = n;
        }
        public E getElement() {return element;} // Getting the value of that element
        public Node<E> getNext() {return next;} // Getting the next node
        public void setNext(Node<E> n) {next = n;} // Setting the next node
    }

    private Node<E> head = null, tail = null; // Reference to the head and the tail of the list
    private int size = 0; // Reference to the size of the list
    public SinglyLinkedList() {} // Empty constructor

    public int size() {return size;} // Get the size of the list
    public boolean isEmpty() {return size==0;} // Get whether the list is empty
    public E first() { // Get the first element of the list
        if(isEmpty()) return null;
        return head.getElement();
    }

    public E last() { // Get the last element of the list
        if(isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) { // Add an element to the beginning of the list
        head = new Node<>(e, head);
        if(size == 0) 
            tail = head;
        size++;
    }

    public void addLast(E e) { // Add an element to the end of the list
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() { // Remove the first element in a list
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0)
            tail = null;
        return answer;
    }
}