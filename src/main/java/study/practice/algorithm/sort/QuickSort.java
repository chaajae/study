package study.practice.algorithm.sort;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class QuickSort {
    public static void sort(){
        int[] arr = AlgorithmItem.getIntArr();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("Length : " + arr.length);
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot -1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j){
            while (pivot < arr[j]){
                j--;
            }
            while (i < j && pivot >= arr[i]){
                i++;
            }
            AlgorithmItem.swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }


}
