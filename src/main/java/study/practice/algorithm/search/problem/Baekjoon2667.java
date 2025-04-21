package study.practice.algorithm.search.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2667 {
    static int N, count;
    static int[][] map;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void run(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String searchType = br.readLine();
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            ArrayList<Integer> arr = new ArrayList<>();
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    count = 0;
                    if(map[i][j] == 1){
                        if(searchType.equals("dfs")) dfs(i, j);
                        else bfs(i, j);

                        arr.add(count);
                        result++;
                    }
                }
            }

            Collections.sort(arr);
            System.out.println(result);
            for (Integer i : arr) {
                System.out.println(i);
            }

        }catch (Exception e){}
    }

    public static void dfs(int x, int y) {
        map[x][y] = 0;
        count += 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        map[x][y] = 0;

        while (!que.isEmpty()){
            count += 1;
            int now[] = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1){
                    map[nx][ny] = 0;
                    que.offer(new int[]{nx, ny});
                }
            }
        }


    }

}
