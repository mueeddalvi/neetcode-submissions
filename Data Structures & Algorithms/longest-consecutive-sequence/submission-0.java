class Solution {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;

        Set<Integer> s = new HashSet<Integer>();

        for (int num : nums) {
            s.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!s.contains(num - 1)) {
                int l = 1;
                while (s.contains(num + l)) {
                    l++;
                }
                res = Math.max(l, res);
            }
        }
        return res;
    }
}
