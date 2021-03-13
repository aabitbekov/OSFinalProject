package com.example.OSFInalProject.BestFit;

import java.util.Comparator;

public class MemoryComp implements Comparator<Memory> {

    @Override
    public int compare(Memory o1, Memory o2) {
        return o1.getMemorySize() - o2.getMemorySize();
    }
}
