import java.util.Arrays;

public class MyArray<E extends Comparable<? super E>> implements ArrayInterface<E> {

    private static final int DEFAULT_CAPACITY = 8;

    protected E[] data;
    protected int size;

    @SuppressWarnings("unchecked")
    public MyArray(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public MyArray() {
        this(DEFAULT_CAPACITY);
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errorMsg = String.format("Incorrect 'index': %d; max value is %d",
                    index, size - 1);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }

    private E remove(int index) {
        checkIndex(index);

        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);

        data[--size] = null;
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.println(Arrays.toString(data));
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }
}
