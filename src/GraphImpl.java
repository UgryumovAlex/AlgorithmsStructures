import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String another : others) {
            result &= addEdge(startLabel, another);
        }
        return result;
    }

    private boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            Vertex vertex = vertexList.get(i);
            if (vertex.getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
            vertex.setBefore(null);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex current) {
        int currentIndex = vertexList.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex, Vertex vertexPrev) {
        if (vertexPrev != null) {
            vertex.setBefore(vertexPrev); //запоминаем откуда пришли к текущей вершине
        }
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    @Override
    public List<Vertex> getShortestPath(String labelStart, String labelFinish) {
        List<Vertex> path = new LinkedList<>();  //Сохраняем путь в связном списке и возвращаем его как результат

        int startIndex = indexOf(labelStart);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + labelStart);
        }

        int finishIndex = indexOf(labelFinish);
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Invalid finish label: " + labelFinish);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        Vertex vertexFihish = null;

        visitVertex(queue, vertex, null);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                visitVertex(queue, vertex, queue.peek());

                if (vertex.getLabel().equals(labelFinish)) {
                    vertexFihish = vertex;  //Дошли до финальной точки, выходим из поиска
                    break;
                }

            } else {
                queue.remove();
            }
        }

        if (vertexFihish != null) { //если результат поиска успешный
            Stack<Vertex> stack = new Stack<>();
            stack.push(vertexFihish);
            vertex = vertexFihish;
            while (vertex.getBefore() != null) {
                vertex = vertex.getBefore();
                stack.push(vertex);
            }

            while (!stack.isEmpty()) {
                path.add(stack.pop());
            }
        }

        resetVertexState();

        return path;
    }
}