import java.lang.IllegalArgumentException; // Needed to avoid compiler error

public class LinkedPositionalList<E> implements PositionalList<E> {
    public static class Node<E> implements Position<E> { // Node class that revolves around the position interface
        private E element;
        private Node<E> prev, next;
        public Node(E e, Node<E> p, Node<E> n) { // Node constructor
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() throws IllegalStateException { // Function to get the element
            if(next == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        public Node<E> getPrev() {  return prev;    } // Function to get the previous node
        public Node<E> getNext() {  return next;    } // Function to get the next node
        public void setElement(E e) {   element = e;    } // Function to set the element
        public void setPrev(Node<E> p) {    prev = p;   } // Function to set the previous node
        public void setNext(Node<E> n) {    next = n;   } // Function to set the next node
    }

    private Node<E> header, trailer;
    private int size;

    public LinkedPositionalList() { // Constructor for doubly linked list
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException { // Function to ensure valid position
        if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if(node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) { // Function to 
        if(node == header || node == trailer)
            return null;
        return node;
    }

    public int size() {return size;} // Function to get the size of the positional list
    public boolean isEmpty() {return size == 0;} // Function to get whether a positional list is empty

    public Position<E> first() {return position(header.getNext());} // Function to get the position of the first node 
    public Position<E> last() {return position(trailer.getPrev());} // Function to get the position of the last node
    
    public Position<E> before(Position<E> p) throws IllegalArgumentException { // Function to get the position before a node
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException { // Function to get the position after a node
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) { // Private function to simplify the addition of new nodes
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    public Position<E> addFirst(E e) { // Function to add to the beginning of a positional list
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) { // Function to add to the end of a positional list
        return addBetween(e, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException { // Function to add before a specific position
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException { // Function to add after a specific position 
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException { // Function to set the element of a node at a specific position
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    public E remove(Position<E> p) throws IllegalArgumentException { // Function to remove the node at a specific position and return its element
        Node<E> node = validate(p), predecessor = node.getPrev(), successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }
}