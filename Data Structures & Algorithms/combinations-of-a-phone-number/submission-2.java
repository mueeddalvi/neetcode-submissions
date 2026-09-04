class Solution {
    Map<Integer, String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        int len = digits.length();
        if (len == 0)
            return res;
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        compute(digits, 0, "");
        return res;
    }

    public void compute(String digits, int start, String curr) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        String letters = map.get(digits.charAt(start) - '0'); // def //ghi
        for (int i = 0; i < letters.length(); i++) {
            curr=curr+letters.charAt(i);
            compute(digits,start+1,curr);
            curr=curr.substring(0,curr.length()-1);
        }
    }
}
