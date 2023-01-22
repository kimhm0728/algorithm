package backTracking;

import java.util.*;
import java.io.*;

public class B_1799 {
	static int N;
	static boolean[][] visit;
	static int[][] board;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N][N];
		board = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int depth, int cnt) {
		if(depth == N*N) {
			answer = Math.max(cnt, answer);
			return;
		}
		
		int r = depth / N;
		int c = depth % N;
		
		if(board[r][c] == 0 || visit[r][c])
			DFS(depth + 1, cnt);
		else {
			if(check(r, c)) {
				visit[r][c] = true;
				DFS(depth + 1, cnt + 1);
				visit[r][c] = false;
			}
			DFS(depth + 1, cnt);
		}
	}
	
	static boolean check(int r, int c) {
		int tempR = r;
		int tempC = c;
		
		while(true) {
			tempR--;
			tempC--;
			if(tempR < 0 || tempC < 0)
				break;
			
			if(visit[tempR][tempC])
				return false;
		}
		
		while(true) {
			r--;
			c++;
			if(r < 0 || c >= N)
				break;
			
			if(visit[r][c])
				return false;
		}
		
		return true;
	}

}
