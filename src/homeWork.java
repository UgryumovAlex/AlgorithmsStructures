import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной в 6 уровней.
 *    Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. Число, которое попадает в узел,
 *    должно генерироваться случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 * */

public class homeWork {

    private static final int FOREST_SIZE = 20;

    public static void main(String[] args) {
        task();
    }

    private static int genInt(int low, int top) {
        Random r = new Random();
        return r.nextInt((top+1)-low) + low;
    }

    private static void task() {

        //Тестируем одиночное дерево, проверка работы генератора чисел, максимальной глубины дерева и операции добавления
        /*
        Tree<Integer> tree = new TreeImpl(4);
        for(int i=0; i < Math.pow(2,4)-1; i++) {
            int value = genInt(-25, 25);
            if (tree.add(value)) {
                System.out.println("Добавлено : " + value);
            } else {
                System.out.println("Отвергнуто : " + value);
            }
        }
        tree.display();
        */

        //Создаём 20 деревьев
        List<Tree<Integer>> forest = new ArrayList<>();
        for (int i=0; i < FOREST_SIZE; i++) {


            Tree<Integer> tree = new TreeImpl<>(6);
            TreeGrow(tree, -100, 100);

/*
            Tree<Integer> tree = new TreeImpl<>(4);
            TreeGrow(tree, -25, 25);
*/
            forest.add(tree);
        }

        int balanced = 0;
        for ( Tree<Integer> tree : forest ) {
            if (tree.isBalanced()) { balanced++;}
            tree.display();
        }

        System.out.println("Всего создано деревьев : " + forest.size() + "; Из них сбалансированных " + balanced);

        /*
        * Для глубины 6 с пятого прогона получилось!

* Высота : 6; Сбалансировано :true
                                                                4
                                -24                                                              25
                -81                              -8                              10                              64
        -89              -33              -18              3              5              12              60              82
    -97      -83      -54      -28      --      -16      --      --      --      8      --      --      48      63      65      85
  --  --  --  --  -73  -37  -29  -27  --  --  --  --  --  --  --  --  --  --  --  --  --  --  --  --  26  50  --  --  --  66  --  96

        * */
    }

    private static void TreeGrow(Tree<Integer> tree, int lowBound, int topBound) {
        for(int i=0; i < Math.pow(2,tree.getMaxDepth())-1; i++) {
            tree.add(genInt(lowBound, topBound));
        }
    }


}
