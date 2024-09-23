package java.practice.baekjoon;

import java.util.*;
import java.io.*;

public class B_17485 {
	static int INF = 987654321;
	static int[][] board;
	static int[][][] dp;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		dp = new int[3][n][m];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = INF;
		for (int i=0;i<m;i++) {
			for (int j=0;j<3;j++) {
				if ((i == 0 && j == 0) || (i == m - 1 && j == 2)) {
					continue;
				}
				
				answer = Math.min(answer, board[0][i] + moon(1, i + j - 1, j));
			}
		}
		
		System.out.println(answer);
	}
	
	static int moon(int x, int y, int d) {
		if (x == n - 1) return board[x][y];
		if (dp[d][x][y] != 0) return dp[d][x][y];
		
		dp[d][x][y] = INF;
		for (int i=0;i<3;i++) {
			if ((i == d) || (y == 0 && i == 0) || (y == m - 1 && i == 2)) {
				continue;
			}
			
			dp[d][x][y] = Math.min(dp[d][x][y], board[x][y] + moon(x + 1, y + i - 1, i));
		}
		
		return dp[d][x][y];
	}
	
}
