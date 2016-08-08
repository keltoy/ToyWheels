package com.toy.wheels;

/**
 * Created by toy on 8/3/16.
 */
public class QuickSort implements Sort {
    public static void sort(int[] a) {

    }

    private static void quickSort(int[] a, int start, int end) {
        int i = start;
        int j = end;
        int key = a[start];

        while (i < j) {
            while (j > i && a[j] >= key) {
                --j;
            }
            if (i < j) {
                a[i] = a[j];
                ++i;

            }

            while (i < j && a[i] <= key) {
                ++i;
            }
            if (i < j) {
                a[j] = a[i];
                --j;
            }
        }
        a[i] = key;
        quickSort(a, start, i-1);
        quickSort(a, j+1, end);
    }
}