package Leetcode1424;

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len=0;
        Map<Integer, Stack<Integer>> map=new TreeMap<>();
        for (int i=0;i<nums.size();i++){
            for (int j=0;j<nums.get(i).size();j++){
                if (map.containsKey(i+j)){
                    map.get(i+j).push(nums.get(i).get(j));
                }
                else {
                    Stack<Integer> stack=new Stack<>();
                    stack.push(nums.get(i).get(j));
                    map.put(i+j,stack);
                }
                len++;
            }
        }
        int[] result=new int[len];
        len=0;
        for (int i=0;i<map.size();i++){
            while (!map.get(i).isEmpty()){
                result[len]=map.get(i).pop();
                len++;
            }
        }
        return result;
    }

    public int[] findDiagonalOrder1(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            int t1 = a.i + a.j;
            int t2 = b.i + b.j;
            if (t1 == t2) {
                return a.i == b.i ? a.j - b.j : b.i - a.i;
            }
            return t1 - t2;
        });
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                pq.offer(new Node(i, j, nums.get(i).get(j)));
            }
        }
        int[] res = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll().v;
        }
        return res;
    }

    static class Node {

        private int i;
        private int j;
        private int v;

        public Node(int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.v = v;
        }
    }

}