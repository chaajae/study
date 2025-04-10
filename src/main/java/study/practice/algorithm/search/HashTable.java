package study.practice.algorithm.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HashTable {
    private static final int HASH_SIZE = 1000;
    private static final int HASH_LEN = 400;
    private static final int HASH_VAL = 17;
    private static int[][] data = new int[HASH_SIZE][HASH_LEN];
    private static int[] length = new int[HASH_SIZE];
    private static String[][] s_data = new String[HASH_SIZE][HASH_LEN];
    private static String str;
    private static int N;

    public static void run(){
        try {
            System.out.print("Num 입력 : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                System.out.print("String 입력 : ");
                str = br.readLine();
                int key = getHashKey(str);
                int cnt = checking(key);

                if(cnt != -1){
                    sb.append(str).append(cnt).append("\n");
                }else{
                    sb.append("OK").append("\n");
                }
            }
            System.out.println(sb.toString());
        }catch (Exception e){}
    }

    public static int getHashKey(String str){
        int key = 0;

        for (int i = 0; i < str.length(); i++) {
            key = (key * HASH_VAL) + str.charAt(i);
        }

        if(key < 0) key = -key;

        return key % HASH_SIZE;
    }

    public static int checking(int key){
        int len = length[key];
        if(len != 0){
            for (int i = 0; i < len; i++) {
                if(str.equals(s_data[key][i])){
                    data[key][i]++;
                    return data[key][i];
                }
            }
        }
        s_data[key][length[key]++] = str;
        return -1;
    }

}
