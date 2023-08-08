import java.util.ArrayList;
import java.util.LinkedList;

public class GraphDemo {

    static void addAEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);

    }

    static void printAGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + "-" + adj.get(i));
        }
    }

    static void dfsRecution(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int i : adj.get(source)) {
            if (visited[i] == false)
                dfsRecution(adj, i, visited);
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int vertices, int source) {
        boolean[] visited = new boolean[vertices + 1];
        dfsRecution(adj, source, visited);
    }

    static void bfsTraversal(ArrayList<ArrayList<Integer>> adj, int vertices, int source) {
        boolean visited[] = new boolean[vertices + 1];
        visited[source] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");
            int sizeOfList = adj.get(source).size();
            for (int i = 0; i < sizeOfList; i++) {
                int adjacentNode = adj.get(source).get(i);
                if (visited[adjacentNode] == false) {
                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }
    }

    static void shortestPath(ArrayList<ArrayList<Integer>> adj, int vertices, int source, int[] distance) {
        boolean[] visited = new boolean[vertices + 1];
        visited[source] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (visited[v] == false)
                    distance[v] = distance[u] + 1;
                visited[u] = true;
                queue.add(v);
            }
        }

    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= vertices; i++)
            adj.add(new ArrayList<>());
        addAEdge(adj, 1, 2);// Connecting 0 and 1
        addAEdge(adj, 1, 3);
        addAEdge(adj, 2, 5);
        addAEdge(adj, 2, 4);
        addAEdge(adj, 3, 5);
        addAEdge(adj, 4, 5);
        addAEdge(adj, 4, 6);
        addAEdge(adj, 5, 6);

        printAGraph(adj);
        bfsTraversal(adj, vertices, 1);
        dfs(adj, 1, vertices);
    }
}
