class Solution {
    List<List<Integer>> res;
    Set<Integer> set;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        set = new HashSet<>();
        Arrays.sort(nums);
        compute(nums, nums.length-1, new ArrayList<>());
        return res;
    }

    public void compute(int nums[], int i, List<Integer> curr) {
        if(i<0){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        compute(nums, i-1, curr);
        
        int j=i-1;
        while(j>=0&&nums[i]==nums[j])
            j--;
        curr.remove(curr.size()-1);
        compute(nums,j,curr);

    }
}
