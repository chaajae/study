package study.practice.algorithm.sort;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class HeapSort {
    public static void sort(){
        int[] arr = AlgorithmItem.getIntArr();
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Length : " + arr.length);
    }

    public static void heapSort(int[] arr){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            AlgorithmItem.swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i){
        int p = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if(l < n && arr[p] < arr[l]){
            p = l;
        }

        if(r < n && arr[p] < arr[r]){
            p = r;
        }

        if(i != p){
            AlgorithmItem.swap(arr, p, i);
            heapify(arr, n, p);
        }
    }


}
