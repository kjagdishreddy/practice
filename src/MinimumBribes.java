import java.util.List;

public class MinimumBribes {

    public static void minimumBribes(List<Integer> q) {
        int totalBribes = 0;

        for (int i = 0; i < q.size(); i++) {
            int currentPosition = q.get(i);
            int originalPosition = i + 1;

            if (currentPosition - originalPosition > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count the number of bribes for each person
            // Check only the relevant part of the array for efficiency
            for (int j = Math.max(0, currentPosition - 2); j < i; j++) {
                if (q.get(j) > currentPosition) {
                    totalBribes++;
                }
            }
        }
        System.out.println(totalBribes);
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> q1 = List.of(2, 1, 5, 3, 4);
        List<Integer> q2 = List.of(2, 5, 1, 3, 4);

        System.out.print("Output for first queue: ");
        minimumBribes(q1);  // Output: 3

        System.out.print("Output for second queue: ");
        minimumBribes(q2);  // Output: Too chaotic
    }
}