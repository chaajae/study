package study.practice.algorithm.sort;


import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class BubbleSort {
    public static void run(){
        int[] arr = AlgorithmItem.getIntArr();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]){
                    AlgorithmItem.swap(arr, j-1, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
