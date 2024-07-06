package com.abmike.algosort.algorithm;

public class HeapSort {
    private long stepCount;

    public int[] sort(int[] arr) {
        stepCount = 0;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            stepCount++;

            heapify(arr, i, 0);
        }

        return arr;
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            stepCount++;

            heapify(arr, n, largest);
        }
        stepCount++;
    }

    public long getStepCount() {
        return stepCount;
    }
}