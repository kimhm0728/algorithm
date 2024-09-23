package java.practice;

import java.util.*;
import java.io.*;

public class Main2 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, M;
	static int[][] donut;
	static boolean[][] visit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		donut = new int[N][M];
		visit = new boolean[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				donut[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(donut[i][j] == 0 && !visit[i][j]) {
					BFS(i, j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

	static void BFS(int startX, int startY) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX, startY});
		visit[startX][startY] = true;

		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int nowX = arr[0];
			int nowY = arr[1];

			for(int i=0;i<4;i++) {
				int nextX = checkX(nowX + dir[i][0]);
				int nextY = checkY(nowY + dir[i][1]);

				if(visit[nextX][nextY] || donut[nextX][nextY] == 1)
					continue;
				
				visit[nextX][nextY] = true;
				q.offer(new int[] {nextX, nextY});
			}
		}
	}

	static int checkX(int x) {
		if(x >= 0 && x < N)
			return x;

		if(x == -1)
			return N - 1;

		return 0; // x == N
	}

	static int checkY(int y) {
		if(y >= 0 && y < M)
			return y;

		if(y == -1)
			return M - 1;

		return 0; // y == M
	}

}
