class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> q=new PriorityQueue<>(
            k, Collections.reverseOrder()
        );

        for(int n:nums){
            q.offer(n);
        }

        int res=0;
        while(k>0){
            res=q.poll();
            k--;
        }

        return res;

        
    }
}
