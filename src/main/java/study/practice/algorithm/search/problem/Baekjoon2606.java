package study.practice.algorithm.search.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 바이러스
public class Baekjoon2606 {
    public static ArrayList<Integer>[] nodes;
    public static boolean[] visited;

    public static void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());

            nodes = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i < N + 1; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                nodes[u].add(v);
                nodes[v].add(u);

            }
            System.out.println(dfs(1) - 1);
        }catch (Exception e){}

    }

    public static int dfs(int node) {
        if(visited[node]){
            return 0;
        }
        visited[node] = true;
        int count = 1;
        for(int i : nodes[node]){
            if(!visited[i]){
                count += dfs(i);
            }
        }
        return count;
    }

}
