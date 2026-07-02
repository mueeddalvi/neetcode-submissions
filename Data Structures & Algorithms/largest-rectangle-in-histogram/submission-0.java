class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left = nsl(heights);
        right = nsr(heights);
        int res = -1;
        for (int i = 0; i < n; i++) {
            System.out.print(left[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(right[i] + " ");
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }

    public int[] nsl(int[] heights) {
        int res[] = new int[heights.length];
        int n = heights.length;

        // value - index
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek()[1];
            stack.push(new int[] {heights[i], i});
        }

        return res;
    }

    public int[] nsr(int[] heights) {
        int res[] = new int[heights.length];
        int n = heights.length;

        // value - index
        Stack<int[]> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? n : stack.peek()[1];
            stack.push(new int[] {heights[i], i});
        }

        return res;
    }
}
