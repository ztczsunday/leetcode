package Leetcode1796;

import java.util.*;

class Solution {
    public static int secondHighest(String s) {
        Set<Character> nums=new HashSet<>();
        for (char c:s.toCharArray()
        ) {
            if (c>='0'&&c<='9'){
                nums.add(c);
            }
        }
        int size=nums.size();
        if (size<2){
            return -1;
        }
        int i=0;
        for (char c:nums
        ) {
            i++;
            if (i==size-1){
                return c-'0';
            }

        }
        return 0;
    }

    public int secondHighest2(String s) {
        int first = -1, second = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (first == -1) {
                    first = num;
                } else if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second)
                {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        secondHighest(
                "dfa12321afd");
    }
}