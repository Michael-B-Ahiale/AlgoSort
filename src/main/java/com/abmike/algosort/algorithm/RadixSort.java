package com.abmike.algosort.algorithm;

import java.util.Arrays;

public class RadixSort {
    private long stepCount;

    public int[] sort(int[] arr) {
        stepCount = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        stepCount += arr.length; // Approximation for finding max

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }

        return arr;
    }

    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);
        stepCount += 10;

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
            stepCount++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            stepCount++;
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            stepCount++;
        }

        System.arraycopy(output, 0, arr, 0, n);
        stepCount += n;
    }

    public long getStepCount() {
        return stepCount;
    }
}