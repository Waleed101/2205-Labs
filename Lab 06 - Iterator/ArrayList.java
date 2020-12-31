import java.util.NoSuchElementException; // Need to import to prevent not found error for no such element

public class ArrayList<E> implements List<E> { // ArrayList class impementing the List interface defined elsewhere
    public static final int CAPACITY = 16; // Setting default starting capacity
    private E[] data; // Intailizing the array
    private int size = 0;

    public ArrayList() {this(CAPACITY);} // No parameter constructor 
    public ArrayList(int capacity) { // Constructor with passed over values
        data = (E[]) new Object[capacity];
    }

    public int size() {return size;} // Returns size function (need to implement for interface)
    public boolean isEmpty() {return size==0;} // Returns if empty (need to implement from interface)
    public E get(int i) throws IndexOutOfBoundsException { // Function to get element at specific index
        checkIndex(i, size); // Checks to make sure not out of bounds
        return data[i]; // Return data otherwise
    }

    public E set(int i, E e) throws IndexOutOfBoundsException { // Function to set element at specific index
        checkIndex(i, size); // Check to make sure not out of bounds
        E temp = data[i]; // Get previous value in that spot
        data[i] = e; // Set new value
        return temp; // Return previous value
    }

    public void add(int i, E e) throws IndexOutOfBoundsException { // Function to add element 
        checkIndex(i, size+1); // Make sure value isn't out of bounds
        if(size == data.length) // Increase capacity of no space available
            increaseCapacity();
        for(int k = size-1; k >= i; k--) // Cycle through and move each element to make space for the new one
            data[k+1] = data[k]; 
        data[i] = e; // Insert new element 
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException { // Remove element at specific position
        checkIndex(i, size); // Check to make sure within bounds
        E temp = data[i]; // Get data to return
        for(int k=i; k < size-1; k++)  // Move each element back into the position
            data[k] = data[k+1];
        data[size - 1] = null;
        size--;
        return temp; // Return the element
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{ // Function to check if an index is within a certain bounds
        if(i > 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index at " + i);
    }

    private void increaseCapacity() // Function to increase capacity (doubles each time)
    {
        int newCapacity = data.length * 2; // Double capacity
        E[] newArr = (E[]) new Object[newCapacity]; // Create new array

        for(int i = 0; i < data.length; i++) // Set first half to the previous elements
            newArr[i] = data[i];

        data = newArr; // Set data array to the new array
    }

    private class ArrayIterator implements Iterator <E> { // Implementation of the iterator interface 
        private int j = 0; // Current position of iterator
        private boolean canRemove = false; 
    
        public boolean hasNext() {return j < size;} // Returns whether theres a new element
    
        public E next() throws NoSuchElementException { // Iterate to the next element
            if(j == size) // If its out of bounds, return no error
                throw new NoSuchElementException("No next element");
            canRemove = true; 
            return data[j++]; // Return element
        } 
    
        public void remove() throws IllegalStateException { // Remove the current element
            if(!canRemove) throw new IllegalStateException("No values left to remove"); // Can only remove when next has been previously called
            ArrayList.this.remove(j-1); // Remove element 
            j--; // Reduce current position
            canRemove = true;
        }
    }    
    
    public Iterator iterator() { // Allowing array iterator 
        return new ArrayIterator();
    }
}
