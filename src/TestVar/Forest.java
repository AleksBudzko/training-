package TestVar;

import java.util.Scanner;

public class Forest {

    private static char[][] forest;
    private static int n;
    private static int maxMushrooms;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();

        forest = new char[n][3];
        for (int i = 0; i < n; i++) {
            forest[i] = scanner.nextLine().toCharArray();
        }

        maxMushrooms = 0;
        for (int j = 0; j < 3; j++) {
            if (forest[0][j] != 'W') {
                dfs(0, j, forest[0][j] == 'C' ? 1 : 0);
            }
        }

        System.out.println(maxMushrooms);
        scanner.close();
    }

    private static void dfs(int row, int col, int currentMushrooms) {
        if (row == n - 1) {
            maxMushrooms = Math.max(maxMushrooms, currentMushrooms);
            return;
        }

        boolean nextRowBlocked = true;
        for (int nextCol = 0; nextCol < 3; nextCol++) {
            if (forest[row + 1][nextCol] != 'W') {
                nextRowBlocked = false;
                break;
            }
        }

        if (!nextRowBlocked) {
            for (int nextCol = Math.max(0, col - 1); nextCol < Math.min(3, col + 2); nextCol++) {
                if (forest[row + 1][nextCol] != 'W') {
                    dfs(row + 1, nextCol, currentMushrooms + (forest[row + 1][nextCol] == 'C' ? 1 : 0));
                }
            }
        } else {
            if (row + 2 < n) { // Check if skipping a row is possible
                for (int nextCol = Math.max(0, col - 2); nextCol < Math.min(3, col + 3); nextCol++) {
                    if (forest[row + 2][nextCol] != 'W') {
                        dfs(row + 2, nextCol, currentMushrooms + (forest[row + 2][nextCol] == 'C' ? 1 : 0));
                    }
                }
            }
        }
    }
}