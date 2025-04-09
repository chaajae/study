package study.practice.algorithm.sort;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(){
        int[] arr = AlgorithmItem.getIntArr();
        int indexMin, temp;

        for (int i = 0; i < arr.length-1; i++) {
            indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[indexMin]){
                    indexMin = j;
                }
            }
            AlgorithmItem.swap(arr, indexMin, i);
        }
        System.out.println(Arrays.toString(arr));
    }
}
