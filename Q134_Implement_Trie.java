import java.util.Scanner;
class Q134_Implement_Trie {

    // Node definition for Trie
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // For lowercase English letters
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Initialize your data structure here
    Q134_Implement_Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    // Returns if the word is in the trie
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }

    // Returns if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Q134_Implement_Trie trie = new Q134_Implement_Trie();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int operations = sc.nextInt();

        while (operations-- > 0) {
            System.out.println("Choose an operation: 1. Insert 2. Search 3. StartsWith");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the word to insert: ");
                    String wordToInsert = sc.nextLine();
                    trie.insert(wordToInsert);
                    System.out.println("Inserted: " + wordToInsert);
                    break;

                case 2:
                    System.out.print("Enter the word to search: ");
                    String wordToSearch = sc.nextLine();
                    boolean found = trie.search(wordToSearch);
                    System.out.println("Search result for '" + wordToSearch + "': " + found);
                    break;

                case 3:
                    System.out.print("Enter the prefix to check: ");
                    String prefix = sc.nextLine();
                    boolean hasPrefix = trie.startsWith(prefix);
                    System.out.println("StartsWith result for '" + prefix + "': " + hasPrefix);
                    break;

                default:
                    System.out.println("Invalid operation!");
            }
        }

        sc.close();
    }
}
