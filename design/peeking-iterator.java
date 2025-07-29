// Java Iterator interface reference:

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
    }

    public Integer peek() {
        return nextElement;
    }

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

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}
