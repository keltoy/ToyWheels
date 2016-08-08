package com.toy.wheels;

/**
 * Created by toy on 8/8/16.
 */
public class SelectionSort implements Sort {
    public static void sort(int[] a) {
        int minIndex = 0;
        int tmp = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            minIndex = i;
            for (int j = i + 1; j <a.length; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }
}
