/**
 * 2. Написать методы удаления, добавления, поиска элемента массива.
  * */

public interface ArrayInterface<E> {

    void add(E value); //Добавление элемента
    boolean remove(E value); //Удаление элемента
    int indexOf(E value); //Поиск элемента

}
