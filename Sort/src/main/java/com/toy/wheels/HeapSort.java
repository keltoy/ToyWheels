package com.toy.wheels;

/**
 * Created by toy on 7/31/16.
 */
public class HeapSort implements Sort {
    public static void sort(int[] a) {
        buildMaxHeapify(a);
        heapSort(a);
    }

    public static void buildMaxHeapify(int[] a) {
        int start = getParentIndex(a.length-1);
        for (int i = start; i >= 0; --i)
            maxHeapify(a, a.length, i);
    }

    public static void heapSort(int[] a) {
        int tmp;
        for (int i = a.length-1; i > 0; --i) {
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            maxHeapify(a, i, 0);
        }
    }

    public static int getParentIndex(int index) {
        return ((index-1) >> 1);
    }

    public static int getChildLeftIndex(int index) {
        return (index << 1) + 1;
    }

    public static int getChildRightIndex(int index) {
        return (index << 1) + 2;
    }

    public static void maxHeapify(int[] a, int size, int index){
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);
        int max = index;
        if (left < size && a[left] > a[index]) {
            max = left;
        }
        if (right < size && a[right] > a[index]) {
            max = right;
        }
        if (index != max) {
            int tmp = a[index];
            a[index] = a[max];
            a[max] = tmp;
            maxHeapify(a, size, max);
        }
    }

    public static boolean isStable() {
        return false;
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
    public static void main(String[] args) {
        int a[] = {1,3,4,5,7,9,2,4,6,8};
        sort(a);
        for (int e:
        a){
            System.out.print(e +", ");
            System.out.print("\n");
        }

        System.out.println(showTimeComplexity());
    }
}

