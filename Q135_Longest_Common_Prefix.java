import java.util.*;

public class Q135_Longest_Common_Prefix {

    // Trie Node definition
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count; // Count of words that pass through this node

        public TrieNode() {
            Arrays.fill(children, null);
            count = 0;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++;
            }
        }

        // Find the Longest Common Prefix in the Trie
        public String findLCP(int totalWords) {
            StringBuilder lcp = new StringBuilder();
            TrieNode node = root;

            while (true) {
                int childCount = 0;
                int nextIndex = -1;

                // Check the children nodes
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        childCount++;
                        nextIndex = i;
                    }
                }

                // If more than one child or count mismatches, stop
                if (childCount != 1 || node.children[nextIndex].count != totalWords) {
                    break;
                }

                // Append the character and move to the next child
                lcp.append((char) (nextIndex + 'a'));
                node = node.children[nextIndex];
            }

            return lcp.toString();
        }
    }

    public static String longestCommonPrefix(String[] arr, int n) {
        if (n == 0) return "";

        Trie trie = new Trie();

        // Insert all words into the Trie
        for (String word : arr) {
            trie.insert(word);
        }

        // Find and return the LCP
        return trie.findLCP(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            System.out.print("Enter the number of strings: ");
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline

            String[] arr = new String[n];
            System.out.println("Enter the strings:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
            }

            String result = longestCommonPrefix(arr, n);
            System.out.println("Longest Common Prefix: " + (result.isEmpty() ? "No common prefix" : result));
        }

        sc.close();
    }
}
