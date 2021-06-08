/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 *
 * */

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

public class homeWork {
    public static void main(String[] args) {

        // AnagramTest();

        System.out.println("Возведение в степень рекурсией :");
        int num = 2;
        num = pow(num, 10);
        System.out.println(num);
        System.out.println("");

        System.out.println("Задача о заполнении рюкзака :");
        backpack_task();
    }

    private static void AnagramTest() {
        Anagram anagram = new Anagram();
        Set<String> anagrams = anagram.findAll("dima");
        System.out.println(anagrams);
    }

    /**
     *1. Написать программу по возведению числа в степень с помощью рекурсии.
     *
     * В рамках задачи предполагаем, что пользователь не будет задавать отрицательное значение
     * степени, а так же учитывать, что возвращаемый результат должен помещаться в тип int.
     * */
    private static int pow(int number, int degree) {
        if (degree == 0) {
            return 1;

        } else if (degree == 1) {
            return number;

        } else {
           return number * pow(number, --degree);

        }
    }

    /**2. Написать программу «Задача о рюкзаке» с помощью рекурсии.*/
    private static void backpack_task() {
        Backpack backpack = new Backpack(35); //Создали рюкзак на 35кг

        StorageItem[] items = new StorageItem[5]; //Генерируем 5 объектов
        String[] names = {"Книга", "Бинокль", "Аптечка", "Ноутбук", "Котелок"}; //Возьмём наименования объектов из задачи
        Random random = new Random();
        for(int i=0; i<items.length; i++ ) {  //Генерируем вес и стоимость случайным образом
            items[i] = new StorageItem(random.nextInt(20)+1, random.nextInt(10)+1, names[i]);
        }

        System.out.println("Массив предметов : " + Arrays.toString(items));
        System.out.println("------------------------------------------------------------------");
        backpack.backpackFill(items);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Итого в рюкзаке : " + backpack); //Смотрим состояние рюкзака
    }

}
