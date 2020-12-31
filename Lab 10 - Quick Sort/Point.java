class Point<E> { // Class to create a point type
    E x, y; // Holding the value of X and Y
    public Point(E x, E y) { // Point constructor
        this.x = x;
        this.y = y;
    }
    public E getX() {return x;} // Function to get the x value
    public E getY() {return y;} // Function to get the y value
}