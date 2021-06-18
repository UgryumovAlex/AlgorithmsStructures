/**
 * 1. Создать программу, реализующую метод цепочек.
 *
 * */

public class homeWork {
    public static void main(String[] args) {
        HashTable<Product, Integer> hashTable = new HashTableImpl<>(10);

        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(67, "Carrot"), 220);
        hashTable.put(new Product(62, "Lemon"), 250);
        hashTable.put(new Product(52, "Tomato"), 120);
        hashTable.put(new Product(24, "Potato"), 67);
        hashTable.put(new Product(44, "Pineapple"), 228);

        hashTable.display();

        System.out.println("Стоимость морковки : " + hashTable.get(new Product(67, "Carrot")));
        System.out.println("Стоимость ананаса  : " + hashTable.get(new Product(44, "Pineapple")));

        Integer price = hashTable.remove(new Product(24, "Potato"));
        System.out.println("Удалили картошку стоимостью " + price);

        hashTable.display();
    }
}
