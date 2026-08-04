class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if (map.containsKey(str)) {
                List<String> l = map.get(str);
                l.add(strs[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(str, l);
            }
        }
        return new ArrayList<>(map.values());
    }
}
