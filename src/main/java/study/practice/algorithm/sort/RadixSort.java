package study.practice.algorithm.sort;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void sort(){
        int[] arr = AlgorithmItem.getIntArr();
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Length : " + arr.length);
    }

    public static void radixSort(int[] arr){
        int max = AlgorithmItem.getMax(arr);
        int radix = 1;

        Queue<Integer>[] bucket = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new LinkedList<>();

        }

        while (radix <= max){
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / radix) % 10].add(arr[i]);
            }

            for (int arrIdx = 0, bucketIdx = 0; bucketIdx < 10; bucketIdx++) {
                while (!bucket[bucketIdx].isEmpty()){
                    arr[arrIdx++] = bucket[bucketIdx].poll();
                }
            }
            radix *= 10;
        }

    }

}
