import java.util.LinkedList;
import java.util.List;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final List<Item<K, V>>[] data;
    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new List[initialCapacity];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    private List<Item<K,V>> getChain(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        return data[index];
    }

    private Item<K,V> getChainElem(List<Item<K,V>> chain, K key) {
        if (chain.size() == 0) { return null; }

        for ( Item<K, V> item : chain ) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        List<Item<K, V>> chainData = getChain(key);
        if (getChainElem(chainData, key) == null) {
            chainData.add(new Item<>(key, value));
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public V get(K key) {
        Item<K, V> item = getChainElem(getChain(key), key);
        if (item == null) {
            return null;
        } else {
            return item.getValue();
        }
    }

    @Override
    public V remove(K key) {
        List<Item<K, V>> chainData = getChain(key);
        Item<K, V> item = getChainElem(chainData, key);
        if (item != null) {
            V value = item.getValue();
            chainData.remove(item);
            size--;
            return value;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.print("{ ");
            if (data[i] != null) {
                for (Item<K, V> item : data[i]) {
                    System.out.print("[");
                    System.out.print(item);
                    System.out.print("]");
                }
            }
            System.out.print(" } \n");
        }
        System.out.println("----------");
    }
}