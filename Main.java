import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static void printOutputToFile(final ArrayList<Integer> dist, final String fileName, final int source) {
        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(s + "/" + fileName));
            if (dist == null) {
                writer.write("Negative values cycle!");
                writer.close();
                return;
            }
            int N = dist.size();
            for (int i = 0; i < N; i++) {
                if (i != source) {
                    writer.append(dist.get(i).toString());
                    if (i != N - 1) {
                        writer.append(" ");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void interpretInput(final String fileName) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File file = new File(s + "/in/" + fileName);
        try {
            // Interpret Input
            Scanner in = new Scanner(file);
            if (!in.hasNextInt()) {
                System.out.println("The file is empty!");
                System.exit(2);
            }
            int N = in.nextInt();
            int M = in.nextInt();
            int source = in.nextInt();
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                int src = in.nextInt();
                int dest = in.nextInt();
                int cost = in.nextInt();
                graph.get(src).add(new Edge(dest, cost));
            }

            // Send input to be translated into output
            switch (fileName) {
                case "test0.in":
                    printOutputToFile(algo1.shortestPath(graph, source),
                            "other_outputs/test0_dijkstra.out", source);
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test0_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test0_bellman.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test0_bellmanQ.out", source);
                    printOutputToFile(algo5.shortestPath(graph, source),
                            "other_outputs/test0_dag.out", source);
                    break;
                case "test1.in":
                    printOutputToFile(algo1.shortestPath(graph, source),
                            "other_outputs/test1_dijkstra.out", source);
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test1_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test1_bellman.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test1_bellmanQ.out", source);
                    printOutputToFile(algo5.shortestPath(graph, source),
                            "other_outputs/test1_dag.out", source);
                    break;
                case "test2.in":
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test2_dijkstraPQ.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test2_bellmanQ.out", source);
                    break;
                case "test3.in":
                    printOutputToFile(algo1.shortestPath(graph, source),
                            "other_outputs/test3_dijkstra.out", source);
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test3_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test3_bellman.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test3_bellmanQ.out", source);
                    printOutputToFile(algo5.shortestPath(graph, source),
                            "other_outputs/test3_dag.out", source);
                    break;
                case "test4.in":
                    printOutputToFile(algo1.shortestPath(graph, source),
                            "other_outputs/test4_dijkstra.out", source);
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test4_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test4_bellman.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test4_bellmanQ.out", source);
                    printOutputToFile(algo5.shortestPath(graph, source),
                            "other_outputs/test4_dag.out", source);
                    break;
                case "test5.in":
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test5_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test5_bellman.out", source);
                    break;
                case "test6.in":
                    printOutputToFile(algo1.shortestPath(graph, source),
                            "other_outputs/test6_dijkstra.out", source);
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test6_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test6_bellman.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test6_bellmanQ.out", source);
                    printOutputToFile(algo5.shortestPath(graph, source),
                            "other_outputs/test6_dag.out", source);
                    break;
                case "test7.in":
                    printOutputToFile(algo1.shortestPath(graph, source),
                            "other_outputs/test7_dijkstra.out", source);
                    printOutputToFile(algo2.shortestPath(graph, source),
                            "other_outputs/test7_dijkstraPQ.out", source);
                    printOutputToFile(algo3.shortestPath(graph, source),
                            "other_outputs/test7_bellman.out", source);
                    printOutputToFile(algo4.shortestPath(graph, source),
                            "other_outputs/test7_bellmanQ.out", source);
                    printOutputToFile(algo5.shortestPath(graph, source),
                            "other_outputs/test7_dag.out", source);
                    break;
                default:
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        interpretInput("test0.in");
        interpretInput("test1.in");
        interpretInput("test2.in");
        interpretInput("test3.in");
        interpretInput("test4.in");
        interpretInput("test5.in");
        interpretInput("test6.in");
        interpretInput("test7.in");
    }
}
