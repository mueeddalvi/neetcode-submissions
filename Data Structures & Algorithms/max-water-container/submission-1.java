class Solution {
    public int maxArea(int[] heights) {
        int res=-1, len =heights.length;

        int l=0,r=len-1;

        while(l<r){
            res = Math.max(res, Math.min(heights[l],heights[r])*(r-l));
            if(heights[l]<heights[r])
                l++;
            else
                r--;
        }

        return res;
        
    }
}
