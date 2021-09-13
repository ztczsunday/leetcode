package Leetcode435;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    //答案错误
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp;
                    temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                i++;
                count++;
            }
        }
        return count;
    }


    //时间太长
    public static int earaseOverlapIntervals2(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        int count = 0;
        int endNum = -1;
        for (int i = 0; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i)[1] == result.get(i + 1)[1]) {
                if (result.get(i)[1] - result.get(i)[0] < result.get(i + 1)[1] - result.get(i + 1)[0]) {
                    result.remove(i + 1);
                } else {
                    result.remove(i);
                }
                i--;
            }
        }
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i)[1] > result.get(i + 1)[0]) {
                result.remove(i + 1);
                i--;
            }
        }
        return intervals.length - result.size();
    }

    public int eraseOverlapIntervals3(int[][] intervals) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int count = 1;
        int endNum = -1;
        for (int i = 0; i < intervals.length; i++) {
            arrayList.add(intervals[i]);
        }
        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        endNum = arrayList.get(0)[1];
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)[0] >= endNum) {
                endNum = arrayList.get(i)[1];
                count++;
            }
        }
        return arrayList.size() - count;
    }

    public int eraseOverlapIntervals4(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o2[0], o1[0]);
                }
            }
        });

        int count = 0;
        int edge = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < edge) {
                count++;
            } else {
                edge = intervals[i][1];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(earaseOverlapIntervals2(a));
    }
}