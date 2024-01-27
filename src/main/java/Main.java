import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int vertex1, vertex2;

        Graphs graphs=new Graphs();

        graphs.addEdges(1, 2);
        graphs.addEdges(2, 1);
        graphs.addEdges(2, 3);
        graphs.addEdges(2, 4);
        graphs.addEdges(2, 6);
        graphs.addEdges(3, 2);
        graphs.addEdges(3, 4);
        graphs.addEdges(3, 5);
        graphs.addEdges(4, 2);
        graphs.addEdges(4, 3);
        graphs.addEdges(4, 5);
        graphs.addEdges(4, 6);
        graphs.addEdges(5, 3);
        graphs.addEdges(5, 4);
        graphs.addEdges(5, 6);

        System.out.println("Введите начальную вершину:");
        while (!scanner.hasNextInt()){
            scanner.next();
        }

        vertex1= scanner.nextInt();

        System.out.println("Введите конечную вершину:");
        while (!scanner.hasNextInt()){
            scanner.next();
        }

        vertex2= scanner.nextInt();

        graphs.info(vertex1,vertex2);
    }
}
