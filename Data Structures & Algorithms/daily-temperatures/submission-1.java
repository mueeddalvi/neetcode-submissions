class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;

        int []res=new int[len];
        Stack<int[]> stack=new Stack<>();

        for(int i=0;i<len;i++){
            int n=temperatures[i];
            while(!stack.isEmpty()){
                int []curr=stack.peek();
                if(curr[0]<n){
                    res[curr[1]]=i-curr[1];
                    stack.pop();
                }
                else{
                    break;
                }
            }
            stack.push(new int[]{n,i});
        }

        return res;
        
    }
}
