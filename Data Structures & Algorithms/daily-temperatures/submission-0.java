class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        if (n == 0)
            return res;
        if (n == 1) {
            res[0] = 0;
            return res;
        }

        Stack<int[]> s = new Stack<>(); //[temp, index]

        for (int i = 0; i < n; i++) {
            int tempRes[] = new int[2];
            int currTemp = temperatures[i];
            while (!s.isEmpty() && s.peek()[0] < currTemp) {
                res[s.peek()[1]] = i - s.peek()[1];
                s.pop();
            }
            s.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
