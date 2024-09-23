package java.bfs;

import java.util.*;
import java.io.*;

public class B_2468 {
	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int N, max = 0;
	static int[][] height;
	static boolean[][] visit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		height = new int[N][N];
		visit = new boolean[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(height[i][j], max);
			}
		}
		
		// i: ���� �� / j, k: ������ ���� ��ġ
		for(int i=0;i<=max;i++) {
			int cnt = 0;
			visit = new boolean[N][N];
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(!visit[j][k] && height[j][k] > i) {
						cnt++;
						BFS(j, k, i);
					}
				}
			}
			answer = Math.max(cnt, answer);
		}
		
		System.out.println(answer);
	}
	
	// ���̰� rain ������ ������ ���
	static void BFS(int r, int c, int rain) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0;i<4;i++) {
				int nextR = now[0] + dir[i][0];
				int nextC = now[1] + dir[i][1];
				
				if(check(nextR, nextC, rain)) {
					visit[nextR][nextC] = true;
					q.offer(new int[] {nextR, nextC});
				}
			}
		}
	}
	
	static boolean check(int r, int c, int rain) {
		if(r < 0 || r >= N || c < 0 || c >= N || visit[r][c] || height[r][c] <= rain)
			return false;
		
		return true;
	}

}
