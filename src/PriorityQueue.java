import java.util.Arrays;

public class PriorityQueue<E extends Comparable<? super E>> implements Queue<E> {

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int maxSize) {
        this.data = (E[]) new Comparable[maxSize];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append("; size = ").append(size);

        return sb.toString();
    }

    // O(N)
    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        int index;
        for (index = size - 1; index >= 0; index--) {
            if (value.compareTo(data[index]) > 0) {
                data[index + 1] = data[index];
            } else {
                break;
            }
        }

        data[index + 1] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E value = data[size-1];
        data[size-1] = null;
        size--;

        return value;
    }

    @Override
    public E peekFront() {
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
