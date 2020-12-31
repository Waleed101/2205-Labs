public interface Queue<E> { // Queue interface to outline the functionality needed
    public int size();
    public boolean isEmpty();
    public void enqueue(E element);
    public E first();
    public E dequeue();
}