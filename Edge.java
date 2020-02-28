// Un Pair<Integer, Integer>, cu anumite functionalitati modificate
public class Edge {
    private Integer node;
    private Integer cost;
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    public Integer getNode() {
        return node;
    }
    public Integer getCost() {
        return cost;
    }
    public String toString() {
        return "Edge: " + node + " " + cost;
    }

    // method added for algo2 (if the queue<edges> contains another edge with
    // same node, then it doesn't add another one)
    public boolean equals(Object o) {
        return ((Edge)o).node == this.node;
    }
}
