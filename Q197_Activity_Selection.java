import java.util.*;

class Q197_Activity_Selection {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        int n = start.size();
        
        // List to store activities as pairs (end, start)
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new int[]{end.get(i), start.get(i)});
        }

        // Sort activities by their end time
        activities.sort((a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int lastEndTime = -1;

        // Select activities
        for (int[] activity : activities) {
            if (activity[1] > lastEndTime) { // If the start time is after the last selected activity's end time
                count++;
                lastEndTime = activity[0]; // Update the lastEndTime
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Q197_Activity_Selection solution = new Q197_Activity_Selection();

        List<Integer> start = Arrays.asList(1, 3, 0, 5, 8, 5);
        List<Integer> end = Arrays.asList(2, 4, 6, 7, 9, 9);

        int result = solution.activitySelection(start, end);
        System.out.println(result); // Output: 4
    }
}
