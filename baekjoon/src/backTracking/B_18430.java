package backTracking;

import java.util.*;
import java.io.*;

public class B_18430 {
	static int[][] dir = {{0, -1}, {1, 0}, {-1, 0}, {0, -1}, {-1, 0}, {0, 1}, {0, 1}, {1, 0}};
	static int N, M;
	static boolean[][] visit;
	static int[][] bmr;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		bmr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				bmr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1 || M == 1) {
			System.out.println(0);
			return;
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int start, int sum) {
		answer = Math.max(answer, sum);
		
		for(int i=start;i<N*M;i++) {
			int r = i / M;
			int c = i % M;
			
			if(visit[r][c])
				continue;
			
			for(int j=0;j<8;j+=2) {
				int r1 = r + dir[j][0];
				int c1 = c + dir[j][1];
				
				int r2 = r + dir[j + 1][0];
				int c2 = c + dir[j + 1][1];
				
				if(check(r1, c1) && check(r2, c2)) {
					int result = calcute(r, c, r1, c1, r2, c2);
					visit[r][c] = true;
					visit[r1][c1] = true;
					visit[r2][c2] = true;
					
					DFS(i + 1, sum + result);
					visit[r][c] = false;
					visit[r1][c1] = false;
					visit[r2][c2] = false;
				}
			}
		}
	}
	
	static boolean check(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M && !visit[r][c])
			return true;
		return false;
	}
	
	static int calcute(int r, int c, int r1, int c1, int r2, int c2) {
		return bmr[r][c] * 2 + bmr[r1][c1] + bmr[r2][c2];
	}

}
