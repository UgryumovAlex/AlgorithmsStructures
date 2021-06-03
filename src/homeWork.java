/**
 * 1. Реализовать все классы, рассмотренные в данном уроке.
 * 2. В методе main LinkIteratorApp проверить все методы итератора.
 * 3. Реализовать цикл forEach для простого связанного списка
 * 4*. Реализовать Deque на основе двунаправленного списка
 *
 * */

public class homeWork {
    public static void main(String[] args) {

        System.out.println("testLinkedListSimple ---------------------");
        testLinkedListSimple();
        System.out.println("");

        System.out.println("testLinkedListTwoSide ---------------------");
        testLinkedListTwoSide();
        System.out.println("");

        System.out.println("test Iterator ---------------------");
        testForEach();
    }

    private static void testLinkedListTwoSide() {
        TwoSideLinkedList<Character> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst('A');
        linkedList.insertLast('B');
        linkedList.insertFirst('C');
        linkedList.insertLast('D');
        linkedList.insertFirst('E');
        linkedList.insertLast('F');

        linkedList.display();

        System.out.println("Find B: " + linkedList.contains('B'));
        System.out.println("Find A: " + linkedList.contains('A'));
        System.out.println("Find C: " + linkedList.contains('C'));
        System.out.println("Find X: " + linkedList.contains('X'));

        linkedList.removeFirst();
        linkedList.remove('D');

        linkedList.display();

    }

    private static void testLinkedListSimple() {
        LinkedList<Character> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst('A');
        linkedList.insertFirst('B');
        linkedList.insertFirst('C');
        linkedList.insertFirst('D');

        linkedList.display();

        System.out.println("Find B: " + linkedList.contains('B'));
        System.out.println("Find A: " + linkedList.contains('A'));
        System.out.println("Find C: " + linkedList.contains('C'));
        System.out.println("Find X: " + linkedList.contains('X'));

        linkedList.removeFirst();
        linkedList.remove('C');

        linkedList.display();
    }

    private static void testForEach() {
        LinkedList<Character> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst('A');
        linkedList.insertFirst('B');
        linkedList.insertFirst('C');
        linkedList.insertFirst('D');
        linkedList.insertFirst('E');
        linkedList.insertFirst('F');
        linkedList.insertFirst('G');
        linkedList.insertFirst('H');

        linkedList.display();

        for (Character character : linkedList) {
            System.out.println(character);
        }
    }

}
