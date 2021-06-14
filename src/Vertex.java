import java.util.Objects;

public class Vertex {

    private final String label;
    private boolean visited;
    private Vertex before;  //Ссылка на предыдущую вершину, от которой пришли к текущей при обходе

    public Vertex getBefore() {
        return before;
    }

    public void setBefore(Vertex before) {
        this.before = before;
    }

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}