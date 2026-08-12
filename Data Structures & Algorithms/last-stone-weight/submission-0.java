class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n:stones){
            maxHeap.offer(n);
        }

        while(maxHeap.size()>=2){
            int x=maxHeap.poll();
            int y=maxHeap.poll();

            if(x==y)
                continue;
            else if(x<y){
                maxHeap.offer(y-x);
            }
            else{
                maxHeap.offer(x-y);
            }
        }

        return maxHeap.size()==1?maxHeap.peek():0;
        
    }
}
