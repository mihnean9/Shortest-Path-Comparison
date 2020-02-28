import java.util.*;

public final class algo4 implements algo {

    /**
     * Bellman-Ford cu o coada, implementata printr-o LinkedList (comportamentul
     * de coada evidentiat prin removeFirst()). Nu verifica existenta
     * ciclurilor negative.
     */
    public static ArrayList<Integer> shortestPath(final List<List<Edge>> graph, final int source) {

        int N = graph.size();
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);

        // Queue containing the nodes of interest
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int u = ((LinkedList<Integer>) queue).removeFirst();
            for (Edge edge : graph.get(u)) {
                int v = edge.getNode();
                int altCost = dist.get(u) + edge.getCost();
                if (dist.get(v) > altCost) {
                    dist.set(v, altCost);
                    if (!queue.contains(v)) {
                        if (!queue.isEmpty() &&
                                dist.get(v) < dist.get(((LinkedList<Integer>) queue).getFirst())) {
                            ((LinkedList<Integer>) queue).addFirst(v);
                        }
                        else {
                            queue.add(v);
                        }
                    }
                }
            }
        }
        return dist;
    }
}
