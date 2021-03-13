package com.example.OSFInalProject;

import java.util.Arrays;

public class SecondCh {
     public int calculateFaults(String reference_string, int frames) {
        int pointer = 0, countOFFaults = 0, x = 0;
        int arr[] = new int[frames];
        Arrays.fill(arr, -1);
        boolean second_chance[] = new boolean[frames];
        String str[] = reference_string.split(" ");
        int len = str.length;
        for (int i = 0; i < len; i++) {
            x = Integer.parseInt(str[i]);
            if (!checkToQuals(x, arr, second_chance, frames)) {
                pointer = Update(x, arr, second_chance, frames, pointer);
                countOFFaults++;
            }
        }
        return countOFFaults;
    }


    static boolean checkToQuals(int x, int arr[], boolean second_chance[], int frames) {
        for (int i = 0; i < frames; i++) {
            if (arr[i] == x) {
                second_chance[i] = true;
                return true;
            }
        }
        return false;
    }

    static int Update(int x, int arr[], boolean second_chance[], int frames, int pointer) {
        while (true) {
            if (!second_chance[pointer]) {
                arr[pointer] = x;
                return (pointer + 1) % frames;
            }
            second_chance[pointer] = false;
            pointer = (pointer + 1) % frames;
        }
    }
}

