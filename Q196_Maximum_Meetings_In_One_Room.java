import java.util.*;

class Q196_Maximum_Meetings_In_One_Room {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // List to store meetings as tuples (start, end, index)
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            meetings.add(new int[]{S[i], F[i], i + 1}); // Use 1-based index
        }

        // Sort by end time, and by index in case of tie
        meetings.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        ArrayList<Integer> result = new ArrayList<>();
        int lastEndTime = 0;

        // Select meetings greedily
        for (int[] meeting : meetings) {
            if (meeting[0] > lastEndTime) { // Start time > last selected meeting's end time
                result.add(meeting[2]); // Add index to result
                lastEndTime = meeting[1]; // Update lastEndTime
            }
        }

        // Sort the result list before returning
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] S = {12, 6, 16, 12, 6, 9, 16, 6, 17, 5};
        int[] F = {17, 13, 16, 18, 17, 10, 18, 12, 18, 11};

        ArrayList<Integer> result = maxMeetings(N, S, F);
        System.out.println(result); // Output: [2, 6, 8, 10]
    }
}
