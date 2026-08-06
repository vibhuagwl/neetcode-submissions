class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int start = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);

            if (freq[ch] > 0) {
                required--;
            }
            freq[ch]--;
            right++;

            while (required == 0) {
                char remove = s.charAt(left);
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                freq[remove]++;
                if (freq[remove] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
