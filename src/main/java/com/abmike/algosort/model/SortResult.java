package com.abmike.algosort.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SortResult {
    private String id;
    private String originalNumbers;
    private String sortedNumbers;
    private String algorithm;
    private long executionTime;
    private long stepCount;
    private Map<String, String> links;

    public SortResult() {
        this.id = UUID.randomUUID().toString();
        this.links = new HashMap<>();
    }

    public SortResult(String originalNumbers, String sortedNumbers, String algorithm, long executionTime, long stepCount) {
        this();
        this.originalNumbers = originalNumbers;
        this.sortedNumbers = sortedNumbers;
        this.algorithm = algorithm;
        this.executionTime = executionTime;
        this.stepCount = stepCount;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOriginalNumbers() { return originalNumbers; }
    public void setOriginalNumbers(String originalNumbers) { this.originalNumbers = originalNumbers; }
    public String getSortedNumbers() { return sortedNumbers; }
    public void setSortedNumbers(String sortedNumbers) { this.sortedNumbers = sortedNumbers; }
    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }
    public long getExecutionTime() { return executionTime; }
    public void setExecutionTime(long executionTime) { this.executionTime = executionTime; }
    public long getStepCount() { return stepCount; }
    public void setStepCount(long stepCount) { this.stepCount = stepCount; }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

    public void addLink(String rel, String href) {
        this.links.put(rel, href);
    }
}