package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1937 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n;
	static int[][] forest;
	static int[][] dp;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];
		
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				answer = Math.max(answer, panda(i, j, forest[i][j]));
			}
		}
		
		System.out.println(answer);
	}

	static int panda(int r, int c, int bamboo) {
		if (dp[r][c] != 0) return dp[r][c];
		
		dp[r][c] = 1;
		for (int i=0;i<4;i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			
			if (!check(nextR, nextC) || forest[nextR][nextC] <= bamboo) {
				continue;
			}
			
			dp[r][c] = Math.max(dp[r][c], panda(nextR, nextC, forest[nextR][nextC]) + 1);
		}
		
		return dp[r][c];
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= n) return false;
		return true;
	}
}
