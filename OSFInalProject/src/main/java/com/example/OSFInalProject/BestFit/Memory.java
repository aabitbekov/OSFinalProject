package com.example.OSFInalProject.BestFit;

public class Memory {
    private int id;
    private int memorySize;
    private boolean status; // if this memory is busy status will be false
    static int count = 0;

    public Memory(int memorySize) {
        this.id = count++;
        this.memorySize = memorySize;
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", memrorySize=" + memorySize +
                ", status=" + status +
                '}';
    }
}

