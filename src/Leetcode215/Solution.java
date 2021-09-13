package Leetcode215;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int n:nums
             ) {
            heap.add(n);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] a={2,5,6,7,2,4,9};
        findKthLargest(a,4);
    }
}