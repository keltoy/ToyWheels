package com.toy.wheels;

/**
 * Created by toy on 7/31/16.
 */
public class BubbleSort implements Sort{
    public static void sort(int[] a) {
        int tmp = 0;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j+1] < a[j]) {
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static boolean isStable() {
        return true;
    }

    public static String showTimeComplexity() {
        StringBuffer sb = new StringBuffer();
        sb.append("Average: ");
        sb.append("O(n^2)\n");
        sb.append("Best: ");
        sb.append("O(n)\n");
        sb.append("Worst: ");
        sb.append("O(n^2)\n");
        return sb.toString();
    }

    public static String showSpaceComplexity() {
        return "O(1)";
    }

    public static void main(String[] args) {
        int a[] = new int[30];
        for (int i = 29; i >= 0; --i) {
            a[i] = i;
        }
        sort(a);
        for (int j = 0; j < 30; ++j) {
            System.out.println(a[j]);
        }
        System.out.print(showTimeComplexity());
    }
}
