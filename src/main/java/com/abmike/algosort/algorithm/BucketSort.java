package com.abmike.algosort.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    private long stepCount;

    public int[] sort(int[] arr) {
        stepCount = 0;
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        stepCount += 2; // for the two initial assignments above

        // Find the minimum and maximum values
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
            stepCount += 3; // 1 for comparison and 2 for possible assignment
        }

        int bucketCount = maxValue - minValue + 1;
        stepCount++; // for the above calculation

        // Initialize buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
            stepCount++;
        }

        // Distribute the elements into buckets
        for (int value : arr) {
            buckets.get(value - minValue).add(value);
            stepCount++;
        }

        // Concatenate the sorted buckets
        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            stepCount += bucket.size(); // Approximating steps for adding elements to buckets
            Collections.sort(bucket);
            stepCount += bucket.size() * Math.log(bucket.size() + 1); // Approximation for Collections.sort
            for (int value : bucket) {
                arr[currentIndex++] = value;
                stepCount++;
            }
        }

        return arr;
    }

    public long getStepCount() {
        return stepCount;
    }
}
