import java.util.List;

/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин. Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 *
 * */

public class homeWork {
    public static void main(String[] args) {
        Graph roadMap = new GraphImpl(10);
        initRoadMap(roadMap);

        List<Vertex> path = roadMap.getShortestPath("Москва", "Воронеж");
        System.out.println("Едем Москва - Воронеж : ");
        for ( Vertex vertex: path) {
            System.out.println(vertex.getLabel());
        }
        System.out.println("");

        path = roadMap.getShortestPath("Орёл", "Рязань");
        System.out.println("Едем Орёл - Рязань : ");
        for ( Vertex vertex: path) {
            System.out.println(vertex.getLabel());
        }
        System.out.println("");

        path = roadMap.getShortestPath("Тамбов", "Липецк");
        System.out.println("Едем Тамбов - Липецк : ");
        for ( Vertex vertex: path) {
            System.out.println(vertex.getLabel());
        }
        System.out.println("");

        path = roadMap.getShortestPath("Москва", "Киров");
        System.out.println("Едем Москва - Киров : ");
        for ( Vertex vertex: path) {
            System.out.println(vertex.getLabel());
        }
        System.out.println("");

    }

    private static void initRoadMap(Graph roadMap) {
        roadMap.addVertex("Москва");
        roadMap.addVertex("Тула");
        roadMap.addVertex("Липецк");
        roadMap.addVertex("Воронеж");
        roadMap.addVertex("Рязань");
        roadMap.addVertex("Тамбов");
        roadMap.addVertex("Саратов");
        roadMap.addVertex("Калуга");
        roadMap.addVertex("Орёл");
        roadMap.addVertex("Курск");

        roadMap.addEdge("Москва", "Тула", "Рязань", "Калуга");
        roadMap.addEdge("Тула", "Липецк", "Москва");
        roadMap.addEdge("Липецк", "Воронеж", "Тула");
        roadMap.addEdge("Воронеж", "Липецк", "Саратов", "Курск");
        roadMap.addEdge("Рязань", "Тамбов", "Москва");
        roadMap.addEdge("Тамбов", "Саратов", "Рязань");
        roadMap.addEdge("Саратов", "Воронеж", "Тамбов");
        roadMap.addEdge("Калуга", "Орёл", "Москва");
        roadMap.addEdge("Орёл", "Курск", "Калуга");
        roadMap.addEdge("Курск", "Воронеж", "Орёл");

    }


}
