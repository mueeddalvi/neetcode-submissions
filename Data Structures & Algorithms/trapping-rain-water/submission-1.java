class Solution {
    public int trap(int[] height) {
        int res=0;
        int lmax=0,rmax=0, l=0,r=height.length-1;

        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax){
                res+=lmax-height[l];
                l++;
            }
            else{
                res+=rmax-height[r];
                r--;
            }
        }
        return res;
        
    }
}
