package study.practice.algorithm.sort;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class InsertionSort {

    public static void run(){
        int[] arr = AlgorithmItem.getIntArr();
        for (int index = 1; index < arr.length; index++) {
            int temp = arr[index];
            int prev = index - 1;
            while ((prev >= 0) && (arr[prev] > temp)){
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
