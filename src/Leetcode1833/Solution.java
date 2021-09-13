package Leetcode1833;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int num=0;
        Arrays.sort(costs);
        for (int i=0;i<costs.length;i++){
            if (coins>=costs[i]){
                coins=coins-costs[i];
                num++;
            }
            else {
                break;
            }
        }
        return num;
    }
}