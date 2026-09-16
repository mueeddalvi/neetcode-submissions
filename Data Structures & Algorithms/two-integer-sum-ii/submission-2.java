class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];

        int len = numbers.length;

        int l = 0, r = len - 1;

        while (l < r) {
            int left = numbers[l], right = numbers[r];
            int sum = left + right;
            if (sum > target)
                r--;
            else if (sum < target)
                l++;
            else
                return new int[] {l + 1, r + 1};
        }

        return res;
    }
}
