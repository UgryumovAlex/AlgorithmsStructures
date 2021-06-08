import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int capacity;
    List<StorageItem> storage;
    List<StorageItem> storageBuffer;
    StorageItem[] itemsToPut;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Backpack{").append("capacity:" + capacity).append("; items weight:" + getItemsWeight(storage))
                .append("; items cost:" + getItemsCost(storage)).append("; storage("+ storage.size() + ") :" + storage);
        sb.append("}");

        return sb.toString();
    }

    public Backpack(int capacity) {
        this.storage = new ArrayList<>();
        this.storageBuffer = new ArrayList<>();

        this.capacity = capacity;
    }

    private boolean addItem(StorageItem item) {
        if ((capacity - getItemsWeight(storageBuffer)) >= item.getWeight() ) {
            storageBuffer.add(item);
            return true;
        } else {
            return false;
        }
    }

    private int getItemsWeight(List<StorageItem> items) {
        if (items.size() == 0) {
            return 0;
        } else {
            int itemsWeight = 0;
            for ( StorageItem item : items ) {
                itemsWeight += item.getWeight();
            }
            return itemsWeight;
        }
    }

    private int getItemsCost(List<StorageItem> items) {
        if (items.size() == 0) {
            return 0;
        } else {
            int itemsCost = 0;
            for ( StorageItem item : items ) {
                itemsCost += item.getCost();
            }
            return itemsCost;
        }
    }

    public void backpackFill(StorageItem[] items) {
        this.itemsToPut = items;
        fill(itemsToPut.length);
    }

    private void fill(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            fill(length - 1);

            //System.out.println(Arrays.toString(itemsToPut));
            storageBuffer.clear();
            for (StorageItem item : itemsToPut) { //Заполняем буфер пока входит
                if (!addItem(item)) { break;}
            }

            if (getItemsCost(storageBuffer) > getItemsCost(storage)) { //Если стоимость объектов в буфере больше текущей в рюкзаке
                storage.clear();
                storage.addAll(storageBuffer);
                System.out.println("Изменено содержимое рюкзака : " + this);
            }
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = itemsToPut.length - length;
        StorageItem temp = itemsToPut[pos];

        for (int i = pos + 1; i < itemsToPut.length; i++) {
            itemsToPut[i - 1] = itemsToPut[i];
        }

        itemsToPut[itemsToPut.length - 1] = temp;
    }
}
