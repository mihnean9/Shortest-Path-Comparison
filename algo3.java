import java.util.Collections;
import java.util.ArrayList;
import java.util.List;


public final class algo3 implements algo {

    /**
     * Bellman-Ford. N-1 iteratii prin toate muchiile pentru a gasi cel mai
     * scurt drum, iar apoi verific daca exista cicluri cu cost negativ (nu
     * exista drum cel mai scurt, deoarece s-ar putea trece prin ciclu la infinit,
     * costul scazand in continuare).
     * @param graph
     * @param source
     * @return
     */
    public static ArrayList<Integer> shortestPath(final List<List<Edge>> graph, final int source) {

        int N = graph.size();
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);

        // N-1 iterations through the entire set of edges
        for (int i = 1; i <= N - 1; i++) {
            for (int u = 0; u < N; u++) {
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
        }

        // Check if there are any negative cost cycles
        for (int u = 0; u < N; u++) {
            for (Edge edge : graph.get(u)) {
                int v = edge.getNode();
                int altCost = dist.get(u) + edge.getCost();
                if (dist.get(v) > altCost) {
                    return null;
                }
            }
        }

        return dist;
    }
}
