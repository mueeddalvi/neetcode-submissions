class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        else if (s.length() == t.length() && s.equals(t)) {
            return s;
        }

        int l, r, currLen, count;
        String res="";
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++)
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        /*
        T - 2
        A - 1
        */

        l = r = count = 0;
        currLen = 10005;
        count = mapT.size(); // required unique characters
        while (r < s.length()) {
            char cr = s.charAt(r);
            if (mapT.containsKey(cr)) {
                mapT.put(cr, mapT.get(cr) - 1);
                if (mapT.get(cr) == 0)
                    count--;
            }

            if (count > 0)
                r++;
            else {
                
                while (count == 0) {
                    char cl = s.charAt(l);
                    if (currLen > (r - l + 1)) {
                        currLen = r - l + 1;
                        res = s.substring(l, r+1);
                    }
                    if(mapT.containsKey(cl)){
                        mapT.put(cl, mapT.get(cl)+1);
                        if(mapT.get(cl)==1)
                            count++;
                    }
                    l++;
                }
                r++;
            }
        }

        return res;
    }
}
