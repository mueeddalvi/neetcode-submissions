class Solution {
    List<List<String>> res;
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        res = new ArrayList<>();

        if (len == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char t[]=s.toCharArray();
            Arrays.sort(t);
            String key = new String(t);
            map.putIfAbsent(key, new ArrayList<>());
            if (map.containsKey(key)) {
                List<String> curr = map.get(key);
                curr.add(s);
            }
        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            res.add(e.getValue());
        }

        return res;
    }
}
