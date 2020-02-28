import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestGenerator {

    public static int[][] generateInput(int N, int M, int minCost, int maxCost, boolean cycles) {
        int[][] adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }

        // setting up a conex component
        for (int i = 0; i < N - 1; i++) {
            adjMatrix[i][i+1] = getRandomCost(minCost, maxCost);
        }
        M = M - (N - 1);

        if (!cycles) {  //DAG
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (adjMatrix[i][j] == Integer.MAX_VALUE) {
                        if (M == 0) break;
                        adjMatrix[i][j] = getRandomCost(minCost, maxCost);
                        M--;
                    }
                }
            }
            return adjMatrix;
        }

        while (M != 0) {
            Random rand = new Random();
            int v1 = rand.nextInt(N);
            while (!checkIfNodeAdmitsEdges(v1, adjMatrix)) {
                v1 = rand.nextInt(N);
            }
            int v2 = rand.nextInt(N);
            while (v1 == v2 || adjMatrix[v1][v2] != Integer.MAX_VALUE) {
                v2 = rand.nextInt(N);
            }
            adjMatrix[v1][v2] = getRandomCost(minCost, maxCost);
            M--;
        }
        return adjMatrix;
    }

    public static boolean checkIfNodeAdmitsEdges(int v1, int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v1][i] == Integer.MAX_VALUE && v1 != i) {
                return true;
            }
        }
        return false;
    }

    public static int getRandomCost(int minCost, int maxCost) {
        Random rand = new Random();
        if (minCost >= 0 || maxCost >= 0)
            return rand.nextInt(maxCost - minCost + 1) + minCost;
        else if (maxCost >= 0)
            return rand.nextInt(maxCost - minCost + 1) + minCost;
        else
            return -1 * getRandomCost(maxCost, minCost);
    }

    public static void writeInputToFile(int N, int M, int source,
                                        int[][] adjMatrix, String fileName) throws IOException  {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(N + " " + M + " " + source + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adjMatrix[i][j] != Integer.MAX_VALUE) {
                    writer.append(i + " " + j + " " + adjMatrix[i][j] + "\n");
                }
            }
        }
        writer.close();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        if (M < N - 1) {
            System.out.println("Too few edges to create a single conex component!");
            System.exit(1);
        }
        int minCost = in.nextInt();
        int maxCost = in.nextInt();
        boolean cycles = in.nextBoolean();

        try {
            writeInputToFile(100, 200, 0,
                    generateInput(100, 200, 1, 50, true), "test0.in");
            writeInputToFile(100, 8000, 0,
                    generateInput(100, 8000, 1, 50, true), "test1.in");
            writeInputToFile(10000, 50000, 0,
                    generateInput(10000, 50000, 1, 100, true), "test2.in");
            writeInputToFile(1000, 8000, 5,
                    generateInput(1000, 8000, 1, 100, true), "test3.in");
            writeInputToFile(1000, 2000, 0,
                    generateInput(1000, 2000, -500, 500, false), "test4.in");
            writeInputToFile(10, 20, 0,
                    generateInput(10, 20, -5, 5, true), "test5.in"); //ex didactic
            writeInputToFile(1000, 999, 0,
                    generateInput(1000, 999, 1, 100, false), "test6.in");
            writeInputToFile(1000, 2000, 0,
                    generateInput(1000, 2000, 1, 100, false), "test7.in");
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
