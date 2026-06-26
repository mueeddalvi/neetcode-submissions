class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int l, r, maxFreq, res;
        l = r = maxFreq = res = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < length) {
            char c = s.charAt(r);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            while ((r - l + 1) - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, (r - l + 1));
            r++;
        }

        return res;
    }
}
