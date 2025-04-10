package study.practice.algorithm.search.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon2667 {
    private static ArrayList<Integer>[] nodes;
    private static boolean[] visited;
    private static int N;
    public static void run(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());

            nodes = new ArrayList[N];
            visited = new boolean[N * N];

            for (int i = 0; i < N; i++) {
                nodes[i] = new ArrayList<>();
                String str = br.readLine();

                for (int j = 0; j < str.length(); j++) {
                    int value = Integer.parseInt(String.valueOf(str.charAt(j)));
                    nodes[i].add(value);
                }
            }


        }catch (Exception e){}
    }

}
