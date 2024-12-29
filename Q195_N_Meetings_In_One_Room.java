import java.util.*;

class Q195_N_Meetings_In_One_Room {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        // Create an array of pairs (start, end) for sorting
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort by end time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        // Greedy selection of meetings
        int count = 0;
        int lastEndTime = -1;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] > lastEndTime) { // Select this meeting
                count++;
                lastEndTime = meetings[i][1]; // Update last end time
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Q195_N_Meetings_In_One_Room solution = new Q195_N_Meetings_In_One_Room();

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(solution.maxMeetings(start, end)); // Output: 4
    }
}
