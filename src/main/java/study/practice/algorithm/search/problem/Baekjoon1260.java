package study.practice.algorithm.search.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS
public class Baekjoon1260 {
    private static ArrayList<Integer>[] nodes;
    private static boolean[] visited;
    public static void run(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i < N + 1; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 1; i < E + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                nodes[u].add(v);
                nodes[v].add(u);
            }

            for (int i = 1; i < nodes.length; i++) {
                Collections.sort(nodes[i]);
            }

            dfs(start);
            System.out.println();
            visited = new boolean[N + 1];
            bfs(start);

        }catch (Exception e){}
    }

    public static void dfs(int index){
        visited[index] = true;
        System.out.print(index + " ");
        for(int i : nodes[index]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int index){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        q.offer(index);
        visited[index] = true;

        while (!q.isEmpty()){
            int node = q.poll();
            sb.append(node).append(" ");
            for (int i = 0; i < nodes[node].size(); i++) {
                int v = nodes[node].get(i);
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
