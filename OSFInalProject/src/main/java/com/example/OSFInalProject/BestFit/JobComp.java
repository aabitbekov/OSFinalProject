package com.example.OSFInalProject.BestFit;

import java.util.Comparator;

public class JobComp implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getMemoryRequested() - o2.getMemoryRequested();
    }
}
