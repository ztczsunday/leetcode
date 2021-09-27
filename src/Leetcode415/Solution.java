package Leetcode415;

class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int flag = 0;
        while (index1 >= 0 || index2 >= 0 || flag != 0) {

            int x = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int y = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int result = x + y + flag;
            flag = result / 10;
            ans.append(result % 10);
            index1--;
            index2--;
        }
        ans.reverse();
        return ans.toString();
    }
}