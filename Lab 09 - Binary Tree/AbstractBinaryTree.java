// Abstract base class providing some functionality of the BinaryTree interface
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    // Returns the position of p's sibling (or null if no sibling exists)
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if(parent == null) // If p's the root
            return null; // then return that
        
        if(p == left(parent)) // If p is a left child
            return right(parent); // Then right child might be null
        else // If p is a right child 
            return left(parent); // Then left child might be null
    }

    // Returns the number of children of position P
    public int numChildren(Position<E> p) {
        int count = 0;
        if(left(p) != null)
            count++;
        if(right(p) != null)
            count++;
        return count;
    }

    // Returns an iterable collection of the positions at p's children
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // Holds a maximum capacity of 2
        if(left(p) != null)
            snapshot.add(Integer.parseInt("" + left(p).getElement()), left(p));
        if(right(p) != null)
            snapshot.add(Integer.parseInt("" + right(p).getElement()), right(p));
        return (Iterable<Position<E>>)(snapshot);
    }

    // Prints off the tree by going through the inorder steps
    public void inOrder(Position<E> p) {
        if(p == null) // Exits if null
            return;
        inOrder(left(p)); // Parsing down the left part
        System.out.println("" + p.getElement()); // Printing off the elements value 
        inOrder(right(p)); // Parsing down the right part 
    }
}