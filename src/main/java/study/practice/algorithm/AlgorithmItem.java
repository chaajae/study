package study.practice.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlgorithmItem {
    public static int[] getIntArr() {
        int[] arr = new int[5000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 10000000)) + 1;
        }
        return arr;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
