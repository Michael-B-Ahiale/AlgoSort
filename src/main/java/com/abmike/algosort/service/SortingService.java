
package com.abmike.algosort.service;

import com.abmike.algosort.model.SortResult;
import com.abmike.algosort.algorithm.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SortingService {
    private static final Map<String, SortResult> sortResults = new ConcurrentHashMap<>();

    public SortResult sort(String numbers, String algorithm) {
        int[] arr = parseNumbers(numbers);
        int[] sortedArr;
        long startTime = System.nanoTime();
        long stepCount = 0;

        switch (algorithm.toLowerCase()) {
            case "quicksort":
                QuickSort quickSort = new QuickSort();
                sortedArr = quickSort.sort(arr.clone());
                stepCount = quickSort.getStepCount();
                break;
            case "heapsort":
                HeapSort heapSort = new HeapSort();
                sortedArr = heapSort.sort(arr.clone());
                stepCount = heapSort.getStepCount();
                break;
            case "mergesort":
                MergeSort mergeSort = new MergeSort();
                sortedArr = mergeSort.sort(arr.clone());
                stepCount = mergeSort.getStepCount();
                break;
            case "radixsort":
                RadixSort radixSort = new RadixSort();
                sortedArr = radixSort.sort(arr.clone());
                stepCount = radixSort.getStepCount();
                break;
            case "bucketsort":
                BucketSort bucketSort = new BucketSort();
                sortedArr = bucketSort.sort(arr.clone());
                stepCount = bucketSort.getStepCount();
                break;
            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000; // Convert to milliseconds

        SortResult result = new SortResult(numbers, arrayToString(sortedArr), algorithm, executionTime, stepCount);
        sortResults.put(result.getId(), result);
        return result;
    }
    public List<SortResult> getAllSortResults() {
        return new ArrayList<>(sortResults.values());
    }

    public SortResult getSortResult(String id) {
        return sortResults.get(id);
    }

    public SortResult updateSortResult(String id, SortResult updatedResult) {
        if (sortResults.containsKey(id)) {
            updatedResult.setId(id);
            sortResults.put(id, updatedResult);
            return updatedResult;
        }
        return null;
    }

    public boolean deleteSortResult(String id) {
        return sortResults.remove(id) != null;
    }

    private int[] parseNumbers(String numbers) {
        String[] numStrings = numbers.split(",");
        int[] arr = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            arr[i] = Integer.parseInt(numStrings[i].trim());
        }
        return arr;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}