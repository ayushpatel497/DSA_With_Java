import java.util.*;

public class Q137_Rat_In_A_Maze {

    private static void solve(int[][] arr, int n, int x, int y, String path, boolean[][] visited, ArrayList<String> result) {
        // Base case: Destination reached
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        // Mark the cell as visited
        visited[x][y] = true;

        // Explore all possible directions
        // Direction vectors: 'D', 'L', 'R', 'U'
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] moves = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check boundaries and if the cell is not visited and is open
            if (newX >= 0 && newY >= 0 && newX < n && newY < n && arr[newX][newY] == 1 && !visited[newX][newY]) {
                solve(arr, n, newX, newY, path + moves[i], visited, result);
            }
        }

        // Backtrack and unmark the cell
        visited[x][y] = false;
    }

    public static ArrayList<String> findSum(int[][] arr, int n) {
        ArrayList<String> result = new ArrayList<>();

        // If the start or end cell is blocked, return empty result
        if (arr[0][0] == 0 || arr[n - 1][n - 1] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];
        solve(arr, n, 0, 0, "", visited, result);

        // Sort the result in lexicographical order
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("\nEnter the size of the maze (N): ");
            int n = sc.nextInt();

            int[][] arr = new int[n][n];
            System.out.println("Enter the maze matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            ArrayList<String> paths = findSum(arr, n);

            System.out.println("Possible paths:");
            if (paths.isEmpty()) {
                System.out.println("No path exists");
            } else {
                for (String path : paths) {
                    System.out.println(path);
                }
            }
        }

        sc.close();
    }
}
