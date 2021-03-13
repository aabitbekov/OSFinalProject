package com.example.OSFInalProject.BestFit;

public class Job {
    private int jobNumber;
    private int memoryRequested;
    static int count = 0;

    public Job(int memoryRequested) {
        this.jobNumber = count++;
        this.memoryRequested = memoryRequested;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getMemoryRequested() {
        return memoryRequested;
    }

    public void setMemoryRequested(int memoryRequested) {
        this.memoryRequested = memoryRequested;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobNumber=" + jobNumber +
                ", memoryRequested=" + memoryRequested +
                '}';
    }
}
