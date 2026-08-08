class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    int length = j - i + 1;
                    if (maxLength < length) {
                        maxLength = length;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }

    public boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
