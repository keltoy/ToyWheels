package com.toy.wheels;

/**
 * Created by toy on 8/1/16.
 */
public class MergeSort implements Sort {
    public void sort(int[] a) {
        mergeSort(a, 0, 1);
    }

    private void mergeSort(int[] a, int s, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);

        if (mid == 0) return;

        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            merge(a, s, s+len, (len<<1)+s-1);
        }
        if (c != 0)
            merge(a, size-c-2*len, size-c, size-1);
        mergeSort(a, 0, 2*len);
    }

    private void merge(int[] a, int s, int m, int t) {
        int tmp[] = new int[t-s+1];
        int i = s;
        int j = m;
        int k = 0;
        while (i < m && j<=t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                ++k; ++i;
            } else {
                tmp[k] = a[j];
                ++k; ++j;
            }
        }
        while (i < m) {
            a[k] = a[i];
            ++i; ++k;
        }
        while (j <= t) {
            a[k] = a[j];
            ++j; ++k;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    public static boolean isStable() {
        return true;
    }

    public static String showTimeComplexity() {
        StringBuffer sb = new StringBuffer();
        sb.append("Average: ");
        sb.append("O(n*log2(n))\n");
        sb.append("Best: ");
        sb.append("O(n*log2(n))\n");
        sb.append("Worst: ");
        sb.append("O(n*log2(n))\n");
        return sb.toString();
    }

    public static String showSpaceComplexity() {
        return "O(1)";
    }

}
