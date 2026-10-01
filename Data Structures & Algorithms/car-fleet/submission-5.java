class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res=0;
        int len =position.length;

        Map<Integer, Integer> map= new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(position[i],speed[i]);
        }

        Arrays.sort(position);

        Stack<Double> stack = new Stack<Double>();

        for(int i=0;i<len;i++){
            double dist=target-position[i];
            double time=dist/map.get(position[i]);
            while(!stack.isEmpty() && stack.peek()<=time){
                stack.pop();
            }
            stack.push(time);
        }
        return stack.size();
        
    }
}
