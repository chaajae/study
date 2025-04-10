package study.practice.algorithm.search;

import study.practice.algorithm.AlgorithmItem;

import java.util.Arrays;

public class BinarySearch {
    public static void run(){
        int[] arr = AlgorithmItem.getIntArr();
        int n = 31115;
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end){
            int mid = (start + end) / 2;
            if(n == arr[mid]){
                result = mid;
                break;
            }else if(arr[mid] < n){
                start = mid + 1;
            }else if(n < arr[mid]){
                end = mid - 1;
            }
        }
        System.out.println("INDEX : " + (result < 0 ? "없음" : result ));


    }
}
