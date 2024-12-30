import java.util.*;

class Q198_Shop_In_Candy_Store {
    static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Sort candies array in ascending order
        Arrays.sort(candies);
        
        // Calculate minimum cost
        int minCost = 0;
        int candiesToBuy = N; // Start with all candies
        int i = 0;
        while (candiesToBuy > 0) {
            minCost += candies[i]; // Buy the cheapest candy
            candiesToBuy -= (K + 1); // Reduce the count by (1 + K)
            i++;
        }
        
        // Calculate maximum cost
        int maxCost = 0;
        candiesToBuy = N; // Start with all candies
        int j = N - 1;
        while (candiesToBuy > 0) {
            maxCost += candies[j]; // Buy the most expensive candy
            candiesToBuy -= (K + 1); // Reduce the count by (1 + K)
            j--;
        }
        
        result.add(minCost);
        result.add(maxCost);
        return result;
    }

    public static void main(String[] args) {
        int candies[] = {3, 2, 1, 4};
        int N = 4;
        int K = 2;
        ArrayList<Integer> result = candyStore(candies, N, K);
        System.out.println(result.get(0) + " " + result.get(1)); // Output: 3 7
    }
}
