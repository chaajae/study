package study.practice.algorithm;

public class AlgorithmItem {
    public static int[] getIntArr() {
        int[] arr = new int[5000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNum();
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

    public static int getRandomNum(){
        return ((int) (Math.random() * 50)) ;
    }
}
