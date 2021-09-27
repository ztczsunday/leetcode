package Leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()
             ) {
            if ((c=='(')||(c=='{')||(c=='[')){
                stack.push(c);
            }else {
                if (stack.isEmpty()|| !stack.pop().equals(pairs.get(c))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}