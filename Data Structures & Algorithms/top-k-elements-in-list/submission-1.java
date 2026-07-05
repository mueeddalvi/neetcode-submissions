class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];

        int length = nums.length;

        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Queue<int[]> q = new PriorityQueue<>(k, (a, b) -> b[0] - a[0]); 

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            q.offer(new int[]{it.getValue(), it.getKey()});
        }
        
        int i=0;
        while(!q.isEmpty() && i<k){
            res[i]=q.poll()[1];
            i++;
        }

        return res;
    }
}
