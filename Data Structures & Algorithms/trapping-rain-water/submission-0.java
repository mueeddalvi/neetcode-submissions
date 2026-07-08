class Solution {
    public int trap(int[] height) {
        int length = height.length;

        int maxL[] = new int[length];
        int maxR[] = new int[length];
        int water[] = new int[length];

        int sum=0;

        maxL[0] = height[0];

        for (int i = 1; i < length; i++) {
            maxL[i] = Math.max(height[i], maxL[i - 1]);
        }

        maxR[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i], maxR[i + 1]);
        }

        for(int i=0;i<length;i++){
            sum+=Math.min(maxR[i], maxL[i])-height[i];
        }

        return sum;
    }
}
