import java.util.*;

class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        Arrays.fill(children, null);
        isEnd = false;
    }
}

public class Q136_Implement_A_Phone_Directory {

    private static void insertContact(String str, TrieNode root) {
        TrieNode itr = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (itr.children[ch - 'a'] == null) {
                itr.children[ch - 'a'] = new TrieNode();
            }
            itr = itr.children[ch - 'a'];
            if (i == str.length() - 1) {
                itr.isEnd = true;
            }
        }
    }

    private static void viewSuggestionsHelper(TrieNode curr, String prefix, ArrayList<String> temp) {
        if (curr.isEnd) {
            temp.add(prefix);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (curr.children[c - 'a'] != null) {
                viewSuggestionsHelper(curr.children[c - 'a'], prefix + c, temp);
            }
        }
    }

    private static ArrayList<ArrayList<String>> viewSuggestions(String queryStr, TrieNode root) {
        TrieNode prev = root;
        StringBuilder prefix = new StringBuilder();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int i = 0; i < queryStr.length(); i++) {
            char lastCharacter = queryStr.charAt(i);
            prefix.append(lastCharacter);

            TrieNode curr = prev.children[lastCharacter - 'a'];
            if (curr == null) {
                break;
            }

            ArrayList<String> temp = new ArrayList<>();
            viewSuggestionsHelper(curr, prefix.toString(), temp);
            result.add(temp);
            prev = curr;
        }

        return result;
    }

    private static void insertContactList(ArrayList<String> contactList, TrieNode root) {
        for (String contact : contactList) {
            insertContact(contact, root);
        }
    }

    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr) {
        TrieNode root = new TrieNode();
        insertContactList(contactList, root);
        return viewSuggestions(queryStr, root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("\nEnter the number of contacts: ");
            int n = sc.nextInt();
            sc.nextLine(); // Consume newline

            ArrayList<String> contactList = new ArrayList<>();
            System.out.println("Enter the contacts:");
            for (int i = 0; i < n; i++) {
                contactList.add(sc.nextLine().toLowerCase());
            }

            System.out.print("Enter the query string: ");
            String queryStr = sc.nextLine().toLowerCase();

            ArrayList<ArrayList<String>> result = phoneDirectory(contactList, queryStr);

            System.out.println("\nSuggestions for each prefix:");
            for (int i = 0; i < queryStr.length(); i++) {
                System.out.println("Prefix '" + queryStr.substring(0, i + 1) + "': " + result.get(i));
            }
        }

        sc.close();
    }
}
