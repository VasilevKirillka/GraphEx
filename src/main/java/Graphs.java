import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedPseudograph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Graphs {
    private final Graph<Integer, DefaultWeightedEdge> graph;

    public Graphs() {
        this.graph = new WeightedPseudograph<>(DefaultWeightedEdge.class);
    }

    public void addEdges(int vertex1, int vertex2) {
        graph.addEdge(addVertex(vertex1), addVertex(vertex2));
    }

    public void info(int vertex1, int vertex2) {
        DijkstraShortestPath<Integer, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
        String result;
        try {
            List<Integer> vertexList = dijkstraAlg.getPath(vertex1, vertex2).getVertexList();
            String joiner = vertexList.stream().map(String::valueOf).collect(Collectors.joining(" -> "));
            result = "Кратчайший путь между вершинами: " + joiner;
        } catch (Exception e) {
            result = "Пути между вершинами нет";
        }
        writeToLogFile(result);
    }

    private int addVertex(int vertex) {
        graph.addVertex(vertex);
        return vertex;
    }

    private void writeToLogFile(String result) {
        try (FileWriter fileWriter = new FileWriter("log.txt")) {
            fileWriter.write(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
