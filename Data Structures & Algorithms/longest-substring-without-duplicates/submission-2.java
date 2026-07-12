class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, length = s.length();
        if (s.length() == 0)
            return res;
        else if (s.length() == 1)
            return 1;

        Set<Character> set = new HashSet<>();

        int l = 0, r = 0;

        while (r < length) {
            char c = s.charAt(r);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                while (!set.isEmpty() && set.contains(c)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(c);
            }
            res = Math.max(res, set.size());
            r++;
        }

        return res;
    }
}
