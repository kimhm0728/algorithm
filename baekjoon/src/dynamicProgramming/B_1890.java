package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1890 {
	static int N;
	static int[][] board;
	static Long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		dp = new Long[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[N - 1][N - 1] = (long)1;
		System.out.println(getPath(0, 0));
	}
	
	static long getPath(int r, int c) {
		if(r >= N || c >= N || (r != N - 1 && c != N - 1 && board[r][c] == 0))
			return 0;
		
		if(dp[r][c] == null) {
			dp[r][c] = getPath(r + board[r][c], c) + getPath(r, c + board[r][c]);
		}
		
		return dp[r][c];
	}

}
