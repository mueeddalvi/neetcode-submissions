class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }
        int max = Integer.MIN_VALUE;
        for (int n : set) {
            int j, curr;
            j = curr = 0;
            if (!set.contains(n - 1)) {
                while (set.contains(n + j)) {
                    curr++;
                    max = Math.max(max, curr);
                    j++;
                }
            }
        }
        return max;
    }
}
