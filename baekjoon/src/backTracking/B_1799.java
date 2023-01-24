package backTracking;

import java.util.*;
import java.io.*;

public class B_1799 {
	static int N;
	static boolean[][] visit;
	static int[][] board;
	static int w_cnt = 0, b_cnt = 0;

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
		
		DFS(0, 0, 0, true); // 흑은 (0, 0)에서 시작
		DFS(0, 1, 0, false); // 백은 (0, 1)에서 시작
		System.out.println(b_cnt + w_cnt);
	}
	
	// flag가 true면 흑, false면 백을 탐색
	static void DFS(int r, int c, int cnt, boolean flag) {
		if(r >= N) {
			if(flag)
				b_cnt = Math.max(b_cnt, cnt);
			else
				w_cnt = Math.max(w_cnt, cnt);
			return;
		}
		
		int nextR = r;
		int nextC = c + 2;
		if(nextC >= N) {
			nextR++;
			nextC = nextC % 2 == 0 ? 1 : 0;
		}
		
		if(board[r][c] == 0 || visit[r][c])
			DFS(nextR, nextC, cnt, flag);
		else {
			if(check(r, c)) {
				visit[r][c] = true;
				DFS(nextR, nextC, cnt + 1, flag);
				visit[r][c] = false;
			}
			DFS(nextR, nextC, cnt, flag);
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
