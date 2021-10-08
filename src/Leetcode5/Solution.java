package Leetcode5;


class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        int size = s.length();
        int end = 0, start = 0;
        for (int i = 0; i < size; i++) {
            int size1 = palindrome(s, i, i, size);
            int size2 = palindrome(s, i, i + 1, size);
            int result = Math.max(size1, size2);
            if (result > end - start + 1) {
                start = i - (result - 1) / 2;
                end = i + result / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindrome(String s, int left, int right, int size) {
        while (left >= 0 && right < size && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}