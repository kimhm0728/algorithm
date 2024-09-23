package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1890 {
	static int n;
	static long[][] dp;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new long[n][n];
		board = new int[n][n];
		
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[n - 1][n - 1] = 1;
		System.out.println(solution(0, 0));
	}
	
	static long solution(int r, int c) {
		if (dp[r][c] != 0) return dp[r][c];
		if (board[r][c] == 0) return 0;
		
		if (check(r + board[r][c], c)) {
			dp[r][c] += solution(r + board[r][c], c);
		}
		if (check(r, c + board[r][c])) {
			dp[r][c] += solution(r, c + board[r][c]);
		}
		
		return dp[r][c];
	}
	
	static boolean check(int r, int c) {
		if (r >= n || c >= n) return false;
		return true;
	}

}
