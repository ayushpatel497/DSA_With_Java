import java.util.Scanner;

class Q22_Reverse_Words_In_A_String {

    // Function to reverse words in a string
    public String reverseWords(String s) {
        // To store the final result
        StringBuilder str = new StringBuilder();
        // To store each word temporarily
        StringBuilder temp = new StringBuilder();

        // Traverse the string from the end
        for (int i = s.length() - 1; i >= 0; i--) {
            // If we encounter a space and there's a word in temp, append it to str
            if (s.charAt(i) == ' ') {
                if (temp.length() > 0) {
                    // Append the word in temp to the final result and add a space
                    if (str.length() > 0) {
                        str.append(' ');
                    }
                    str.append(temp.reverse());
                    temp.setLength(0); // Clear the temp StringBuilder for the next word
                }
            } else {
                // Append characters to temp to build the current word
                temp.append(s.charAt(i));
            }
        }

        // Handle the last word (which won't be followed by a space)
        if (temp.length() > 0) {
            if (str.length() > 0) {
                str.append(' ');
            }
            str.append(temp.reverse());
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q22_Reverse_Words_In_A_String solver = new Q22_Reverse_Words_In_A_String();

        // Taking input for multiple test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character after reading the number

        // Processing each test case
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the string for test case " + (t + 1) + ": ");
            String inputString = sc.nextLine();
            String result = solver.reverseWords(inputString);
            System.out.println("Reversed words for test case " + (t + 1) + ": " + result);
        }
        sc.close();
    }
}
