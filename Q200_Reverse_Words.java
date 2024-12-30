import java.util.Scanner;

class Q200_Reverse_Words {
    // Function to reverse words in a given string
    public String reverseWords(String s) {
        // Split the string into words, removing extra spaces
        String[] words = s.trim().split("\\s+");
        
        // Reverse the words array
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        
        Q200_Reverse_Words obj = new Q200_Reverse_Words();
        String result = obj.reverseWords(input);
        
        System.out.println("Reversed string: " + result);
        
        sc.close();
    }
}
