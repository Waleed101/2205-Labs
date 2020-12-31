// Node-based, linked structure implementation of a binary tree
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    // Nested Node class
    protected static class Node<E> implements Position<E> {
        private E element; // Element stored within the node
        private Node<E> parent, left, right; // Refernce to the parent, left child, and right child

        // Node constructor
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // Accessor methods 
        public E getElement() {return element;}
        public Node<E> getParent() {return parent;}
        public Node<E> getLeft() {return left;}
        public Node<E> getRight() {return right;}

        // Update methods
        public void setElement(E e) {element = e;}
        public void setParent(Node<E> parentNode){parent = parentNode;}
        public void setLeft(Node<E> leftChild){left = leftChild;}
        public void setRight(Node<E> rightChild){right = rightChild;}
    }

    // Create a new node storing provided element E
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // Instance variables for the LinkedBinaryTree class
    protected Node<E> root = null;
    private int size = 0;

    // Constructor
    public LinkedBinaryTree() {}

    // Validates that the provided positions exists, and returns the accompanying node
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type.");
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree.");
        return node;
    }

    // Returns size/number of nodes in a tree
    public int size() {
        return size;
    }

    // Returns the root of Position of the tree; null if the tree is empty
    public Position<E> root() {
        return root;
    }

    // Returns the position of the parent of the provided parent; null if the provided position is the root 
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    // Returns the position of the provided position's left child; null if the no child exisits
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    // Returns the position of the provided position's right child; null if the no child exisits
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    // Adds an element at the root of the new (empty) tree, returning its position
    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if(!isEmpty()) throw new IllegalArgumentException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    // Adds a child with element E to the left of the provided position and returns its position 
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    // Adds a child with element E to the right of the provided position and returns its position 
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    // Replaces the element at position p with element E, returning the new element
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    // Attaches two trees to the provided position, combining them in an easy way
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if(isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += (t1.size() + t2.size());
        if(!t1.isEmpty()) { // If its not empty, attach t1 as left subtree of a node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty()) { // If its not empty, attach t2 as right subtree of a node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    // Removes the node at positon p, replacing it with any avilable child
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if(numChildren(p) == 2) 
            throw new IllegalArgumentException("p has two children.");
        
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null)
            child.setParent(node.getParent()); // Setting a child's grandparent to its parent
        if(node == root)
            root = child; // Child becomes a root
        else {
            Node<E> parent = node.getParent();
            if(node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }

        size--;
        E temp = node.getElement();
        // Just some random required garbage cleanup
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }
    
    // This method prevents any added nodes from messing up the sorting of the tree or the structure 
    // of traditional binary tree, always adding it abiding to the natural tree rules. If the nodes
    // value is less than the provided value, then it'll traverse down the left part of the current
    // node. Otherwise, the value is gonna be added to the right part of the current node.
    public void innerAdder(E e, Position<E> p) {
        // Going down to the left, if the current element is less than the focussed node. If a left element doesn't exist,
        // then add it as the left element. If it does, then traverse down that part of the list.
        if (Integer.parseInt("" + e) < Integer.parseInt("" + p.getElement())) { // Need Integer.parseInt to prevent errors
            if (left(p) == null)
                addLeft(p, e);
            else
                innerAdder(e, left(p));
        }
        // Going down to the right, if the current element is greater than the focussed node. If a right element doesn't exist,
        // then add it as the right element. If it does, then traverse down that part of the list.
        else {
            if (right(p) == null)
                addRight(p, e);
            else
                innerAdder(e, right(p));
        }
    }
    
    public void add(E e) {
        if (isEmpty()) // Empty tree, means adding the element to the tree
            addRoot(e);
        else // If not, add it within
            innerAdder(e, root);
    }
    
    public boolean innerFinder(E e, Position<E> p) {
        if (isEmpty() || p == null) 
        // If reached end of tree, then return false (as in traversed  
        // through the whole method and didn't find anything
            return false;
        else {
            if (Integer.parseInt("" + e) < Integer.parseInt("" + p.getElement()))
            // If the element provided (the one looking for), is less than the current position's value; then traverse to the left part of the tree
                return innerFinder(e, left(p));
            else if (Integer.parseInt("" + e) > Integer.parseInt("" + p.getElement())) 
            // If the element provided (the one looking for), is greater than the current position's value; then traverse to the right part of the tree 
                return innerFinder(e, right(p));
            else // If the two elements aren't less than or greater than each other, they're equal - which means the element has been found
                return true;
        }
    }

    public boolean find(E e) { 
    // Buffer method used in the main class to call the inner finder method with the reference root position 
        if (isEmpty()) // Returning false if the tree is empty
            return false;
        return innerFinder(e, root); // Calling the innerFinder function with the provided element and using the root of the tree
    }   


    // Implementing two classes too avoid errors
    public Iterable<Position<E>> positions() {
        return null;
    }
    
    public Iterator<E> iterator() {
        return null;
    }
}