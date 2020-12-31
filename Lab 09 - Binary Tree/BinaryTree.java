// Interface for a binary tree, in which each node has at most two children
public interface BinaryTree<E> extends Tree<E> {
    // Function to return the position of p's left child (or null if no child exists)
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    // Function to return the position of p's right child (or null if no child exists)
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    // Function to return the position of p's sibling (or null if no sibling)
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}