import java.util.Scanner;

class Q27_String_Compression {

    public int compress(char[] chars) {
        int index = 0;  // This is where we'll write the compressed characters
        int i = 0;  // This is the reading pointer

        // Iterate through the chars array
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count the occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[index++] = currentChar;

            // If count > 1, we need to write the count
            if (count > 1) {
                // Convert the count to a string and write each digit
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;  // The new length of the compressed array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        sc.nextLine();  // Consume newline character
        
        Q27_String_Compression compressor = new Q27_String_Compression();
        
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the string of characters for test case " + (t + 1) + ": ");
            String input = sc.nextLine();
            char[] chars = input.toCharArray();  // Convert input string to char array
            
            int newLength = compressor.compress(chars);
            
            System.out.print("Compressed version for test case " + (t + 1) + ": ");
            for (int i = 0; i < newLength; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
            System.out.println("New length: " + newLength);
        }

        sc.close();
    }
}