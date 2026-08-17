class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int len = nums.length;
        Set<Integer> set = new HashSet<>();

        compute(nums, nums.length, new ArrayList<>(), new HashSet<>());

        return res;
    }

    public void compute(int nums[], int len, List<Integer> curr, Set<Integer> set) {
        if (curr.size() == len) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                curr.add(nums[i]);
                set.add(nums[i]);
                compute(nums, len, curr, set);
                curr.remove(curr.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
