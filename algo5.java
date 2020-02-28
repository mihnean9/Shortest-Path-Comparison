import java.util.*;

public final class algo5 implements algo {

    /**
     * Gasirea celui mai mic drum folosind Sortare Topologica. Dupa ce gasesc o
     * ordine sortata pt. noduri, calculez cel mai mic drum parcurgand lista ce
     * contine acea ordine.
     */
    public static ArrayList<Integer> shortestPath(final List<List<Edge>> graph, final int source) {

        int N = graph.size();
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);

        // List containing the topological order
        LinkedList<Integer> sortedList = new LinkedList<>();

        boolean visited[] = new boolean[N];
        visited[source] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        // Get a topological order for the nodes
        while (queue.size() != 0) {
            int u = queue.poll();
            sortedList.add(u);
            for (Edge edge : graph.get(u)) {
                int v = edge.getNode();
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        // Compute the shortest path
        for (Integer u : sortedList) {
            if (dist.get(u) != Integer.MAX_VALUE) {
                for (Edge edge : graph.get(u)) {
                    int v = edge.getNode();
                    int altCost = dist.get(u) + edge.getCost();
                    if (dist.get(v) > altCost) {
                        dist.set(v, altCost);
                    }
                }
            }
        }
        return dist;
    }

}
