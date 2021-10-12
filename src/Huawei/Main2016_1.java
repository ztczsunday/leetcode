package Huawei;

import java.util.Scanner;

public class Main2016_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A, B, max, end, begin;
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            int m = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                char c = in.next().charAt(0);
                switch (c) {
                    case 'Q':
                        A = in.nextInt();
                        B = in.nextInt();
                        begin = Math.min(A, B) - 1;
                        end = Math.max(A, B) - 1;
                        max = a[end];
                        for (int j = begin; j < end; j++) {
                            if (max < a[j]) {
                                max = a[j];
                            }
                        }
                        System.out.println(max);
                        break;
                    case 'U':
                        A = in.nextInt() - 1;
                        B = in.nextInt();
                        a[A] = B;
                        break;
                    default:
                        break;
                }
            }
        }
        in.close();
    }
}
