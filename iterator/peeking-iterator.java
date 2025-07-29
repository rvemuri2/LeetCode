// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.*;

/**
 * PeekingIterator adds the ability to peek at the next element without advancing the iterator.
 */
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        // Preload the first element
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
    }

    /**
     * Returns the next element without advancing the iterator.
     */
    public Integer peek() {
        return nextElement;
    }

    /**
     * Returns the next element and advances the iterator.
     */
    @Override
    public Integer next() {
        Integer current = nextElement;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
        return current;
    }

    /**
     * Returns true if there are more elements.
     */
    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("Test 1:");
        PeekingIterator it1 = new PeekingIterator(Arrays.asList(1, 2, 3).iterator());
        System.out.println(it1.next());    // 1
        System.out.println(it1.peek());    // 2
        System.out.println(it1.next());
    }
}
