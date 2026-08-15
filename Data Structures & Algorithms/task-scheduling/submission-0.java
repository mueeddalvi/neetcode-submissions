class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int arr[] = new int[26];
        for (char c : tasks) {
            arr[c - 65]++;
        }

        for (int x : arr) {
            if (x > 0) {
                maxHeap.offer(x);
            }
        }
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int curr = maxHeap.poll() - 1;
                if (curr > 0)
                    q.add(new int[] {curr, time + n});
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.remove()[0]);
            }
        }

        return time;
    }
}
