/*******************************************************************************
 *
 *  This is a template file for RingBuffer.java. It lists the constructors
 *  and methods you need to implement, along with descriptions of what they're
 *  supposed to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    private double[] rb;
    private int first;
    private int last;
    private int size;

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        rb = new double[capacity];
        first = (int) rb[0];
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return rb.length;
    }

    // return number of items currently in this ring buffer
    public int size() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (rb[i] != 0) {
                count = count + 1;
            }
        }
        return count;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        if (size == capacity()) {
            return true;
        }
        else {
            return false;
        }

    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        rb[size] = x;
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {

        /*if (isEmpty()) {
            RuntimeException;
            break;
        }*/

        double copy = first;
        rb[0] = 0;
        return copy;
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        return first;
    }

    // tests and calls every instance method in this class
    public static void main(String[] args) {

        StdOut.println("Hello");

        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);
        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
            StdOut.println(buffer.size());
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());

    }

}
