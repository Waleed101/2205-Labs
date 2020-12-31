public class PointComparator<E> implements Comparator<E> { // Point Comparator
    int xa, ya, xb, yb;

    public int compare(Point<Integer> a, Point<Integer> b) throws ClassCastException { 
        // Need set the passed over variables to Point<Integer> because the E wasn't working due to the Object not working 
        xa = a.getX();
        ya = a.getY();
        xb = b.getX();
        yb = b.getY();
        if (xa != xb)
            return (xa - xb);
        else
            return (ya - yb);
    }
}