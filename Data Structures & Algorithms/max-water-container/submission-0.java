class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int res = Integer.MIN_VALUE;
        ;
        int i = 0, j = n - 1;

        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(heights[i], heights[j]));
            if (heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return res;

    }
}
