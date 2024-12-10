import java.util.*;

class Q175_Maximum_Height_By_Stacking_Cuboids {

    public int maxHeight(int[][] cuboids) {
        // Sort dimensions of each cuboid
        for (int[] el : cuboids) {
            if (el[0] > el[2]) {
                int temp = el[0];
                el[0] = el[2];
                el[2] = temp;
            }
            if (el[1] > el[2]) {
                int temp = el[1];
                el[1] = el[2];
                el[2] = temp;
            }
            if (el[0] > el[1]) {
                int temp = el[0];
                el[0] = el[1];
                el[1] = temp;
            }
        }

        // Sort cuboids globally based on dimensions
        Arrays.sort(cuboids, new Comparator<int[]>() {
            @Override
            public int compare(int[] b, int[] a) {
                if (a[2] != b[2]) {
                    return b[2] - a[2];
                }
                if (a[1] != b[1]) {
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            }
        });

        int n = cuboids.length;
        int[] dp = new int[n];
        int res = -1;

        // Calculate the maximum height using LIS-based DP
        for (int j = 0; j < n; j++) {
            dp[j] = cuboids[j][2];
            for (int i = 0; i < j; i++) {
                if (cuboids[i][1] <= cuboids[j][1] && cuboids[i][0] <= cuboids[j][0]) {
                    dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
                }
            }
            res = Math.max(res, dp[j]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of cuboids:");
        int n = scanner.nextInt();
        int[][] cuboids = new int[n][3];

        System.out.println("Enter the dimensions of each cuboid (width, length, height):");
        for (int i = 0; i < n; i++) {
            cuboids[i][0] = scanner.nextInt();
            cuboids[i][1] = scanner.nextInt();
            cuboids[i][2] = scanner.nextInt();
        }

        Q175_Maximum_Height_By_Stacking_Cuboids solver = new Q175_Maximum_Height_By_Stacking_Cuboids();
        int result = solver.maxHeight(cuboids);

        System.out.println("Maximum height by stacking cuboids: " + result);

        scanner.close();
    }
}
