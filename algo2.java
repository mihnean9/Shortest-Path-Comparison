import java.util.*;

public final class algo2 implements algo {

    /**
     * Dijkstra implementat folosit o coada de prioritati (bazata pe un heap de
     * prioritati). Am refolosit structura Edge pt. a insemna in acest caz un
     * nod si costul asociat. Coada va avea ca prioritate costul fiecarui nod.
     */
    public static ArrayList<Integer> shortestPath(final List<List<Edge>> graph, final int source) {

        int N = graph.size();

        // PQ of pairs<Node, Cost>; it compares them by cost
        Comparator<Edge> comparator = new distanceComparator();
        PriorityQueue<Edge> queue = new PriorityQueue<>(N, comparator);
        queue.add(new Edge(source, 0));

        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);

        boolean[] settled = new boolean[N];
        Arrays.fill(settled, false);

        while (!queue.isEmpty()) {
            int u = queue.poll().getNode();
            settled[u] = true;
            for (Edge edge : graph.get(u)) {
                int v = edge.getNode();
                int altCost = dist.get(u) + edge.getCost();
                if (!settled[v] && dist.get(v) > altCost) {
                    if (queue.contains(new Edge(v, dist.get(v)))) {
                        queue.remove(new Edge(v, dist.get(v)));
                    }
                    dist.set(v, altCost);
                    queue.add(new Edge(v, dist.get(v)));
                }
            }
        }
        return dist;
    }

    // Compare two edges by comparing the cost
    private static class distanceComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge a, Edge b) {
            if (a.getCost() > b.getCost())
                return 1;
            if (a.getCost() < b.getCost())
                return -1;
            return 0;
        }
    }
}