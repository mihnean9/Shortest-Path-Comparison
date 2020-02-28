import java.util.*;

public final class algo1 implements algo {

    /**
     * Dijkstra implementat folosind o lista pt. a retine nodurile nevizitate
     * (nodurile la care nu am gasit inca sigur cel mai scurt drum de la sursa).
     */
    public static ArrayList<Integer> shortestPath
            (final List<List<Edge>> graph, final int source) {

        int N = graph.size();
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);

        // list of nodes for which the distance is not final
        List<Integer> notSettled = new LinkedList<>();
        notSettled.add(source);

        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        while (!notSettled.isEmpty()) {
            int u = getLowestDistance(notSettled, dist);
            notSettled.remove((Integer) u); //remove the object
            for (Edge edge : graph.get(u)) {
                int v = edge.getNode();
                int altCost = dist.get(u) + edge.getCost();
                if (!visited[v] && dist.get(v) > altCost) {
                    dist.set(v, altCost);
                    if (!notSettled.contains(v)) {
                        notSettled.add(v);
                    }
                }
            }
            visited[u] = true;
        }
        return dist;

    }

    /**
     * Return the node (from the list) with the lowest distance from the source.
     */
    private static int getLowestDistance(List<Integer> notSettled, LinkedList<Integer> dist) {
        int v = 0;
        int lowestDistance = Integer.MAX_VALUE;
        for (Integer node : notSettled) {
            if (lowestDistance > dist.get(node)) {
                lowestDistance = dist.get(node);
                v = node;
            }
        }
        return v;
    }
}
