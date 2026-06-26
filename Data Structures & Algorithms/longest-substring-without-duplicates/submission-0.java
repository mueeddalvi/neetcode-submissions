class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 1, length = s.length();
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        while (j < length) {
            char c = s.charAt(j);
            while (set.contains(c)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
        
    }
}
