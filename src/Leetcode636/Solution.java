package Leetcode636;

import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> funs=new Stack<>();
        int[] times=new int[n];
        String[] s=logs.get(0).split(":");
        funs.push(Integer.parseInt(s[0]));
        int i=1;
        int prev=Integer.parseInt(s[2]);
        while (i<logs.size()){
            s=logs.get(i).split(":");
            if (s[1].equals("start")){
                if (!funs.isEmpty()){
                    times[funs.peek()]+=Integer.parseInt(s[2])-prev;
                }
                funs.push(Integer.parseInt(s[0]));
                prev=Integer.parseInt(s[2]);
            }
            else {
                times[funs.peek()]+=Integer.parseInt(s[2])-prev+1;
                funs.pop();
                prev=Integer.parseInt(s[2])+1;
            }
            i++;
        }
        return times;
    }
}
