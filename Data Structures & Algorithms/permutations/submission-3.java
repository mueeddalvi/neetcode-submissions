class Solution {
    List<List<Integer>> res;
    Set<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        res = new ArrayList<>();
        set= new HashSet<>();
        if (len < 0) {
            return res;
        }

        compute(nums, new ArrayList<>());
        return res;
    }

    public void compute(int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                curr.add(nums[i]);
                compute(nums,curr);
                set.remove(nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
