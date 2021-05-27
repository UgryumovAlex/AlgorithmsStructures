import java.util.Random;

/**
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 *
 * */

public class homeWork {
    private static int ARRAY_SIZE = 300000;

    public static void main(String[] args) {
/*
        MyArray<Integer> myArr = new MyArray<>();
        myArr.add(100000000);
        myArr.add(1);
        myArr.add(100000);
        myArr.add(10);
        myArr.add(10000);
        myArr.add(100);
        myArr.add(1000);
        myArr.add(10000000);
        myArr.add(10000);
        myArr.add(10000000);
        myArr.add(100000);
        myArr.add(1000000);
        myArr.display();
        System.out.println("position of 10000 : " + myArr.indexOf(10000));
        System.out.println("position of 1000000 : " + myArr.indexOf(1000000));

        if (myArr.remove(10000)) {
            myArr.display();
        } else {
            System.out.println("element has not been deleted");
        }

        //myArr.sortBubble();
        //myArr.sortSelect();
        myArr.sortInsert();
        myArr.display();
*/
        MyArray<Integer> myArr1 = new MyArray<>(ARRAY_SIZE);
        MyArray<Integer> myArr2 = new MyArray<>(ARRAY_SIZE);
        MyArray<Integer> myArr3 = new MyArray<>(ARRAY_SIZE);

        Random r = new Random();
        for (int i=0; i< ARRAY_SIZE; i++) {
            myArr1.add(r.nextInt(ARRAY_SIZE)+1);
            myArr2.add(r.nextInt(ARRAY_SIZE)+1);
            myArr3.add(r.nextInt(ARRAY_SIZE)+1);
        }

        long startTime;

        startTime = System.currentTimeMillis();
        myArr1.sortBubble();
        System.out.println("Время сортировки массива методом пузырька  : " + ((float)(System.currentTimeMillis() - startTime)/1000) + " сек.");

        startTime = System.currentTimeMillis();
        myArr2.sortSelect();
        System.out.println("Время сортировки массива методом выбора  : " + ((float)(System.currentTimeMillis() - startTime)/1000) + " сек.");

        startTime = System.currentTimeMillis();
        myArr3.sortInsert();
        System.out.println("Время сортировки массива методом вставки  : " + ((float)(System.currentTimeMillis() - startTime)/1000) + " сек.");
    }
}
