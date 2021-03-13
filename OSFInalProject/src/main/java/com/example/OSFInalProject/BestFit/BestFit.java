package com.example.OSFInalProject.BestFit;

import java.util.ArrayList;
import java.util.List;

public class BestFit {
    private int memoryid;
    private int memorySize;
    private int jobNumber;
    private boolean status;
    private int internalFragmentation;

    public BestFit() {
    }

    public BestFit(int memoryid, int memorySize, int jobNumber, boolean status, int internalFragmentation) {
        this.memoryid = memoryid;
        this.memorySize = memorySize;
        this.jobNumber = jobNumber;
        this.status = status;
        this.internalFragmentation = internalFragmentation;
    }

    public int getMemoryid() {
        return memoryid;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public int getInternalFragmentation() {
        return internalFragmentation;
    }

    public List<BestFit> bestFits (List<Job> jobList , List<Memory> memoryList){
        List<BestFit> bestFits = new ArrayList<BestFit>();
        for (Job job : jobList){
            for(Memory memory : memoryList){
                int count = 0;;
                if (memory.isStatus()){
                    if (job.getMemoryRequested() < memory.getMemorySize()){
                        if (count != 0){
                            int index = count;
                            if (memoryList.get(index++).getMemorySize() > job.getMemoryRequested()){
                                memory.setStatus(false);
                                bestFits.add(new BestFit(
                                        memory.getId(),
                                        memory.getMemorySize(),
                                        job.getJobNumber(),
                                        false,
                                        memory.getMemorySize()-job.getMemoryRequested()
                                ));
                                break;
                            }
                        }
                        else{
                            memory.setStatus(false);
                            bestFits.add(new BestFit(
                                    memory.getId(),
                                    memory.getMemorySize(),
                                    job.getJobNumber(),
                                    false,
                                    memory.getMemorySize()-job.getMemoryRequested()
                            ));
                            break;
                        }
                    }
                }
            }
        }
        return bestFits;
    }

    @Override
    public String toString() {
        return "BestFit{" +
                "memoryid=" + memoryid +
                ", memorySize=" + memorySize +
                ", jobNumber=" + jobNumber +
                ", status=" + status +
                ", internalFragmentation=" + internalFragmentation +
                '}';
    }
}
