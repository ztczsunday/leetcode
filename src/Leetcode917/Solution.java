package Leetcode917;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public static String reverseOnlyLetters(String s) {
        char[] chars=s.toCharArray();
        Stack<Character> letters=new Stack<>();
        Stack<Character> symbols=new Stack<>();
        for (int i=0;i<chars.length;i++){
           if (('a'<=chars[i]&&chars[i]<='z')||('A'<=chars[i]&&chars[i]<='Z')){
                letters.push(chars[i]);
                chars[i]='a';
           }
        }
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='a'){
                chars[i]=letters.pop();
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        reverseOnlyLetters("ac-db");
    }
}