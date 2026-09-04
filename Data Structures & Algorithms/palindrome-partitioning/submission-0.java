class Solution {
    List<List<String>> res;
    Set<String> set;
    public List<List<String>> partition(String s) {
        int len=s.length();
        res=new ArrayList<>();
        set=new HashSet<>();
        compute(s,0, new ArrayList<>());
        return res;   
    }

    public void compute(String s, int start, List<String> curr){
        if(start==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<s.length();i++){
            String currString=s.substring(start,i+1);
            if(checkPalindrome(currString)){
                curr.add(currString);
                compute(s,i+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean checkPalindrome(String s){
        if(s.length()==1){
            return true;
        }
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
