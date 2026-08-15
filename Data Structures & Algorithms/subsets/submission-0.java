class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        int len = nums.length;
        func(nums, len - 1, new ArrayList<>());
        return res;
    }

    public void func(int nums[], int i, List<Integer> curr) {
        if (i < 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        func(nums, i - 1, curr);
        curr.remove(curr.size() - 1);
        func(nums, i - 1, curr);
    }
}
