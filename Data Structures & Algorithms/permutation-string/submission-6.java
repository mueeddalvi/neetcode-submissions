class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1, length2, l, r;
        length1 = length2 = l = r = 0;
        length1 = s1.length();
        length2 = s2.length();
        if (length1 > length2)
            return false;
        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> mapS2 = new HashMap<>();

        for (int i = 0; i < length1; i++) {
            char c = s1.charAt(i);
            char c2 = s2.charAt(i);

            mapS1.putIfAbsent(c, 0);
            mapS1.put(c, mapS1.get(c) + 1);

            mapS2.putIfAbsent(c2, 0);
            mapS2.put(c2, mapS2.get(c2) + 1);
        }
        if (mapS1.equals(mapS2))
            return true;
        r = length1;
        while (r < length2) {
            char cr = s2.charAt(r);
            char cl = s2.charAt(l);

            mapS2.put(cl, mapS2.get(cl) - 1);
            if (mapS2.get(cl) == 0)
                mapS2.remove(cl);
            l++;
            r++;
            mapS2.putIfAbsent(cr, 0);
            mapS2.put(cr, mapS2.get(cr) + 1);

            if (mapS1.equals(mapS2))
                return true;
        }

        return false;
    }
}
