package LeetcodeOfferII106;

import java.util.*;

class Solution {
    public static boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colorArr = new int[size];
        for (int i = 0; i < size; i++) {
            if (colorArr[i] == 0) {
                if (!putColor(graph, colorArr, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean putColor(int[][] graph, int[] colorArr, int key) {
        colorArr[key] = 1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(key);
        while (!queue.isEmpty()){
            key=queue.poll();
            for (int a:graph[key]
                 ) {
                if (colorArr[a]==0){
                    colorArr[a]=-colorArr[key];
                    queue.add(a);
                }else if (colorArr[a]==colorArr[key]){{
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] a = {{1,2,3}, {0, 2}, {0,1,3}, {0, 2}};
        isBipartite(a);
    }
}