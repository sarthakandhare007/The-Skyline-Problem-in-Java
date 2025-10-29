import java.util.*;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        // Step 1: Build event list
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // building starts
            events.add(new int[]{b[1], b[2]});  // building ends
        }

        // Step 2: Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Step 3: Max Heap for active buildings
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prevHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        // Step 4: Process events
        for (int[] e : events) {
            int x = e[0], h = e[1];

            if (h < 0) pq.add(-h);   // start of building
            else pq.remove(h);       // end of building

            int currHeight = pq.peek();

            if (currHeight != prevHeight) {
                result.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SkylineProblem solver = new SkylineProblem();
        int[][] buildings = {
            {2,9,10},
            {3,7,15},
            {5,12,12},
            {15,20,10},
            {19,24,8}
        };

        List<List<Integer>> skyline = solver.getSkyline(buildings);
        System.out.println("Skyline: " + skyline);
    }
}
