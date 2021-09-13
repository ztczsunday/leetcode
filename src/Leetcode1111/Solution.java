package Leetcode1111;

import java.util.Stack;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depthA=0,depthB=0;
        int[] result=new int[seq.length()];
        int i=0;
        for (char c:seq.toCharArray()
             ) {
            if (c=='('){
                if (depthA>depthB){
                    depthB++;
                    result[i]=1;
                }else {
                    depthA++;
                    result[i]=0;
                }
            }
            else {
                if (depthA>depthB){
                    depthA--;
                    result[i]=0;
                }else {
                    depthB--;
                    result[i]=1;
                }
            }
            i++;
        }
        return result;
    }

}