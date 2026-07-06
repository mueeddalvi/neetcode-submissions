class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length=numbers.length;

        int l=0,r=length-1, currSum=0;
        int res [] = new int[2];

        while(l<r){
            currSum=numbers[l]+numbers[r];

            if(currSum < target){
                l++;
            }
            else if (currSum > target){
                r--;
            }
            else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{};
    }
}
