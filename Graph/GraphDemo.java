package Graph;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphDemo {
    public static void main(String[] args) {
        // set number of edges 5
        int n = 5;
        String[] vertex = {"A","B","C","D","E"};
        // define graph object
        Graph g = new Graph(n);
        // insert vertex into graph
        for (String v: vertex) {
            g.insertVertex(v);
        }
        // insert edges: A-B, A-C, B-C, B-D, B-E
        g.insertEdge(0,1,1);
        g.insertEdge(0,2,1);
        g.insertEdge(1,2,1);
        g.insertEdge(1,3,1);
        g.insertEdge(1,4,1);
        // show graph
        g.showGraph();
    }
}

// graph class
class Graph {
    ArrayList<String> vertexList;
    int[][] edges;
    int numEdges;

    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numEdges = 0;
    }
    // insert vertex
    public void insertVertex(String v) {
        vertexList.add(v);
    }
    // insert edge
    public void insertEdge(int v1, int v2, int w) {
        edges[v1][v2] = w;
        edges[v2][v1] = w;
        numEdges++;
    }
    // get number of vertex
    public int getNumOfVertex() {
        return vertexList.size();
    }
    // get number of edges
    public int getNumOfEdges() {
        return numEdges;
    }
    // get string value by index
    public String getValue(int i) {
        return vertexList.get(i);
    }
    // get weight of v1 and v2
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    // show graph
    public void showGraph() {
        for (int[] link: edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}

