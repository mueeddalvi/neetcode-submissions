class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int length = strs.length;
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int count[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        for (Map.Entry<String, List<String>> it : map.entrySet()) {
            result.add(it.getValue());
        }

        return result;
    }
}
