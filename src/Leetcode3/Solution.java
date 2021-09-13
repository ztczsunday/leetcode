package Leetcode3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    //耗时太长
    public int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        Set<Character> characterSet=new HashSet<>();
        int maxLength=1,size=arr.length;
        if(size==0){
            return 0;
        }
        for (int i=0;i<size;i++){
            characterSet.clear();
            for (int j=i;j<size;j++){
                characterSet.add(arr[j]);
                if (characterSet.size()!=j-i+1){
                    break;
                }
            }
            if (characterSet.size()>maxLength){
                maxLength=characterSet.size();
            }
            if (maxLength+i==size){
                return maxLength;
            }
        }
        return maxLength;
    }
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> characterSet = new HashSet<>();
        int size=s.length();
        int maxLength=0;
        int lk=0,rk=0;
        for (int i=0;i<size;i++){
            while (characterSet.contains(s.charAt(rk))){
                characterSet.remove(s.charAt(lk));
                lk++;
            }
            characterSet.add(s.charAt(rk));
            rk++;
            if (characterSet.size()>maxLength){
                maxLength=characterSet.size();
            }
        }
        return maxLength;
    }
}