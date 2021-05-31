
import java.util.Scanner;

/**
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека.
 * */

public class homeWork {
    public static void main(String[] args) {

        System.out.println("Test stack");
        testStack();
        System.out.println("");

        System.out.println("Test queue");
        testQueue();
        System.out.println("");

        System.out.println("Test priorityQueue");
        testPriorityQueue();
        System.out.println("");

        System.out.println("Задание №2, переворачиваем строку ");
        task2();
        System.out.println("");

        System.out.println("Test Deque");
        testDeque();

    }

    private static void testStack() {
        Stack<Character> stack = new StackImpl<>(5);
        System.out.println("Add value 1: " + addToStack(stack, 'A'));
        System.out.println("Add value 2: " + addToStack(stack, 'B'));
        System.out.println("Add value 3: " + addToStack(stack, 'C'));
        System.out.println("Add value 4: " + addToStack(stack, 'D'));
        System.out.println("Add value 5: " + addToStack(stack, 'E'));
        System.out.println("Add value 6: " + addToStack(stack, 'F'));

        System.out.println("Содержимое : " + stack);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack peek: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Содержимое : " + stack);
    }

    private static boolean addToStack(Stack<Character> stack, Character value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }

        return false;
    }

    private static void testQueue() {
        Queue<Character> queue = new QueueImpl<>(5);

        /*
        * Переопределил метод ToString() для QueueImpl. Отображается состояние внутреннего массива, а так же
        * значения вспомогательных переменных.
        * Визуально видно, как "двигаются" данные внутри очереди по мере выполнения различных операций
        * */

        System.out.print("insert A : ");
        queue.insert('A');
        System.out.println(queue);

        System.out.print("insert B : ");
        queue.insert('B');
        System.out.println(queue);

        System.out.print("insert C : ");
        queue.insert('C');
        System.out.println(queue);

        System.out.print("insert D : ");
        queue.insert('D');
        System.out.println(queue);

        System.out.print("insert E : ");
        queue.insert('E');
        System.out.println(queue);

        System.out.print("remove : ");
        queue.remove();
        System.out.println(queue);

        System.out.print("insert F : ");
        queue.insert('F');
        System.out.println(queue);

        System.out.print("remove : ");
        queue.remove();
        System.out.println(queue);

        System.out.print("remove : ");
        queue.remove();
        System.out.println(queue);

        System.out.print("insert G : ");
        queue.insert('G');
        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.print("remove : ");
            queue.remove();
            System.out.println(queue);
        }
        System.out.print("insert A : ");
        queue.insert('A');
        System.out.println(queue);

        System.out.print("insert B : ");
        queue.insert('B');
        System.out.println(queue);

        System.out.print("insert C : ");
        queue.insert('C');
        System.out.println(queue);

        System.out.print("insert D : ");
        queue.insert('D');
        System.out.println(queue);

        System.out.print("insert E : ");
        queue.insert('E');
        System.out.println(queue);
    }

    private static void testPriorityQueue() {
        Queue<Character> pqueue = new PriorityQueue<>(5);

        System.out.print("insert D : ");
        pqueue.insert('D');
        System.out.println(pqueue);

        System.out.print("insert A : ");
        pqueue.insert('A');
        System.out.println(pqueue);

        System.out.print("insert C : ");
        pqueue.insert('C');
        System.out.println(pqueue);

        System.out.print("insert E : ");
        pqueue.insert('E');
        System.out.println(pqueue);

        System.out.print("insert B : ");
        pqueue.insert('B');
        System.out.println(pqueue);

        while (!pqueue.isEmpty()) {
            System.out.print("remove ");
            System.out.print(pqueue.remove() + " : ");
            System.out.println(pqueue);
        }

        System.out.print("insert F : ");
        pqueue.insert('F');
        System.out.println(pqueue);

        System.out.print("insert G : ");
        pqueue.insert('G');
        System.out.println(pqueue);

        System.out.print("insert H : ");
        pqueue.insert('H');
        System.out.println(pqueue);

        System.out.print("remove ");
        System.out.print(pqueue.remove() + " : ");
        System.out.println(pqueue);

        System.out.print("remove ");
        System.out.print(pqueue.remove() + " : ");
        System.out.println(pqueue);
    }

    /**
     * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
     * */
    private static void task2() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите строку : ");
            String s = in.nextLine();

            System.out.println("Введена строка  : " + s);
            System.out.println("Строка наоборот (Stack) : " + reverse(s));
            System.out.println("Строка наоборот (Deque) : " + reverseDeque(s));
        }
    }

    private static String reverseDeque(String s) {
        if (s.length() == 0) {
            return "";
        }

        Deque<Character> deque = new DequeImpl<>(s.length());
        for(int i=0; i < s.length(); i++) {
            deque.insertRight(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeRight());
        }

        return sb.toString();

    }
    private static String reverse(String s) {
        if (s.length() == 0) {
            return "";
        }

        Stack<Character> stack = new StackImpl<>(s.length());

        for(int i=0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    private static void testDeque() {
        Deque<Character> deque = new DequeImpl<>(5);

        System.out.print("insertLeft A = " + deque.insertLeft('A') + " : ");
        System.out.println(deque);

        System.out.print("insertLeft B = " + deque.insertLeft('B') + " : ");
        System.out.println(deque);

        System.out.print("insertRight C = " + deque.insertRight('C') + " : ");
        System.out.println(deque);

        System.out.print("insertLeft D = " + deque.insertLeft('D') + " : ");
        System.out.println(deque);

        System.out.print("insertRight E = " + deque.insertRight('E') + " : ");
        System.out.println(deque);

        System.out.print("removeLeft " + deque.removeLeft() + " : ");
        System.out.println(deque);

        System.out.print("removeRight " + deque.removeRight() + " : ");
        System.out.println(deque);

    }
}
