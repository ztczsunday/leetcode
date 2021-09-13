package Leetcode1465;

import java.util.Arrays;

class Solution {
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod=1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int sizeW=verticalCuts.length,sizeH=horizontalCuts.length;
        long maxW=verticalCuts[0],maxH=horizontalCuts[0];
        for (int i=1;i<sizeH;i++){
            if (horizontalCuts[i]-horizontalCuts[i-1]>maxH){
                maxH=horizontalCuts[i]-horizontalCuts[i-1];
            }
        }
        if (h-horizontalCuts[sizeH-1]>maxH){
            maxH=h-horizontalCuts[sizeH-1];
        }
        for (int i=1;i<sizeW;i++){
            if (verticalCuts[i]-verticalCuts[i-1]>maxW){
                maxW=verticalCuts[i]-verticalCuts[i-1];
            }
        }
        if (w-verticalCuts[sizeW-1]>maxW){
            maxW=w-verticalCuts[sizeW-1];
        }
        return (int)((maxH*maxW)%mod);
    }

    public static void main(String[] args) {
        int[] a={3,1};
        int[] b={1};
        maxArea(5,4,a,b);
    }
}