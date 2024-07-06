package com.abmike.algosort.algorithm;

public class MergeSort {
    private long stepCount;

    public int[] sort(int[] arr) {
        stepCount = 0;
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            stepCount += arr.length;

            sort(left);
            sort(right);

            merge(arr, left, right);
        }
        return arr;
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
            stepCount++;
        }

        while (i < left.length) {
            arr[k++] = left[i++];
            stepCount++;
        }

        while (j < right.length) {
            arr[k++] = right[j++];
            stepCount++;
        }
    }

    public long getStepCount() {
        return stepCount;
    }
}