class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        int i = 0, j = i + 1, k = len - 1;

        for (i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            j = i + 1;
            k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j - 1] == nums[j] && j < k) j++;

                } else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }

        return res;
    }
}
