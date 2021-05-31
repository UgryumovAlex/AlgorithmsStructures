public class DequeImpl<E> extends QueueImpl<E> implements Deque<E>  {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {

        if (isFull()) {  return false;  }

        if (head == 0) {  head = data.length;  }

        head--;

        if (isEmpty()) {  tail = head;  }

        data[head] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {

        if (isEmpty()) {
            return null;
        }

        E value = peekLast();
        data[tail--] = null;
        size--;

        return value;
    }

    @Override
    public E peekLast() {
        return data[tail];
    }
}
