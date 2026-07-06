class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList<>();
        int length = nums.length,result=-1;

        if(length==0)
            return 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < length; i++) {
            int num = nums[i],j=1;
            List<Integer> temp = new ArrayList<>();
            if (!set.contains(num - 1)) {
                while(set.contains(num+j)){
                    j++;
                }

                result=Math.max(result,j);
            }
        }

        return result;
    }
}
