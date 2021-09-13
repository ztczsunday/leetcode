package Leetcode1482;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public static int minDays(int[] bloomDay, int m, int k) {
        int sizeOfBloomDay=bloomDay.length;
        if (m*k>sizeOfBloomDay){
            return -1;
        }
        Set<Integer> setOfBloomDay=new TreeSet<>();
        for (int a:bloomDay
             ) {
            setOfBloomDay.add(a);
        }
        int sizeOfSet= setOfBloomDay.size();
        Integer[] a=new Integer[sizeOfSet];
        setOfBloomDay.toArray(a);
        int left=0,right=sizeOfSet-1,mid=-1;
        while (mid!=(left+right)/2){
            mid=(left+right)/2;
            if (check(bloomDay,m,k,a[mid])){
                right=mid;
            }else {
                left=mid;
            }
        }
        System.out.println(a[right]);
        return a[right];
    }

    public static boolean check(int[] bloomDay, int m, int k, int days){
        int countOfK=0,countOfM=0;
        for (int b:bloomDay
        ) {
            if (days>=b){
                countOfK++;
            }
            if (countOfK==k){
                countOfM++;
                countOfK=0;
            }
            if (countOfM==m){
                return true;
            }
            if (days<b){
                countOfK=0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a={5,37,55,92,22,52,31,62,99,64,92,53,34,84,93,50,28};
        minDays(a,8,2);
    }
}