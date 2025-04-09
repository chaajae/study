package study.practice.algorithm.sort;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class CountingSort {
    public static void sort(){
        int[] arr = AlgorithmItem.getIntArr();
        countingSort(arr, new int[AlgorithmItem.getMax(arr) + 1], new int[arr.length]);
        System.out.println(Arrays.toString(arr));
        System.out.println("Length : " + arr.length);
    }

    public static void countingSort(int[] arr, int[] counting, int[] result){
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            int value = arr[i];
            counting[value]--;
            result[counting[value]] = value;
        }
    }
}
